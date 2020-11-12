package Tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class CheeseTest extends BaseTest {
	
	
	//testing google result for cheese and print failed test message
  @Test()
  public void testHowMuchCheeseResult()  {
	  driver.get("http://www.google.com");
	  googlePage.fillGoogle("cheese");
	  cheesePage.getNumberOfResults();
      assertTrue(777 >= cheesePage.getNumberOfResults(), "There is too much cheese on the internet");
	  
  }
}
