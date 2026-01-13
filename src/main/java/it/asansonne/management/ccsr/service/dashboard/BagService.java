package it.asansonne.management.ccsr.service.dashboard;

import it.asansonne.management.dto.request.BagRequest;
import it.asansonne.management.model.Bag;

public interface BagService {
  /**
   * Builds a Bag (possibly empty). Money/Reagents (if present) are attached to the Bag.
   */
  Bag build(String characterName, BagRequest request);
}
