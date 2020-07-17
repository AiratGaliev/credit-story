package com.github.airatgaliev.creditstory.service;

import com.github.airatgaliev.creditstory.model.CreditStory;
import java.util.List;

public class CreditStoryInterpreterService {

  private static final char DELAY_FROM_ONE_TO_THIRTY_DAYS = '1';
  private static final char DELAY_FROM_THIRTY_TO_FIFTY_DAYS = '2';
  private static final char DELAY_FROM_FIFTY_AND_MORE_DAYS = '3';

  public CreditStory getCreditStoryFromPaymentDiscipline(List<Character> paymentDiscipline) {
    int countDelaysFromOneToThirtyDays = 0;
    int countDelaysFromThirtyToFiftyDays = 0;
    int countDelaysFromFiftyAndMoreDays = 0;
    for (Character paymentChar : paymentDiscipline) {
      if (paymentChar.equals(DELAY_FROM_ONE_TO_THIRTY_DAYS)) {
        countDelaysFromOneToThirtyDays++;
      }
      if (paymentChar.equals(DELAY_FROM_THIRTY_TO_FIFTY_DAYS)) {
        countDelaysFromThirtyToFiftyDays++;
      }
      if (paymentChar.equals(DELAY_FROM_FIFTY_AND_MORE_DAYS)) {
        countDelaysFromFiftyAndMoreDays++;
      }
    }
    if (countDelaysFromThirtyToFiftyDays > 3 || countDelaysFromFiftyAndMoreDays > 0) {
      return CreditStory.NEGATIVE;
    }
    if (countDelaysFromThirtyToFiftyDays > 1 || countDelaysFromOneToThirtyDays > 3) {
      return CreditStory.DOUBTFUL;
    }
    return CreditStory.POSITIVE;
  }
}
