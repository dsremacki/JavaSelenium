package Tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;





public class OrangeHrmSiteTest extends BaseTest {

	//Login and check if we are logged in	
  @Test(priority = 0)
  public void Login() {
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  orangeHrmLoginPage.fillLogin("admin", "admin123");
	  assertTrue(homePage.welcome.isDisplayed(), "Welcome text is not displayed");		  
  }
  
  	//Add candidate and check if list size is changed and if candidate is added
  @Test(dependsOnMethods = {"Login"})
  public void AddingCandidates() throws InterruptedException  {
	  homePage.navigateToCandidates();
	  old = candidatePage.numOfCandidates();
	  candidatePage.createFillFormNewCandidate("QA", "Engineer", "qa@qa.com","Senior QA Lead");
	  candidatePage.backButton();
	  candidatePage.waitOnHelpMsg();
	  current = candidatePage.numOfCandidates();
	  assertTrue((current>old), "They are equals no new candidate added!");
	  
  }
  
  //Delete candidate by name and last name and check size of list if it is ok
  @Test(dependsOnMethods = {"AddingCandidates"})
  public void DeleteCandidateAndLogOut()  {
	  candidatePage.deleteCandidate("QA  Engineer"); //2 spaces needed between name and last name in order to work
	  currentNewCurr = candidatePage.numOfCandidates();
	  assertEquals(currentNewCurr , old);
	  homePage.logOut();
	  assertTrue(orangeHrmLoginPage.loginButton.isDisplayed());
  }
  }
  

