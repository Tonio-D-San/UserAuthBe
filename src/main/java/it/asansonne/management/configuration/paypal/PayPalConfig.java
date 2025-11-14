package it.asansonne.management.configuration.paypal;

import static it.asansonne.management.enumeration.PayPalType.LIVE;

import com.paypal.core.PayPalEnvironment;
import com.paypal.core.PayPalHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PayPalConfig {

  @Value("${paypal.clientId}")
  private String clientId;

  @Value("${paypal.clientSecret}")
  private String clientSecret;

  @Value("${paypal.mode:sandbox}")
  private String mode;

  @Bean
  public PayPalHttpClient payPalClient() {
    PayPalEnvironment environment;
    if (LIVE.getType().equalsIgnoreCase(mode)) {
      environment = new PayPalEnvironment.Live(clientId, clientSecret);
    } else {
      environment = new PayPalEnvironment.Sandbox(clientId, clientSecret);
    }
    return new PayPalHttpClient(environment);
  }
}

