package com.github.airatgaliev.creditstory.service;

import com.github.airatgaliev.creditstory.model.CreditStory;
import java.util.List;

public class CreditStoryInterpreterService {

  private final char DELAY_FROM_1_TO_30_DAYS = '1';
  private final char DELAY_FROM_30_TO_50_DAYS = '2';
  private final char DELAY_FROM_50_AND_MORE_DAYS = '3';

  public CreditStory getCreditStoryFromPaymentDiscipline(List<Character> paymentDiscipline) {
    int countDelaysFrom1To30Days = 0;
    int countDelaysFrom30To50Days = 0;
    int countDelaysFrom50AndMoreDays = 0;
    for (Character paymentChar : paymentDiscipline) {
      if (paymentChar.equals(DELAY_FROM_1_TO_30_DAYS)) {
        countDelaysFrom1To30Days++;
      }
      if (paymentChar.equals(DELAY_FROM_30_TO_50_DAYS)) {
        countDelaysFrom30To50Days++;
      }
      if (paymentChar.equals(DELAY_FROM_50_AND_MORE_DAYS)) {
        countDelaysFrom50AndMoreDays++;
      }
    }
    if (countDelaysFrom30To50Days > 3 || countDelaysFrom50AndMoreDays > 0) {
      return CreditStory.NEGATIVE;
    }
    if (countDelaysFrom30To50Days > 1 || countDelaysFrom1To30Days > 3) {
      return CreditStory.DOUBTFUL;
    }
    if (countDelaysFrom1To30Days < 3) {
      return CreditStory.POSITIVE;
    }
    return null;
  }
}
