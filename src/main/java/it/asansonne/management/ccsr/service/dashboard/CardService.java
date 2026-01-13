package it.asansonne.management.ccsr.service.dashboard;

import it.asansonne.management.dto.request.CardRequest;
import it.asansonne.management.model.Ability;
import it.asansonne.management.model.Card;
import java.util.List;

public interface CardService {

  /**
   * Builds a Card applying the points rules:
   * - usedPoints = paidAbilities * abilityCost
   * - paidAbilities = max(0, abilities.size() - freeAbilities)
   * - usedPoints must be >= minSpendPoints
   * - usedPoints must be <= totalPoints
   */
  Card build(CardRequest request, List<Ability> abilities);
}
