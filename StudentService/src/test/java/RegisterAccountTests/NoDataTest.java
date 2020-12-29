package RegisterAccountTests;

import static org.testng.Assert.assertFalse;

import org.testng.annotations.Test;


public class NoDataTest extends RegisterBaseTest {
	@Test()//register user with no credentials
	  public void noData() {
		  registerPage.registerUser();		  
		  assertFalse(registerPage.register.isEnabled(), "It is clickable, but it shouldnt be");
	  }
}
