package com.github.airatgaliev.creditstory;

import com.github.airatgaliev.creditstory.controller.CreditContractController;
import com.github.airatgaliev.creditstory.repository.ICreditContractRepository;
import com.github.airatgaliev.creditstory.repository.InMemoryCreditContractRepositoryImpl;
import com.github.airatgaliev.creditstory.view.ConsoleCreditContractView;
import com.github.airatgaliev.creditstory.view.ICreditContractView;

public class CreditStoryApp {

  public static void main(String[] args) {
    boolean isRestarted = true;
    while (isRestarted) {
      ICreditContractRepository creditContractRepository = new InMemoryCreditContractRepositoryImpl();
      ICreditContractView creditContractView = new ConsoleCreditContractView();
      CreditContractController creditContractController = new CreditContractController(
          creditContractRepository, creditContractView);
      creditContractController.getAllCreditContracts();
      creditContractController.createCreditContract();
      isRestarted = creditContractController.isRestartedInterpreter();
    }
  }
}
