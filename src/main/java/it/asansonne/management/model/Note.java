package it.asansonne.management.model;

import it.asansonne.authhub.model.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Entity
@Table(name = "notes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Note extends BaseModel {
  @Column(name = "note", columnDefinition = "TEXT")
  private String text;

  @ManyToMany(mappedBy = "notes")
  private List<Ability> abilities;

}
