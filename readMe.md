# 📘 Character Management – Data-Driven Core

## Scopo del progetto

Questo progetto implementa un **motore generico e data-driven** per la gestione di personaggi di gioco (LARP, GdR, ecc.).

L’obiettivo NON è codificare un regolamento specifico, ma fornire:

* un **core flessibile**
* completamente **configurabile da database**
* estendibile nel tempo (inventario, effetti, crafting, snapshot…)

Il sistema è progettato per **evitare enum, stati duplicati e logica implicita**.

---

## Principi architetturali fondamentali

### 1. Data-Driven

Tutto ciò che è “regola” (abilità, costi, punti, prerequisiti, training, reami) è **dato**, non codice.

👉 Cambiare una regola **non richiede deploy**.

---

### 2. Separazione netta dei layer (CCSR)

* **Controller**
  Espone solo API + Swagger. Nessuna logica.
* **Component**
  Orchestrazione, mapping DTO, join tra entità.
* **Service**
  Logica di business (punti, prerequisiti, validazioni).
* **Repository**
  Accesso diretto al database.
* **Model**
  Strutture di persistenza pure (solo campi + id).

---

### 3. Model senza relazioni JPA

I model **non contengono `@ManyToOne` o `@OneToMany`**.

Ogni relazione è rappresentata solo tramite:

```text
<entity>_id (BIGINT)
```

👉 Le join avvengono **solo nei Component**, mai in automatico.

---

### 4. UUID ≠ FK

Ogni tabella ha:

* `id` (BIGINT) → relazioni DB
* `uuid` (UUID) → esposizione API / Component

Gli UUID **non sono mai usati come Foreign Key**.

---

### 5. Nessuno stato derivato salvato

Valori come:

* punti disponibili
* scheda personaggio
* riepiloghi

👉 **non sono salvati**, ma **calcolati** (es. tramite ledger).

---

## BaseModel (ereditato da tutte le entity)

Ogni entità estende `BaseModel` e possiede:

| Campo        | Descrizione                  |
| ------------ | ---------------------------- |
| `id`         | Primary key tecnica (BIGINT) |
| `uuid`       | Identificatore pubblico      |
| `created_at` | Timestamp creazione          |
| `updated_at` | Timestamp ultimo update      |
| `is_active`  | Soft delete / disattivazione |

---

## 📦 Entità di catalogo (Regolamento)

### `rulesets`

Rappresenta una **versione di regolamento**.

Contiene le regole globali:

* punti iniziali
* punti da spendere obbligatoriamente
* eventuali limiti

Un personaggio **nasce sempre dentro un ruleset**.

---

### `realms`

Rappresenta un **reame / fazione / cultura**.

* Appartiene a un ruleset
* È una scelta narrativa, non meccanica
* Serve per ambientazione, background, filtri

---

### `abilities`

Catalogo delle **abilità disponibili**.

Contiene:

* codice stabile (`code`)
* nome e descrizione
* se è ripetibile
* rank massimo

Non contiene **costi** né **prerequisiti** (sono separati).

---

### `ability_costs`

Definisce **quanto costa un’abilità**.

* Un costo per rank
* Totalmente configurabile
* Permette abilità con progressione

---

### `ability_prerequisites`

Definisce le **dipendenze tra abilità**.

Esempio:

> Per prendere “Maestro d’Armi” serve “Combattimento” rank 2

Serve per:

* validazione acquisti
* UI guidata

---

### `trainings`

Rappresenta una **formazione / origine / background meccanico**.

* Appartiene a un ruleset
* Fornisce bonus iniziali

---

### `training_ability_grants`

Definisce **quali abilità un training concede gratuitamente**.

* Senza costo punti
* Con rank specifico

---

### `acquisition_sources`

Sostituisce completamente gli enum.

Definisce **come un’abilità è stata ottenuta**:

* acquistata
* concessa
* assegnata da admin

Serve per:

* auditing
* logica futura (respec, rimozioni)

---

## 🧙 Personaggio

### `characters`

Rappresenta il **personaggio base**.

Contiene solo:

* riferimenti (ruleset, realm, training, user)
* nome
* background testuale

NON contiene:

* punti
* abilità
* stato calcolato

---

### `character_abilities`

Join tra personaggio e abilità.

Contiene:

* abilità
* rank
* sorgente
* **costo pagato (snapshot)**

Il costo viene salvato per:

* garantire consistenza storica
* permettere cambio regole senza rompere personaggi esistenti

---

## 🧮 Sistema punti (Ledger)

### `point_transactions`

È il **cuore del sistema punti**.

Ogni variazione è una riga:

* punti iniziali
* spesa abilità
* grant
* modifiche admin

Il saldo NON è salvato:

```text
saldo = SUM(delta)
```

👉 Questo elimina:

* campi `total_points`
* inconsistenze
* bug di sincronizzazione

---

## ❌ Cosa NON esiste (per scelta)

| Elemento      | Motivo                               |
| ------------- | ------------------------------------ |
| `cards`       | La scheda è una vista, non uno stato |
| `bags`        | Inventory non ancora stabilizzato    |
| `effects`     | Dipendono da abilità e oggetti       |
| enum Java     | Sostituiti da tabelle                |
| relazioni JPA | Join esplicite nei Component         |

---

## 🧩 Estendibilità futura

Il modello è progettato per accogliere:

* Inventory minimal (`items`, `character_items`)
* Effects system (`effects`, `character_effects`)
* Snapshot scheda (`character_snapshots`)
* Eventi e crafting

---
