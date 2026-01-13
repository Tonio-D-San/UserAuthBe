package it.asansonne.management.ccsr.service.dashboard.impl;

import it.asansonne.management.ccsr.service.dashboard.CardService;
import it.asansonne.management.dto.request.CardRequest;
import it.asansonne.management.model.Ability;
import it.asansonne.management.model.Card;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

  @Override
  public Card build(CardRequest request, List<Ability> abilities) {
    if (request == null) {
      throw new IllegalArgumentException("Card request is required");
    }
    if (request.getTotalPoints() == null) {
      throw new IllegalArgumentException("totalPoints is required");
    }

    int totalPoints = request.getTotalPoints();
    int abilityCost = request.getAbilityCost() == null ? 3 : request.getAbilityCost();
    int minSpend = request.getMinSpendPoints() == null ? 15 : request.getMinSpendPoints();
    int freeAbilities = request.getFreeAbilities() == null ? 0 : request.getFreeAbilities();

    int abilitiesCount = abilities == null ? 0 : abilities.size();
    int paidAbilities = Math.max(0, abilitiesCount - freeAbilities);
    int usedPoints = Math.multiplyExact(paidAbilities, abilityCost);

    if (usedPoints < minSpend) {
      throw new IllegalArgumentException(
          "Not enough points spent: " + usedPoints + " (minimum required: " + minSpend + ")"
      );
    }
    if (usedPoints > totalPoints) {
      throw new IllegalArgumentException(
          "Too many points spent: " + usedPoints + " (total available: " + totalPoints + ")"
      );
    }

    return Card.builder()
        .totalPoints(totalPoints)
        .usedPoints(usedPoints)
        .availablePoints(totalPoints - usedPoints)
        .build();
  }
}
