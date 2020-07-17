package com.github.airatgaliev.creditstory.controller;

import com.github.airatgaliev.creditstory.model.CreditContract;
import com.github.airatgaliev.creditstory.model.CreditStory;
import com.github.airatgaliev.creditstory.repository.ICreditContractRepository;
import com.github.airatgaliev.creditstory.service.CreditStoryInterpreterService;
import com.github.airatgaliev.creditstory.view.ICreditContractView;
import java.util.ArrayList;
import java.util.List;

public class CreditContractController {

  private final ICreditContractRepository creditContractRepository;
  private final ICreditContractView creditContractView;
  private final CreditStoryInterpreterService creditStoryInterpreterService = new CreditStoryInterpreterService();

  public CreditContractController(
      ICreditContractRepository creditContractRepository,
      ICreditContractView creditContractView) {
    this.creditContractRepository = creditContractRepository;
    this.creditContractView = creditContractView;
  }

  public void createCreditContract() {
    creditContractView.printCreditContractInfoRequest();
    List<Character> paymentDiscipline = getPaymentDiscipline();
    CreditStory creditStory = creditStoryInterpreterService
        .getCreditStoryFromPaymentDiscipline(paymentDiscipline);
    CreditContract creditContract = new CreditContract(paymentDiscipline, creditStory);
    creditContractRepository.addCreditContract(creditContract);
    creditContractView.printCreditContractInfoResponse(creditContract);
  }

  public void getAllCreditContracts() {
    List<CreditContract> creditContracts = creditContractRepository.getAllCreditContracts();
    if (!creditContracts.isEmpty()) {
      creditContractView.printAllCreditContracts(creditContracts);
    }
  }

  private List<Character> getPaymentDiscipline() {
    List<Character> paymentDiscipline = new ArrayList<>();
    String paymentDisciplineString = creditContractView.getCreditContractPaymentDiscipline();
    for (char paymentChar : paymentDisciplineString.toCharArray()) {
      paymentDiscipline.add(paymentChar);
    }
    return paymentDiscipline;
  }

  public boolean isRestartedInterpreter() {
    return creditContractView.getRestartOrQuitProgram();
  }
}
