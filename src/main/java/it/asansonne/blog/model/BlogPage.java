package it.asansonne.blog.model;

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
@Table(name = "blog_page")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BlogPage extends BlogModel {
  @ManyToMany
  @JoinTable(
      name = "blog_page_tag",
      joinColumns = @JoinColumn(name = "page_id"),
      inverseJoinColumns = @JoinColumn(name = "tag_id")
  )
  private List<BlogTag> tags;

}
