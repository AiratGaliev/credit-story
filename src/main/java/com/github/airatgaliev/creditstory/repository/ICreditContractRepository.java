package com.github.airatgaliev.creditstory.repository;

import com.github.airatgaliev.creditstory.model.CreditContract;
import java.util.List;

public interface ICreditContractRepository {

  void addCreditContract(CreditContract creditContract);

  List<CreditContract> getAllCreditContracts();
}
