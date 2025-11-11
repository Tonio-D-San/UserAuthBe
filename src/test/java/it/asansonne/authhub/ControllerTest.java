package it.asansonne.authhub;

import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Controller Test")
public interface ControllerTest {
    String API = "/ala";
    String VERSION = "/v1";
    String EMAIL = "/emails";
    String EMPLOYEE = "/employees";
    String JOBPOSITION = "/job-positions";
    String LEGALENTITY = "/legal-entities";
    String PERSON = "/persons";
    String TELEPHONE = "/telephones";
    String TRAINEE = "/trainees";
}
