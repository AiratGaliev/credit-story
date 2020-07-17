package com.github.airatgaliev.creditstory.view;

import com.github.airatgaliev.creditstory.model.CreditContract;
import java.util.List;

public interface ICreditContractView {

  void printCreditContractInfoResponse(CreditContract creditContract);

  void printCreditContractInfoRequest();

  String getCreditContractPaymentDiscipline();

  void printAllCreditContracts(List<CreditContract> contractList);

  boolean getRestartOrQuitProgram();
}