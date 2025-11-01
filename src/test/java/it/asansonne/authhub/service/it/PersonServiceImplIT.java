package it.asansonne.authhub.service.it;

import static it.asansonne.authhub.util.DataBuilder.makePerson;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import it.asansonne.authhub.IntegrationTest;
import it.asansonne.authhub.ccsr.repository.jpa.UserRepository;
import it.asansonne.authhub.ccsr.service.UserService;
import it.asansonne.authhub.model.jpa.User;
import jakarta.persistence.EntityNotFoundException;
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

  @BeforeEach
  void setUp() {
    pageable = PageRequest.of(0, 10);
  }

  @Test
  @DisplayName("Find all persons found")
  void findAllPersonsFound() {
    personRepository.save(makePerson(true));
    personRepository.save(makePerson(true));
    Page<User> persons = personService.findAllUsers(pageable);
    assertFalse(persons.isEmpty());
    assertEquals(2, persons.getTotalElements());
  }

  @Test
  @DisplayName("Find all persons not found")
  void findAllPersonsNotFound() {
    assertThrows(EntityNotFoundException.class,
        () -> personService.findAllUsers(pageable));
  }

  @Test
  @DisplayName("Find active persons found")
  void findActivePersonsFound() {
    personRepository.save(makePerson(true));
    personRepository.save(makePerson(false));
    Page<User> persons = personService.findActiveUsers(true, pageable);
    assertFalse(persons.isEmpty());
    assertEquals(1, persons.getTotalElements());
    assertTrue(persons.getContent().getFirst().getIsActive());
  }

  @Test
  @DisplayName("Find active persons not found")
  void findActivePersonsNotFound() {
    personRepository.save(makePerson(false));
    assertThrows(EntityNotFoundException.class,
        () -> personService.findActiveUsers(true, pageable));
  }

  @Test
  @DisplayName("Find inactive persons found")
  void findInactivePersonsInactive() {
    personRepository.save(makePerson(true));
    personRepository.save(makePerson(false));
    Page<User> persons = personService.findInactiveUsers(pageable);
    assertFalse(persons.isEmpty());
    assertEquals(1, persons.getTotalElements());
    assertFalse(persons.getContent().getFirst().getIsActive());
  }

  @Test
  @DisplayName("Find inactive persons not found")
  void findPersonByEmail() {
    personRepository.save(makePerson(true));
    assertThrows(EntityNotFoundException.class,
        () -> personService.findInactiveUsers(pageable));
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