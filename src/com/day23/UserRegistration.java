package com.day23;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {

  String regex;

  public boolean name(String name) {
    regex = "^[A-Z]{1}[a-z]{2,}$";
    return (validate(regex, name));
  }

  public boolean email(String email) {
    regex = "^[a-zA-Z]+[\\w]*([.|\\-|+][a-zA-Z0-9]+)*@[\\w]{1,5}[.][a-z]{2,3}(.[a-z]{2,3})?$";
    return (validate(regex, email));
  }

  public boolean phone(String phNum) {
    regex = "^[0-9]{1,3}(-[0-9]{1,3})?\\s{0,3}[6-9]{1}[0-9]{9}$";
    return (validate(regex, phNum));
  }

  public boolean password_rule1(String pass) {
    regex = "^\\w{8,}$";
    return (validate(regex, pass));
  }

  public boolean password_rule2(String pass) {
    regex = "^(?=.*[A-Z])\\w{8,}$";
    return (validate(regex, pass));
  }

  public boolean password_rule3(String pass) {
    regex = "^(?=.*[A-Z])(?=.*\\d)\\w{8,}$";
    return (validate(regex, pass));
  }

  public boolean password_rule4(String pass) {
    regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z0-9!@#$%^&*]{8,}$";
    return (validate(regex, pass));
  }

  private static boolean validate(String regex, String input) {
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(input);
    return m.matches();
  }
}
