package it.asansonne.blog.ccsr.repository;

import it.asansonne.blog.model.BlogPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPageRepository extends
    BlogRepository<BlogPage> {
  @Override
  @EntityGraph(attributePaths = "tags")
  @Query("""
          select p from BlogPage p
          where p.status = :status
          order by p.createdAt desc
      """)
  Page<BlogPage> findPublishedWithTags(
      @Param("status") String status,
      Pageable pageable
  );

  @Override
  @Query("""
          select distinct p from BlogPage p
          join p.tags t
          where p.status = :status and t.slug = :tagSlug
          order by p.createdAt desc
      """)
  Page<BlogPage> findByStatusAndTagSlug(
      @Param("status") String status,
      @Param("tagSlug") String tagSlug,
      Pageable pageable
  );

  @Override
  @Query(value = """
      select *
      from blog_post p
      where p.status = :status
        and p.search_tsv @@ websearch_to_tsquery('simple', :q)
      order by ts_rank(p.search_tsv, websearch_to_tsquery('simple', :q)) desc,
               p.created_at desc
      """,
      countQuery = """
          select count(*)
          from blog_post p
          where p.status = :status
            and p.search_tsv @@ websearch_to_tsquery('simple', :q)
          """,
      nativeQuery = true
  )
  Page<BlogPage> searchPublished(
      @Param("status") String status,
      @Param("q") String q,
      Pageable pageable
  );
}


