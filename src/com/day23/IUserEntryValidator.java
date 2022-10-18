package com.day23;

@FunctionalInterface
public interface IUserEntryValidator {
  public boolean validate(String input) throws UserValidationException;
}
