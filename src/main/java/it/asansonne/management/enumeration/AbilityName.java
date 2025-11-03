package it.asansonne.management.enumeration;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AbilityName implements Name {
  CARTOGRAPHER(
      "cartographer.name",
      "crt",
      "cartographer.description",
      null,
      null
  ) {
    @Override
    public String description() {
      return getDescription();
    }

    @Override
    public List<AbilityName> requirement() {
      return getRequirement();
    }
  },
  MARSHAL(
      "marshall.name",
      "msh",
      "marshall.description",
      List.of("marshall.note"),
      null
  ) {
    @Override
    public String description() {
      return String.format("%s. Nota: %s", getDescription(), getNote());
    }

    @Override
    public List<AbilityName> requirement() {
      return getRequirement();
    }
  },
  HERMETIC_CIPHER(
      "hermetic_cipher.name",
      "hc",
      "hermetic_cipher.description",
      null,
      null
  ) {
    @Override
    public String description() {
      return getDescription();
    }

    @Override
    public List<AbilityName> requirement() {
      return getRequirement();
    }
  },
  COLLECTOR(
      "collector.name",
      "clt",
      "collector.description",
      null,
      null) {
    @Override
    public String description() {
      return getDescription();
    }

    @Override
    public List<AbilityName> requirement() {
      return getRequirement();
    }
  },
  CONSTITUTION(
      "constitution.name",
      "cd",
      "constitution.description",
      null,
      null) {
    @Override
    public String description() {
      return getDescription();
    }

    @Override
    public List<AbilityName> requirement() {
      return getRequirement();
    }
  },
  IMPROVED_CONSTITUTION(
      "improved_constitution.name",
      "icd",
      "improved_constitution.description",
      null,
      List.of(CONSTITUTION)
  ) {
    @Override
    public String description() {
      return getDescription();
    }

    @Override
    public List<AbilityName> requirement() {
      return getRequirement();
    }
  },
  DISARM_TRAPS(
      "disarm_traps.name",
      "dt",
      "disarm_traps.description",
      null,
      null
  ) {
    @Override
    public String description() {
      return getDescription();
    }

    @Override
    public List<AbilityName> requirement() {
      return getRequirement();
    }
  },
  LOST_LANGUAGES_ONE(
      "lost_languages_one.name",
      "ll1",
      "lost_languages.description",
      null,
      null
  ) {
    @Override
    public String description() {
      return getDescription();
    }

    @Override
    public List<AbilityName> requirement() {
      return getRequirement();
    }
  },
  LOST_LANGUAGES_TWO(
      "lost_languages_two.name",
      "ll2",
      "lost_languages.description",
      null,
      List.of(LOST_LANGUAGES_ONE)
  ) {
    @Override
    public String description() {
      return getDescription();
    }

    @Override
    public List<AbilityName> requirement() {
      return getRequirement();
    }
  },
  LOST_LANGUAGES_THREE(
      "lost_languages_three.name",
      "ll3",
      "lost_language.description",
      null,
      List.of(LOST_LANGUAGES_TWO)
  ) {
    @Override
    public String description() {
      return getDescription();
    }

    @Override
    public List<AbilityName> requirement() {
      return getRequirement();
    }
  },
  SECRET_LANGUAGES_ONE(
      "secret_languages_one.name",
      "sl",
      Constants.SECRET_LANGUAGES_DESCRIPTION,
      null,
      null
  ) {
    @Override
    public String description() {
      return getDescription();
    }

    @Override
    public List<AbilityName> requirement() {
      return getRequirement();
    }
  },
  SECRET_LANGUAGES_TWO(
      "secret_languages_two.name",
      "sl2",
      Constants.SECRET_LANGUAGES_DESCRIPTION,
      null,
      List.of(SECRET_LANGUAGES_ONE)
  ) {
    @Override
    public String description() {
      return getDescription();
    }

    @Override
    public List<AbilityName> requirement() {
      return getRequirement();
    }
  },
  SECRET_LANGUAGES_THREE(
      "secret_languages_three.name",
      "sl3",
      Constants.SECRET_LANGUAGES_DESCRIPTION,
      null,
      List.of(SECRET_LANGUAGES_TWO)
  ) {
    @Override
    public String description() {
      return getDescription();
    }

    @Override
    public List<AbilityName> requirement() {
      return getRequirement();
    }
  },
  QUICK_HAND(
      "quick_hand.name",
      "qh",
      "quick_hand.description",
      null,
      null
  ) {
    @Override
    public String description() {
      return getDescription();
    }

    @Override
    public List<AbilityName> requirement() {
      return getRequirement();
    }
  },
  MYTHS_LEGENDS_ONE(
      "myths_legends_one.name",
      "ml1",
      Constants.MYTHS_LEGENDS_DESCRIPTION,
      null,
      null
  ) {
    @Override
    public String description() {
      return getDescription();
    }

    @Override
    public List<AbilityName> requirement() {
      return getRequirement();
    }
  },
  MYTHS_LEGENDS_TWO(
      "myths_legends_two.name",
      "ml2",
      Constants.MYTHS_LEGENDS_DESCRIPTION,
      null,
      List.of(MYTHS_LEGENDS_ONE)
  ) {
    @Override
    public String description() {
      return getDescription();
    }

    @Override
    public List<AbilityName> requirement() {
      return getRequirement();
    }
  },
  MYTHS_LEGENDS_THREE(
      "myths_legends_three.name",
      "ml3",
      Constants.MYTHS_LEGENDS_DESCRIPTION,
      null,
      List.of(MYTHS_LEGENDS_TWO)
  ) {
    @Override
    public String description() {
      return getDescription();
    }

    @Override
    public List<AbilityName> requirement() {
      return getRequirement();
    }
  },
  TENACITY(
      "tenacity.name",
      "tn",
      "tenacity.description",
      List.of("tenacity.note_one", "tenacity.note_two"),
      List.of(IMPROVED_CONSTITUTION)
  ) {
    @Override
    public String description() {
      return getDescription();
    }

    @Override
    public List<AbilityName> requirement() {
      return getRequirement();
    }
  },
  TENACIOUS_VOICE(
      "tenacious_voice.name",
      "tv",
      "tenacious_voice.description",
      null,
      List.of(TENACITY)
  ) {
    @Override
    public String description() {
      return getDescription();
    }

    @Override
    public List<AbilityName> requirement() {
      return getRequirement();
    }
  },
  TENACIOUS_STEP(
      "tenacious_step.name",
      "ts",
      "tenacious_step.description",
      null,
      List.of(TENACIOUS_VOICE)
  ) {
    @Override
    public String description() {
      return getDescription();
    }

    @Override
    public List<AbilityName> requirement() {
      return getRequirement();
    }
  },
  PERCEIVING_MAGIC(
      "perceiving_magic.name",
      "pm",
      "perceiving_magic.description",
      null,
      null
  ) {
    @Override
    public String description() {
      return getDescription();
    }

    @Override
    public List<AbilityName> requirement() {
      return getRequirement();
    }
  },
//  REFINE_ALATHIUM(
//      "refine_alathium.name",
//      "ra",
//      "refine_alathium.description",
//      null,
//      RequirementType.OR,
//      List.of(ALCHEMY_ONE, CRAFTSMAN)
//  ) {
//    @Override
//    public String description() {
//      return getDescription();
//    }
//
//    @Override
//    public List<AbilityName> requirement() {
//      return getRequirement();
//    }
//  },
  LOCKPICKING(
      "lockpicking.name",
      "lk",
      "lockpicking.description",
      null,
      null
  ) {
    @Override
    public String description() {
      return getDescription();
    }

    @Override
    public List<AbilityName> requirement() {
      return getRequirement();
    }
  },
  EVALUATE(
      "evaluate.name",
      "ev",
      "evaluate.description",
      null,
      null
  ) {
    @Override
    public String description() {
      return getDescription();
    }

    @Override
    public List<AbilityName> requirement() {
      return getRequirement();
    }
  },
  RITUAL_VECTOR(
      "ritual_vector.name",
      "rv",
      "ritual_vector.description",
      null,
      null
  ) {
    @Override
    public String description() {
      return getDescription();
    }

    @Override
    public List<AbilityName> requirement() {
      return getRequirement();
    }
  },
  ;

  private final String name;
  private final String abbreviation;
  private final String description;
  private final List<String> note;
  private final List<AbilityName> requirement;

  public abstract String description();

  public abstract List<AbilityName> requirement();

  private static class Constants {
    public static final String SECRET_LANGUAGES_DESCRIPTION = "secret_languages.description";
    public static final String MYTHS_LEGENDS_DESCRIPTION = "myths_legends.description";
  }
}
