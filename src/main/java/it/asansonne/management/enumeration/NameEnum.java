package it.asansonne.management.enumeration;

public interface NameEnum<T extends Enum<T> & Name> {
  static <E extends Enum<E> & Name> E fromName(Class<E> enumClass, String name) {
    for (E e : enumClass.getEnumConstants()) {
      if (e.getName().equalsIgnoreCase(name)) {
        return e;
      }
    }
    throw new IllegalArgumentException("Nessun valore trovato per: " + name);
  }
}

