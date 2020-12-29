package RegisterAccountTests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
//
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

import Pages.RegisterExamPage;
import Pages.RegisterPage;

public class RegisterBaseTest {
	 public static RegisterExamPage registerExamPage;
	 public static RegisterPage registerPage;
	 public static  WebDriver driver;
		


	@BeforeSuite
	  public void beforeSuite() {
		  System.setProperty("webdriver.chrome.driver", "chromedriver");
		  driver = new ChromeDriver();
//		  driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
//		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  registerExamPage = new RegisterExamPage(driver);
		  registerPage = new RegisterPage(driver);
		  driver.manage().deleteAllCookies();
	      driver.manage().window().maximize();
	      driver.get("http://localhost:8080/#/");
		  
	  }
	@AfterSuite
		public void afterSuite(){
		driver.quit();
	}
	
	
	@BeforeClass
		public void beforeTest() throws InterruptedException{
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@translate='global.menu.home']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@translate='global.menu.account.main']")).click();
		driver.findElement(By.xpath("//*[@translate='global.menu.account.register']")).click();
	    
	}
	
	
}

