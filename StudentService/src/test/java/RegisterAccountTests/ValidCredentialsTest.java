package RegisterAccountTests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;


public class ValidCredentialsTest extends RegisterBaseTest {
	@Test()//register user with valid credentials
	public void validTest() throws InterruptedException  {	 
		  registerPage.registerUser("dragan","dragan@dragan.com","qwert","qwert", true);
		  Thread.sleep(4000);
		  assertEquals(registerPage.message.getText(), "Registration saved! Please check your email for confirmation.");
		 
		  
	  }
}
