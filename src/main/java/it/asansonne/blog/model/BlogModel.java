package it.asansonne.blog.model;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@SuperBuilder
@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
public abstract class BlogModel extends BlogBaseModel {
  @Column(nullable = false, length = 200)
  private String title;

  @Column(name = "content_md", nullable = false, columnDefinition = "TEXT")
  private String contentMd;

  @Column(nullable = false, length = 20)
  private String status;

}
