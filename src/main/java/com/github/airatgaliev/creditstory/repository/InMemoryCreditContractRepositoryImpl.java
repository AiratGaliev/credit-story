package com.github.airatgaliev.creditstory.repository;

import com.github.airatgaliev.creditstory.model.CreditContract;
import java.util.ArrayList;
import java.util.List;

public class InMemoryCreditContractRepositoryImpl implements ICreditContractRepository {

  private final List<CreditContract> creditContracts = new ArrayList<>();

  @Override
  public void addCreditContract(CreditContract creditContract) {
    creditContracts.add(creditContract);
  }

  @Override
  public List<CreditContract> getAllCreditContracts() {
    return creditContracts;
  }
}
