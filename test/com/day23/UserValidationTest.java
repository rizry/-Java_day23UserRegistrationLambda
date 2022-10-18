package com.day23;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class UserValidationTest {
  UserValidation userValidation = new UserValidation();

  @Test
  public void testFirstNameStartsWithCapitalLetter_thenHappy() throws UserValidationException {
    assertTrue(userValidation.validateName.validate("Mark"));
  }

  @Test
  public void testFirstNameDoesntStartWithCapitalLetter_thenSad() throws UserValidationException {
    assertFalse(userValidation.validateName.validate("manson"));
  }

  @Test
  public void testFirstNameIsNullThrowsException_thenHappy() {
    try {
      userValidation.validateName.validate(null);
    } catch (UserValidationException e) {
      assertEquals(UserValidationException.ExceptionType.IS_NULL, e.type);
    }
  }

  @Test
  public void testFirstNameIsEmptyThrowsException_thenHappy() {
    try {
      userValidation.validateName.validate("");
    } catch (UserValidationException e) {
      assertEquals(UserValidationException.ExceptionType.IS_EMPTY, e.type);
    }
  }

  @Test
  public void testLastNameStartsWithCapitalLetter_thenHappy() throws UserValidationException {
    assertTrue(userValidation.validateName.validate("Smith"));
  }

  @Test
  public void testLastNameDoesntStartWithCapitalLetter_thenSad() throws UserValidationException {
    assertFalse(userValidation.validateName.validate("jones"));
  }

  @Test
  public void testLastNameIsNullThrowsException_thenHappy() {
    try {
      userValidation.validateName.validate(null);
    } catch (UserValidationException e) {
      assertEquals(UserValidationException.ExceptionType.IS_NULL, e.type);
    }
  }

  @Test
  public void testLastNameIsEmptyThrowsException_thenHappy() {
    try {
      userValidation.validateName.validate("");
    } catch (UserValidationException e) {
      assertEquals(UserValidationException.ExceptionType.IS_EMPTY, e.type);
    }
  }

  @Test
  public void testEmailContainsRequiredCharacter_thenHappy() throws UserValidationException {
    assertTrue(userValidation.validateEmail.validate("markmanson@gmail.co.in"));
  }

  @Test
  public void testEmailDoestContainRequiredCharacter_thenSad() throws UserValidationException {
    assertFalse(userValidation.validateEmail.validate("jack.sdf.com"));
  }

  @Test
  public void testEmailIsNullThrowsException_thenHappy() {
    try {
      userValidation.validateEmail.validate(null);
    } catch (UserValidationException e) {
      assertEquals(UserValidationException.ExceptionType.IS_NULL, e.type);
    }
  }

  @Test
  public void testEmailIsEmptyThrowsException_thenHappy() {
    try {
      userValidation.validateEmail.validate("");
    } catch (UserValidationException e) {
      assertEquals(UserValidationException.ExceptionType.IS_EMPTY, e.type);
    }
  }

  @Test
  public void testPhoneNumContainsCountryCodeAndSpace_thenHappy() throws UserValidationException {
    assertTrue(userValidation.validateMobileNumber.validate("91 8723476236"));
  }

  @Test
  public void testPhoneNumDoestContainCountryCodeAndSpace_thenSad() throws UserValidationException {
    assertFalse(userValidation.validateMobileNumber.validate("8347234823"));
  }

  @Test
  public void testMobileNumberIsNullThrowException() {
    try {
      userValidation.validateMobileNumber.validate(null);
    } catch (UserValidationException e) {
      assertEquals(UserValidationException.ExceptionType.IS_NULL, e.type);
    }
  }

  @Test
  public void testMobileNumberIsEmptyThrowException() {
    try {
      userValidation.validateMobileNumber.validate("");
    } catch (UserValidationException e) {
      assertEquals(UserValidationException.ExceptionType.IS_EMPTY, e.type);
    }
  }

  @Test
  public void testPasswordContainsSpecialCharacters_thenHappy() throws UserValidationException {
    assertTrue(userValidation.validatePassword.validate("asd8hDfbCsl%sb"));
  }

  @Test
  public void testPasswordDoestContainSpecialCharacter_thenSad() throws UserValidationException {
    assertFalse(userValidation.validatePassword.validate("ascdsAKfsd35MfdHhv"));
  }

  @Test
  public void testPasswordIsNullThrowException() {
    try {
      userValidation.validatePassword.validate(null);
    } catch (UserValidationException e) {
      assertEquals(UserValidationException.ExceptionType.IS_NULL, e.type);
    }
  }

  @Test
  public void testPasswordIsEmptyThrowException() throws UserValidationException {
    try {
      userValidation.validatePassword.validate("");
    } catch (UserValidationException e) {
      assertEquals(UserValidationException.ExceptionType.IS_EMPTY, e.type);
    }
  }
  
}
