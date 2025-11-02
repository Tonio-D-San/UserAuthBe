package it.asansonne.authhub;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "it.asansonne")
@EnableJpaRepositories(basePackages = "it.asansonne.authhub.ccsr.repository")
@EntityScan(basePackages = {"it.asansonne.authhub.model", "it.asansonne.management.model"})
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthHubApplication {
  static void main(String[] args) {
    SpringApplication.run(AuthHubApplication.class, args);
  }
}
