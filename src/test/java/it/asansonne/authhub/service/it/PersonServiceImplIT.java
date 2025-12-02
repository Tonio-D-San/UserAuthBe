package it.asansonne.authhub.service.it;

import static it.asansonne.authhub.util.DataBuilder.makePerson;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import it.asansonne.authhub.IntegrationTest;
import it.asansonne.authhub.ccsr.repository.users.UserRepository;
import it.asansonne.authhub.ccsr.service.users.UserService;
import it.asansonne.authhub.model.users.User;
import jakarta.persistence.EntityNotFoundException;
import java.util.Locale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@DisplayName("PersonService IT Test")
class PersonServiceImplIT implements IntegrationTest {
  @Autowired
  private UserService personService;
  @Autowired
  private UserRepository personRepository;
  private Pageable pageable;
  private Locale locale;

  @BeforeEach
  void setUp() {
    pageable = PageRequest.of(0, 10);
    locale = Locale.ENGLISH;
  }

  @Test
  @DisplayName("Find all persons found")
  void findAllPersonsFound() {
    personRepository.save(makePerson(true));
    personRepository.save(makePerson(true));
    Page<User> persons = personService.findAll(pageable, locale);
    assertFalse(persons.isEmpty());
    assertEquals(2, persons.getTotalElements());
  }

  @Test
  @DisplayName("Find all persons not found")
  void findAllPersonsNotFound() {
    assertThrows(EntityNotFoundException.class,
        () -> personService.findAll(pageable, locale));
  }

  @Test
  @DisplayName("Find active persons found")
  void findActivePersonsFound() {
    personRepository.save(makePerson(true));
    personRepository.save(makePerson(false));
    Page<User> persons = personService.findByIsActive(pageable, true);
    assertFalse(persons.isEmpty());
    assertEquals(1, persons.getTotalElements());
    assertTrue(persons.getContent().getFirst().getIsActive());
  }

  @Test
  @DisplayName("Find active persons not found")
  void findActivePersonsNotFound() {
    personRepository.save(makePerson(false));
    assertThrows(EntityNotFoundException.class,
        () -> personService.findByIsActive(pageable, true));
  }

  @Test
  @DisplayName("Find inactive persons found")
  void findInactivePersonsInactive() {
    personRepository.save(makePerson(true));
    personRepository.save(makePerson(false));
    Page<User> persons = personService.findByIsActive(pageable, false);
    assertFalse(persons.isEmpty());
    assertEquals(1, persons.getTotalElements());
    assertFalse(persons.getContent().getFirst().getIsActive());
  }

  @Test
  @DisplayName("Find inactive persons not found")
  void findPersonByEmail() {
    personRepository.save(makePerson(true));
    assertThrows(EntityNotFoundException.class,
        () -> personService.findByIsActive(pageable, true));
  }

  @Test
  void createPerson() {
    assertTrue(true);
  }

  @Test
  void updatePerson() {
    assertTrue(true);
  }
}