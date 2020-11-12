package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Pages.CheesePage;
import Pages.DemoQAPage;
import Pages.GooglePage;

public class BaseTest {
	public GooglePage googlePage;
	public DemoQAPage demoQAPage;
	public CheesePage cheesePage;
	public  WebDriver driver;
	
	@BeforeSuite
	  public void beforeSuite() {
		  System.setProperty("webdriver.chrome.driver", "chromedriver");
		  driver = new ChromeDriver();
		  googlePage = new GooglePage(driver);;
		  demoQAPage = new DemoQAPage(driver);
		  cheesePage = new CheesePage(driver);
		  driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		  
		  driver.manage().deleteAllCookies();
		  driver.manage().window().maximize();
		  
	  }
	@AfterSuite
		public void afterSuite(){
		driver.quit();
	}
	
	
}
