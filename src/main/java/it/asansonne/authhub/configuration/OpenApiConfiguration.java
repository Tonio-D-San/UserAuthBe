package it.asansonne.authhub.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Open api configuration.
 */
@Configuration
@OpenAPIDefinition(servers = {@Server(url = "http://localhost:8082", description = "AuthHub API")})
public class OpenApiConfiguration {
  @Value("${info.app.name}")
  private String appName;
  @Value("${google.link}")
  private String link;

  /**
   * Custom open api open api.
   *
   * @param appDescription the app description
   * @param appVersion     the app version
   * @return the open api
   */

  @Bean
  public OpenAPI customOpenApi(@Value("${info.app.description}") String appDescription,
                               @Value("${info.app.version}") String appVersion) {
    return new OpenAPI()
        .info(new Info()
            .version(appVersion)
            .title("🚀 " + appName)
            .description(appDescription +
              String.format(
                """
                  <div style="font-size: 15px; line-height: 1.5;">
                    <b>AuthHub</b> è il servizio centralizzato per gestire autenticazioni via Google e altri provider social.<br>
                    <ul>
                      <li>🔐 <a href='%s' target='_blank'>Login con Google</a></li>
                      <li>🔐 Login semplificato (OAuth2 Social)</li>
                      <li>🧩 Gestione utenti interna</li>
                      <li>📚 API documentate e pronte all’integrazione</li>
                    </ul>
                  </div>
                """, link)
            )
            .version("v" + appVersion)
            .contact(new Contact()
                .name("AuthHub Dev Team")
                .email("support@authhub.local")
                .url("https://github.com/asansonne/authhub"))
            .license(new License()
                .name("MIT License")
                .url("https://opensource.org/licenses/MIT"))
        ).externalDocs(new ExternalDocumentation()
            .description("Documentazione estesa e guide di integrazione")
            .url("https://github.com/asansonne/authhub/wiki")
        );
  }
}
