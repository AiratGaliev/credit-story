package com.github.airatgaliev.creditstory.model;

import java.util.List;
import java.util.stream.Collectors;

public class CreditContract {

  private List<Character> paymentDiscipline;
  private CreditStory creditStory;

  public CreditContract(List<Character> paymentDiscipline,
      CreditStory creditStory) {
    this.paymentDiscipline = paymentDiscipline;
    this.creditStory = creditStory;
  }

  public List<Character> getPaymentDiscipline() {
    return paymentDiscipline;
  }

  public void setPaymentDiscipline(List<Character> paymentDiscipline) {
    this.paymentDiscipline = paymentDiscipline;
  }

  public CreditStory getCreditStory() {
    return creditStory;
  }

  public void setCreditStory(CreditStory creditStory) {
    this.creditStory = creditStory;
  }

  @Override
  public String toString() {
    return "Кредитный контракт с платежной дисциплиной клиента " + paymentDiscipline.stream()
        .map(String::valueOf)
        .collect(Collectors.joining()) +
        ", у которого кредитная история - " + creditStory.getValue();
  }
}
