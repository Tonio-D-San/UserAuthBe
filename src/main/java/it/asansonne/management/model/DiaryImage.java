package it.asansonne.management.model;

import it.asansonne.authhub.model.Models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Entity
@Table(name = "diary_image")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
public class DiaryImage implements Models {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  @ToString.Exclude
  private Integer id;

  @Column(name = "uuid", nullable = false, unique = true, columnDefinition = "UUID")
  private UUID uuid;

  @Column(name = "image_data", columnDefinition = "BYTEA")
  private byte[] imageData;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "diary_image_paragraph",
      joinColumns = @JoinColumn(name = "diary_image_id"),
      inverseJoinColumns = @JoinColumn(name = "paragraph_id")
  )
  private List<Paragraph> paragraphs;
}
