package com.day23;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ParameterizedTest {

  public UserRegistration usr;
  public String email;
  public boolean result;

  public ParameterizedTest(String email, boolean result) {
    super();
    this.email = email;
    this.result = result;
  }

  @Before
  public void initialise() {
    usr = new UserRegistration();
  }

  @Test
  public void testEmailIsInCorrectFormat() {
    boolean match = usr.email(email);
    assertEquals(match, result);
  }

  @Parameterized.Parameters(name = "{index}: email({0})={1}")
  public static Collection<Object[]> input() {
    return Arrays.asList(new Object[][] {{"abc@yahoo.com", true}, {"abc-100@yahoo.com", true}, {"abc.100@yahoo.com", true}, {"abc111@abc.com", true}, {"abc-100@abc.net", true}, {"abc.100@abc.com.au", true}, {"abc@1.com", true}, {"abc@gmail.com.com", true}, {"abc+100@gmail.com", true}, {"abc", false}, {"abc@.com.my", false}, {"abc123@gmail.a", false}, {"abc123@.com", false}, {"abc123@.com.com", false}, {".abc@abc.com", false}, {"abc()*@gmail.com", false}, {"abc@%*.com", false}, {"abc..2002@gmail.com", false}, {"abc.@gmail.com", false}, {"abc@abc@gmail.com", false}, {"abc@gmail.com.1a", false}, {"abc@gmail.com.aa.au", false}});
  }

}