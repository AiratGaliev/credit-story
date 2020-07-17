package com.github.airatgaliev.creditstory.model;

import java.util.List;

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
    return "CreditContract{" +
        "paymentDiscipline=" + paymentDiscipline +
        ", creditStory=" + creditStory.getValue() +
        '}';
  }
}
