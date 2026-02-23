package it.asansonne.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Entity
@Table(name = "blog_tag")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class BlogTag extends BlogBaseModel {
  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @JsonIgnore
  @ManyToMany(
      mappedBy = "tags",
      fetch = FetchType.LAZY
  )
  private List<BlogPost> posts;

  @JsonIgnore
  @ManyToMany(
      mappedBy = "tags",
      cascade = {CascadeType.MERGE, CascadeType.REFRESH}
  )
  private List<BlogPage> pages;
}
