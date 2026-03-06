package it.asansonne.diary.model;

import it.asansonne.common.ccsr.model.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@ToString
public class DiaryImage extends BaseModel {
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
