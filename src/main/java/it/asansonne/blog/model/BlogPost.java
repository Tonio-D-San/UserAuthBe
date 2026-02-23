package it.asansonne.blog.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Entity
@Table(name = "blog_post")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BlogPost extends BlogModel {
  @Column(columnDefinition = "TEXT")
  private String excerpt;

  @Column(name = "cover_url", columnDefinition = "TEXT")
  private String coverUrl;

  @Column(name = "author_name", length = 120)
  private String authorName;

  @ManyToMany
  @JoinTable(
      name = "blog_post_tag",
      joinColumns = @JoinColumn(name = "post_id"),
      inverseJoinColumns = @JoinColumn(name = "tag_id")
  )
  private List<BlogTag> tags;

}
