package it.asansonne.authhub.util;

import it.asansonne.authhub.model.jpa.User;
import lombok.AllArgsConstructor;
import org.jeasy.random.EasyRandom;

@AllArgsConstructor
public class DataBuilder {
  private static EasyRandom easyRandom;

  public static User makePerson(Boolean isActive) {
    User person = easyRandom.nextObject(User.class);
    person.setIsActive(isActive);
    person.setEmail(
        person.getName().substring(0, 3).toLowerCase()
            + person.getSurname().toLowerCase() +
            "@cybsec.it");
    return person;
  }

}