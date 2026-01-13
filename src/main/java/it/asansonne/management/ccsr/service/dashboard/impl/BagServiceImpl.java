package it.asansonne.management.ccsr.service.dashboard.impl;

import it.asansonne.management.ccsr.service.dashboard.BagService;
import it.asansonne.management.dto.request.BagRequest;
import it.asansonne.management.dto.request.MoneyRequest;
import it.asansonne.management.dto.request.ReagentRequest;
import it.asansonne.management.mapper.impl.BagMapper;
import it.asansonne.management.mapper.impl.MoneyMapper;
import it.asansonne.management.mapper.impl.ReagentMapper;
import it.asansonne.management.model.Bag;
import it.asansonne.management.model.Money;
import it.asansonne.management.model.Reagent;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BagServiceImpl implements BagService {

  private final BagMapper bagMapper;
  private final MoneyMapper moneyMapper;
  private final ReagentMapper reagentMapper;

  public BagServiceImpl(BagMapper bagMapper, MoneyMapper moneyMapper, ReagentMapper reagentMapper) {
    this.bagMapper = bagMapper;
    this.moneyMapper = moneyMapper;
    this.reagentMapper = reagentMapper;
  }

  @Override
  public Bag build(String characterName, BagRequest request) {
    Bag bag = request == null ? Bag.builder().build() : bagMapper.toModel(request);

    // reasonable defaults
    if (bag.getName() == null || bag.getName().isBlank()) {
      bag.setName("Zaino di " + (characterName == null ? "PG" : characterName));
    }

    List<Money> money = new ArrayList<>();
    if (request != null && request.getMoney() != null) {
      for (MoneyRequest mr : request.getMoney()) {
        Money m = moneyMapper.toModel(mr);
        if (m != null) {
          m.setBag(bag);
          money.add(m);
        }
      }
    }

    List<Reagent> reagents = new ArrayList<>();
    if (request != null && request.getReagents() != null) {
      for (ReagentRequest rr : request.getReagents()) {
        Reagent r = reagentMapper.toModel(rr);
        if (r != null) {
          r.setBag(bag);
          reagents.add(r);
        }
      }
    }

    bag.setMoney(money);
    bag.setReagents(reagents);
    return bag;
  }
}
