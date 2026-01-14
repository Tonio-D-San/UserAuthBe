package it.asansonne.management.ccsr.service.dashboard.impl;

import it.asansonne.management.ccsr.repository.BagRepository;
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
import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BagServiceImpl implements BagService {
  private final BagRepository bagRepository;
  private final BagMapper bagMapper;
  private final MoneyMapper moneyMapper;
  private final ReagentMapper reagentMapper;

  @Override
  public Optional<Bag> findByUuid(UUID uuid) {
    return bagRepository.findByUuid(uuid);
  }

  @Override
  public Page<Bag> findAll(Pageable pageable, Locale locale) {
    Page<Bag> bags = bagRepository.findAll(pageable);
    if (bags.isEmpty()) {
      throw new EntityNotFoundException("bag.empty");
    }
    return bags;
  }

  @Override
  public Page<Bag> findAllByField(Pageable pageable) {
    return bagRepository.findAll(pageable);
  }

  @Override
  public Page<Bag> findByIsActive(Pageable pageable, Boolean isActive) {
    Page<Bag> bags = bagRepository.findAllByIsActive(isActive, pageable);
    if (bags.isEmpty()) {
      throw new EntityNotFoundException(
          Boolean.TRUE.equals(isActive) ? "bag.active.empty" : "bag.inactive.empty"
      );
    }
    return bags;
  }

  @Override
  public Bag create(Bag model) {

//    List<Money> money = new ArrayList<>();
//    if (request != null && request.getMoney() != null) {
//      for (MoneyRequest mr : request.getMoney()) {
//        Money m = moneyMapper.toModel(mr);
//        if (m != null) {
//          m.setBag(bag);
//          money.add(m);
//        }
//      }
//    }
//
//    List<Reagent> reagents = new ArrayList<>();
//    if (request != null && request.getReagents() != null) {
//      for (ReagentRequest rr : request.getReagents()) {
//        Reagent r = reagentMapper.toModel(rr);
//        if (r != null) {
//          r.setBag(bag);
//          reagents.add(r);
//        }
//      }
//    }
//
//    bag.setMoney(money);
//    bag.setReagents(reagents);
    return bagRepository.save(model);
  }

  @Override
  public void update(Bag model) {
    bagRepository.save(model);
  }
}
