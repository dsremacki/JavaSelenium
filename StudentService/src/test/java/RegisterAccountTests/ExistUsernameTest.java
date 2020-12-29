package RegisterAccountTests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;


public class ExistUsernameTest extends RegisterBaseTest {
	@Test()
	//register user with existing email
	  public void sameUsername()  {
		  registerPage.registerUser("user","dragan2@dragan2.com","qwert","qwert",true);			  
		  assertEquals(registerPage.errorMessageU.getText(), "Login name already registered! Please choose another one."); 
	  }
}
