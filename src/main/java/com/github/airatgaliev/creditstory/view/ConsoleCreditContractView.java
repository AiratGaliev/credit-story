package com.github.airatgaliev.creditstory.view;

import com.github.airatgaliev.creditstory.model.CreditContract;
import java.util.List;
import java.util.Scanner;

public class ConsoleCreditContractView implements ICreditContractView {

  public final String EXCEPTION_TEXT = "Извините, Вы ввели неверные данные: ";

  @Override
  public void printCreditContractInfoResponse(CreditContract creditContract) {
    System.out.println(
        "Добавлена следующая информация: " + creditContract.toString());
  }

  @Override
  public void printCreditContractInfoRequest() {
    System.out.println("\n\nПожалуйста введите информацию по кредитному договору :");
  }

  @Override
  public String getCreditContractPaymentDiscipline() {
    Scanner scanner = new Scanner(System.in);
    System.out.print(" Платежная дисциплина: ");
    return scanner.nextLine();
  }

  @Override
  public void printAllCreditContracts(List<CreditContract> creditContracts) {
    System.out.println("Список всех кредитных договоров: ");
    for (CreditContract creditContract : creditContracts) {
      System.out.println(creditContract.toString());
    }
  }

  @Override
  public boolean getRestartOrQuitProgram() {
    while (true) {
      System.out.print("Если желаете повторить итерпретацию кредитных историй нажмите на 'r',\n"
          + "чтобы выйти из программы - 'q': ");
      Scanner scanner = new Scanner(System.in);
      String isRestartedOrQuit = scanner.nextLine();
      if (isRestartedOrQuit.equals("r")) {
        return true;
      }
      if (isRestartedOrQuit.equals("q")) {
        return false;
      } else {
        System.out.println("Извините, вы ввели неверные данные, повторите попытку");
      }
    }
  }

  @Override
  public void printExceptionResponse(Exception e) {
    System.out.println(EXCEPTION_TEXT + e.getMessage());
  }
}
