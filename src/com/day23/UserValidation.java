package com.day23;

import com.day23.UserValidationException.ExceptionType;

public class UserValidation {
  UserRegistration usrReg = new UserRegistration();

  public IUserEntryValidator validateName = (String userInput) -> {
    try {
      if (userInput.length() == 0)
        throw new UserValidationException(ExceptionType.IS_EMPTY, "name cannot be empty. enter a valid name.");
      return usrReg.name(userInput);
    } catch (NullPointerException e) {
      throw new UserValidationException(ExceptionType.IS_NULL, "name cannot be null. enter a valid name.");
    }
  };

  public IUserEntryValidator validateEmail = (String userInput) -> {
    try {
      if (userInput.length() == 0)
        throw new UserValidationException(ExceptionType.IS_EMPTY, "email cannot be left empty. enter a valid email.");
      return usrReg.email(userInput);
    } catch (NullPointerException e) {
      throw new UserValidationException(ExceptionType.IS_NULL, "email cannot be null. enter a valid email.");
    }
  };

  public IUserEntryValidator validatePassword = (String userInput) -> {
    try {
      if (userInput.length() == 0) throw new UserValidationException(ExceptionType.IS_EMPTY,
        "password cannot be left empty. enter a valid password.");
      return usrReg.password_rule4(userInput);
    } catch (NullPointerException e) {
      throw new UserValidationException(ExceptionType.IS_NULL, "password cannot be null. enter a valid password.");
    }
  };

  public IUserEntryValidator validateMobileNumber = (String userInput) -> {
    try {
      if (userInput.length() == 0) throw new UserValidationException(ExceptionType.IS_EMPTY,
        "phone number cannot be left empty. enter a valid phone number.");
      return usrReg.phone(userInput);
    } catch (NullPointerException e) {
      throw new UserValidationException(ExceptionType.IS_NULL,
        "phone number cannot be null. enter a valid phone number.");
    }
  };

}
