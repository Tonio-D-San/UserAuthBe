# Modulo Blog (Post, Page, Tag) — come funziona

Questo documento descrive il modello “blog” basato su **Postgres + Spring** e consumato dal **FE (Next.js / public)**.  
L’obiettivo è avere contenuti pubblici modulari, riusabili e ricercabili, senza creare grafi JSON ricorsivi o endpoint ingestibili.

---

## 1) Panoramica

Il blog è composto da tre concetti:

- **BlogPost**: contenuto “articolo/news/evento”, tipicamente datato e listabile.
- **BlogPage**: contenuto “pagina” (istituzionale o indice/sezione), con URL stabile e non necessariamente orientato al tempo.
- **BlogTag**: etichette trasversali per classificare e filtrare Post e Page.

Dal lato API:
- `/public/**` espone contenuti leggibili da chiunque.
- `/admin/**` (o equivalente) gestisce create/update/delete dei contenuti (protetto da login/ruoli).

---

## 2) Differenza tra BlogPost e BlogPage

### BlogPost (articolo/news/evento)
Usalo quando:
- vuoi un contenuto in una **lista cronologica** (home blog, news)
- vuoi “scorrere” i contenuti per data (`publishedAt`)
- vuoi attributi tipici del post: `excerpt`, `coverUrl`, `authorName`

Esempi:
- “Memento”
- “Resoconto evento”
- “Comunicazione ufficiale”

URL tipico:
- `/blog/<slug>`

Campi chiave:
- `slug`: identificatore URL-friendly
- `title`: titolo
- `excerpt`: riassunto (opzionale)
- `contentMd`: contenuto in Markdown
- `publishedAt`: data pubblicazione (epoch millis)
- `status`: DRAFT / PUBLISHED (o più stati, se previsti)

---

### BlogPage (pagina / indice / sezione)
Usalo quando:
- vuoi contenuti “stabili” (chi siamo, privacy, contatti)
- vuoi pagine “indice” che aggregano link o spiegazioni (es. “Alarion Eventi”)
- vuoi sezioni con contenuto non necessariamente cronologico

Esempi:
- “Chi siamo”
- “Privacy”
- “Alarion Eventi” (pagina indice che linka più post evento)

URL tipico:
- `/pages/<slug>`

Campi chiave:
- `slug`: identificatore URL-friendly
- `title`
- `contentMd`
- `publishedAt`
- `status`

---

## 3) BlogTag: a cosa serve

**BlogTag** è una tassonomia semplice: ogni tag ha `name` e `slug` ed è collegabile a:
- molti Post
- molte Page

Relazione:
- `Post <-> Tag` = Many-to-Many (join table `blog_post_tag`)
- `Page <-> Tag` = Many-to-Many (join table `blog_page_tag`)

Scopi principali:
- filtrare i contenuti: “dammi tutti i post con tag `eventi`”
- raggruppare: “contenuti correlati”
- abilitare una ricerca/filtraggio unificato (post + pagine)

---

## 4) Lo “slug”: cos’è e perché esiste

Lo **slug** è un identificatore leggibile e “safe” per URL.

Esempio:
- Titolo: `Non tutte le ciambelle escono col buco`
- Slug: `non-tutte-le-ciambelle-escono-col-buco`

Regole tipiche:
- lowercase
- numeri e lettere
- `-` come separatore
- unico in DB (`UNIQUE`)

Motivo:
- URL stabili e condivisibili
- niente dipendenza da `id` interni
- migliore esperienza utente

---

## 5) Stati (status) e pubblicazione

Il sistema usa `status` per distinguere contenuti:
- `DRAFT`: bozza (non visibile nel pubblico)
- `PUBLISHED`: pubblicato (visibile sul pubblico)

(Se estendi lo schema: `ACTIVE`, `DEPRECATED`, ecc. funziona allo stesso modo, basta che le query pubbliche filtrino correttamente.)

Convenzione API:
- i controller pubblici filtrano `status = PUBLISHED`
- i controller admin possono vedere anche i draft

---

## 6) Perché evitare “DTO ricorsivi” (loop infinito)

Se fai:
- `PostResponse` contiene `TagResponse`
- `TagResponse` contiene `PostResponse`
- …si crea un loop (`post -> tags -> posts -> tags -> ...`) e l’output diventa infinito/immenso.

Soluzione consigliata:
- Response “light” per le relazioni:
    - nei Post/Page includi `tags` **light** (solo `slug`, `name`)
    - nei Tag includi `posts/pages` **summary** (senza reincludere tags completi)

Esempio:
- `BlogPostResponse` -> `tags: List<BlogTagResponseLight>`
- `BlogTagDetailsResponse` -> `posts: List<BlogPostSummaryResponse>`, `pages: List<BlogPageSummaryResponse>`

---

## 7) Endpoints pubblici tipici

Esempi (naming indicativo):

### Post
- `GET /public/posts`  
  Lista paginata dei post pubblicati, ordinata per `publishedAt DESC`
- `GET /public/posts/{slug}`  
  Dettaglio di un post

### Page
- `GET /public/pages/{slug}`  
  Dettaglio di una page

### Tag
- `GET /public/posts/by-tag/{tagSlug}`  
  Lista post filtrati per tag
- `GET /public/pages/by-tag/{tagSlug}`  
  Lista pagine filtrate per tag

---

## 8) Gestione creazione tag “inline” durante la creazione di un post

Caso d’uso: crei un post e nel body mandi `tagRequests` che possono essere:
- referenze per `uuid` (tag già esistenti)
- oppure tag nuovi (name + slug) da creare al volo

Regola pratica:
- se `uuid` presente: carica tag esistente (404 se non esiste)
- altrimenti: usa `slug` per “resolve or create”
    - se esiste tag con quello slug: usa quello
    - se non esiste: crealo (gestendo collisioni / unique constraint)

Tutto questo va fatto in una transazione (per consistenza).

---

## 9) Search full-text con `search_tsv` (Postgres)

Per una ricerca testuale veloce su Postgres:
- aggiungi colonna `search_tsv tsvector`
- riempila automaticamente con un trigger (title + excerpt + content_md)
- indicizzala con GIN

Poi puoi fare query tipo:
- `search_tsv @@ websearch_to_tsquery('simple', :q)`

Dove `q` è la stringa di ricerca dell’utente (es. `"memento evento"`), passata come query param (es. `?q=memento%20evento`).

---

## 10) Scelte progettuali chiave (riassunto)

- **Postgres** come storage: schema chiaro, indici, join, FTS.
- **Slug** come chiave pubblica: URL stabili.
- **Post vs Page** separati: riduci ambiguità e semplifichi routing.
- **Tag** su Post e Page: filtro e organizzazione trasversale.
- **DTO non ricorsivi**: niente loop, output controllato.
- **Public vs Admin**: pubblico read-only, admin CRUD protetto.
- **Search_tsv**: ricerca veloce senza Elasticsearch.

---