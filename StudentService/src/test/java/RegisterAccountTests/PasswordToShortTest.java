package RegisterAccountTests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;


public class PasswordToShortTest extends RegisterBaseTest {
	 @Test()//register with password shorter then 5 characters
	  public void passwordToShort()  {
		  registerPage.registerUser("dragan3","dragan@dragan3.com","1234","1234", false);	  
		  assertEquals(registerPage.shortPassError.getText(), "Your password is required to be at least 5 characters.");
		  
	  }
}
