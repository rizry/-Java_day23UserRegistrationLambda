package com.day23;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Scanner;
import org.junit.Test;

public class UserRegistrationTest {
  UserRegistration reg = new UserRegistration();

  @Test
  public void testFirstNameStartsWithCapitalLetter_thenHappy() {
    assertTrue(reg.name("Mark"));
  }

  @Test
  public void testFirstNameDoesntStartWithCapitalLetter_thenSad() {
    assertFalse(reg.name("manson"));
  }

  @Test
  public void testLastNameStartsWithCapitalLetter_thenHappy() {
    assertTrue(reg.name("Smith"));
  }

  @Test
  public void testLastNameDoesntStartWithCapitalLetter_thenSad() {
    assertFalse(reg.name("jones"));
  }

  @Test
  public void testEmailContainsRequiredCharacter_thenHappy() {
    assertTrue(reg.email("markmanson@gmail.co.in"));
  }

  @Test
  public void testEmailDoestContainRequiredCharacter_thenSad() {
    assertFalse(reg.email("jack.sdf.com"));
  }

  @Test
  public void testPhoneNumContainsCountryCodeAndSpace_thenHappy() {
    assertTrue(reg.phone("91 8723476236"));
  }

  @Test
  public void testPhoneNumDoestContainCountryCodeAndSpace_thenSad() {
    assertFalse(reg.phone("8347234823"));
  }

  @Test
  public void testPasswordAtLeastEightCharacters_thenHappy() {
    assertTrue(reg.password_rule1("jhfbalsb"));
  }

  @Test
  public void testPasswordDoestContainEightCharacters_thenSad() {
    assertFalse(reg.password_rule1("zcdhv"));
  }

  @Test
  public void testPasswordContainsAtLeastOneUpperCaseCharacter_thenHappy() {
    assertTrue(reg.password_rule2("asdhDfbslsb"));
  }

  @Test
  public void testPasswordDoestContainUpperCaseCharacter_thenSad() {
    assertFalse(reg.password_rule2("ascsdfsdfdhv"));
  }

  @Test
  public void testPasswordContainsAtLeastOneNumber_thenHappy() {
    assertTrue(reg.password_rule3("asd8hDfbCslsb"));
  }

  @Test
  public void testPasswordDoestContainNumber_thenSad() {
    assertFalse(reg.password_rule3("ascdsKfsdMfdhv"));
  }

  @Test
  public void testPasswordContainsSpecialCharacters_thenHappy() {
    assertTrue(reg.password_rule4("asd8hDfbCsl%sb"));
  }

  @Test
  public void testPasswordDoestContainSpecialCharacter_thenSad() {
    assertFalse(reg.password_rule4("ascdsAKfsd35MfdHhv"));
  }

  @Test
  public void testMatchAllEmails_thenHappy() {
				// valid emails
    assertTrue(reg.email("abc@yahoo.com"));
    assertTrue(reg.email("abc-100@yahoo.com"));
    assertTrue(reg.email("abc.100@yahoo.com"));
    assertTrue(reg.email("abc111@abc.com"));
    assertTrue(reg.email("abc-100@abc.net"));
    assertTrue(reg.email("abc.100@abc.com.au"));
    assertTrue(reg.email("abc@1.com"));
    assertTrue(reg.email("abc@gmail.com.com"));
    assertTrue(reg.email("abc+100@gmail.com"));
  }

  @Test
  public void testDontMatchTheseEmails_thenSad() {
				// invalid emails
    assertFalse(reg.email("abc"));
    assertFalse(reg.email("abc@.com.my"));
    assertFalse(reg.email("abc123@gmail.a"));
    assertFalse(reg.email("abc123@.com"));
    assertFalse(reg.email("abc123@.com.com"));
    assertFalse(reg.email(".abc@abc.com"));
    assertFalse(reg.email("abc()*@gmail.com"));
    assertFalse(reg.email("abc@%*.com"));
    assertFalse(reg.email("abc..2002@gmail.com"));
    assertFalse(reg.email("abc.@gmail.com"));
    assertFalse(reg.email("abc@abc@gmail.com"));
    assertFalse(reg.email("abc@gmail.com.1a"));
    assertFalse(reg.email("abc@gmail.com.aa.au"));
  }

  @Test
  public void testUserEntries_thenHappy() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter first name: ");
    String fName = sc.next();
    assertTrue(reg.name(fName));

    System.out.print("Enter last name: ");
    String lName = sc.next();
    assertTrue(reg.name(lName));

    System.out.print("Enter email: ");
    String email = sc.next();
    assertTrue(reg.email(email));

    sc.nextLine();
    System.out.print("Enter phone number: ");
    String phNum = sc.nextLine();
    assertTrue(reg.phone(phNum));

    System.out.print("Enter password: ");
    String pass = sc.next();
    assertTrue(reg.password_rule4(pass));

    sc.close();
  }

}
