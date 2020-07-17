package com.github.airatgaliev.creditstory.controller;

import com.github.airatgaliev.creditstory.exceptions.InvalidCharacterException;
import com.github.airatgaliev.creditstory.model.CreditContract;
import com.github.airatgaliev.creditstory.model.CreditStory;
import com.github.airatgaliev.creditstory.repository.ICreditContractRepository;
import com.github.airatgaliev.creditstory.service.CreditStoryInterpreterService;
import com.github.airatgaliev.creditstory.service.ValidationService;
import com.github.airatgaliev.creditstory.view.ICreditContractView;
import java.util.List;
import java.util.stream.Collectors;

public class CreditContractController {

  private final ICreditContractRepository creditContractRepository;
  private final ICreditContractView creditContractView;
  private final CreditStoryInterpreterService creditStoryInterpreterService = new CreditStoryInterpreterService();
  private final ValidationService validationService = new ValidationService();

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
    while (true) {
      try {
        List<Character> paymentDiscipline;
        String paymentDisciplineString = creditContractView.getCreditContractPaymentDiscipline();
        validationService.validateStringValue(paymentDisciplineString);
        paymentDiscipline = paymentDisciplineString.chars().mapToObj(e -> (char) e)
            .collect(Collectors.toList());
        return paymentDiscipline;
      } catch (InvalidCharacterException e) {
        creditContractView.printExceptionResponse(e);
      }
    }
  }

  public boolean isRestartedInterpreter() {
    return creditContractView.getRestartOrQuitProgram();
  }
}
