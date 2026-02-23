package it.asansonne.authhub.model.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.asansonne.authhub.converter.GroupNameConverter;
import it.asansonne.authhub.enumeration.GroupName;
import it.asansonne.authhub.model.BaseModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
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

/**
 * The type Group.
 */
@Builder
@Entity
@Table(name = "groups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Group extends BaseModel {
  @Column(name = "name", nullable = false, length = 50)
  @Convert(converter = GroupNameConverter.class)
  private GroupName name;

  @Column(name = "path", nullable = false, length = 50)
  private String path;

  @Column(name = "description")
  private String description;

  @JsonIgnore
  @ManyToMany(mappedBy = "groups", cascade = {CascadeType.MERGE, CascadeType.REFRESH})
  private List<User> users;
}
