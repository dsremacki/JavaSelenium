package Tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
//
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import Pages.ExamPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterExamPage;
import Pages.RegisterPage;
import Pages.StudentPage;
import Pages.CoursePage;
import Pages.TeacherPage;

public class BaseTest {
	 public LoginPage loginPage;
	 public HomePage homePage;
	 public StudentPage studentPage;
	 public TeacherPage teacherPage;
	 public CoursePage subjectPage;
	 public ExamPage examPage;
	 public RegisterExamPage registerExamPage;
	 public WebDriver driver;
	
		


	@BeforeSuite
	  public void beforeSuite() {
		  System.setProperty("webdriver.chrome.driver", "chromedriver");
		  driver = new ChromeDriver();
		  loginPage = new LoginPage(driver);
		  homePage = new HomePage(driver);
		  studentPage = new StudentPage(driver);
		  teacherPage = new TeacherPage(driver);
		  subjectPage = new CoursePage(driver);
		  examPage = new ExamPage(driver);
		  registerExamPage = new RegisterExamPage(driver);
//		  driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
//		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  
		  driver.manage().deleteAllCookies();
		  driver.manage().window().maximize();
		  driver.get("http://localhost:8080/#/");
		  
	  }
	@AfterSuite
		public void afterSuite(){
//		driver.quit();
	}
	
	
}
