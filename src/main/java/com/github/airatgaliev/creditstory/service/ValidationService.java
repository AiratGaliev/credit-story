package com.github.airatgaliev.creditstory.service;


import com.github.airatgaliev.creditstory.exceptions.InvalidCharacterException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ValidationService {

  private static final String VALID_CHARACTERS = "[0-3]|С";

  public void validateStringValue(String checkedString) {
    if (checkedString.isEmpty()) {
      throw new InvalidCharacterException("пустая строка");
    }
    List<Character> checkedCharacters = checkedString.chars().mapToObj(e -> (char) e)
        .collect(Collectors.toList());
    Set<Character> invalidCharacters = new HashSet<>();
    for (Character checkedCharacter : checkedCharacters) {
      if (!checkedCharacter.toString().matches(VALID_CHARACTERS)) {
        invalidCharacters.add(checkedCharacter);
      }
    }
    if (!invalidCharacters.isEmpty()) {
      throw new InvalidCharacterException("значения " + invalidCharacters);
    }
  }
}
