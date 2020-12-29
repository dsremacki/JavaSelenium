package RegisterAccountTests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;



public class ExistEmailTest extends RegisterBaseTest {
	 @Test() //register user with existing email
	  public void sameEmail() {
		  registerPage.registerUser("dragan2","user@user.com","qwert","qwert",true);
		  assertEquals(registerPage.errorMessageE.getText(), "E-mail is already in use! Please choose another one.");	
	  }
}
