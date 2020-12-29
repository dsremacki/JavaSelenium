package RegisterAccountTests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;


public class PasswordToLongTest extends RegisterBaseTest {
	@Test()//register user with password longer then 50 characters
	  public void passToLong() {
		  registerPage.registerUser("dragan3","dragan@dragan3.com","123456789012345678901234567890123456789012345678901","123456789012345678901234567890123456789012345678901",false);	  
		  assertEquals(registerPage.longPassError.getText(), "Your password cannot be longer than 50 characters.");
		  
	  }
}
