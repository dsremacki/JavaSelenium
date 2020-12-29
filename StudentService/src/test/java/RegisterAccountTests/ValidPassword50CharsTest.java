package RegisterAccountTests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;


public class ValidPassword50CharsTest extends RegisterBaseTest {
	 @Test()//register user with 50 character password
	  public void validTestLongPass50Char() throws InterruptedException   {	  
		  registerPage.registerUser("dragan50","dragan@dragan50.com","12345678901234567890123456789012345678901234567890","12345678901234567890123456789012345678901234567890",true);
		  Thread.sleep(4000);
		  assertEquals(registerPage.message.getText(), "Registration saved! Please check your email for confirmation.");
		  
	  }
}
