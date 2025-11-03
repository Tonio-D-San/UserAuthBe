package it.asansonne.management.configuration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.asansonne.management.ccsr.repository.AbilityDefinitionRepository;
import it.asansonne.management.model.AbilityDefinition;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AbilitySeeder implements CommandLineRunner {
  private final AbilityDefinitionRepository repo;
  private final ObjectMapper mapper;

  @Override
  public void run(String... args) throws Exception {
    if (repo.count() == 0) {
      List<AbilityDefinition> defs = mapper.readValue(
          new ClassPathResource("abilities.json").getFile(),
          new TypeReference<>() {}
      );
      repo.saveAll(defs);
    }
  }
}
