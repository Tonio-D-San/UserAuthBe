package it.asansonne.authhub;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthHubApplication {

  static void main(String[] args) {
    SpringApplication.run(AuthHubApplication.class, args);
  }

}
