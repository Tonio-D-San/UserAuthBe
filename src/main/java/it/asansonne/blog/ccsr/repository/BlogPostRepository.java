package it.asansonne.blog.ccsr.repository;

import it.asansonne.blog.model.BlogPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends
    BlogRepository<BlogPost> {
  @Override
  @EntityGraph(attributePaths = "tags")
  @Query("""
          select p from BlogPost p
          where p.status = :status
          order by p.createdAt desc
      """)
  Page<BlogPost> findPublishedWithTags(
      @Param("status") String status,
      Pageable pageable
  );

  @Override
  @Query("""
          select distinct p from BlogPost p
          join p.tags t
          where p.status = :status and t.slug = :tagSlug
          order by p.createdAt desc
      """)
  Page<BlogPost> findByStatusAndTagSlug(
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
  Page<BlogPost> searchPublished(
      @Param("status") String status,
      @Param("q") String q,
      Pageable pageable
  );

  @Override
  @Query(value = """
      select * from blog_post p
            where p.status = :status
            and p.slug like concat(:prefix, '%')
            order by p.created_at desc
      """,
      countQuery = """
          select count(*)
          from blog_post p
          where p.status = :status
            and p.slug like concat(:prefix, '%')
          """,
      nativeQuery = true
  )
  Page<BlogPost> searchByPrefix(
      @Param("status") String status,
      @Param("q") String prefix,
      Pageable pageable
  );

  @Query(value = """
      select *
      from blog_post p
      where p.status = :status
        and p.slug ilike concat('%', :q, '%')
      order by p.created_at desc
      """,
      countQuery = """
          select count(*)
          from blog_post p
          where p.status = :status
            and p.slug ilike concat('%', :q, '%')
          """,
      nativeQuery = true)
  Page<BlogPost> searchBySlugContains(
      @Param("status") String status,
      @Param("q") String q,
      Pageable pageable
  );

}


