package com.github.airatgaliev.creditstory.model;

public enum CreditStory {
  NEGATIVE("Отрицательная"), DOUBTFUL("Сомнительная"), POSITIVE("Положительная");
  private String value;

  CreditStory(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
