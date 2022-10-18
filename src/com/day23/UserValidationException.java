package com.day23;

public class UserValidationException extends Exception {
  private static final long serialVersionUID = 8645159127659760223L;
  public ExceptionType type;

  public enum ExceptionType {
    IS_NULL, IS_EMPTY
  }

  public UserValidationException() {

  }

  public UserValidationException(ExceptionType type, String message) {
    super(message);
    this.type = type;
  }

}
