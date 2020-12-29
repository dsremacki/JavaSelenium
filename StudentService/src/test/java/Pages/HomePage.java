package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.Utils;

public class HomePage extends BasePage {
	public HomePage(WebDriver driver) {
		super();
		BasePage.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	//locators
	@FindBy(xpath="//*[@translate='global.menu.entities.main']")
	WebElement dropdownEntities;
			
	//locators from dropdown "Entities"
	@FindBy(xpath="//*[@translate='global.menu.entities.studenti']")
	WebElement getStudents;
			
	@FindBy(xpath="//*[@translate='global.menu.entities.nastavnici']")
	WebElement getTeachers;	
	
	@FindBy(xpath="//*[@translate='global.menu.entities.ispitniRokovi']")
	WebElement getExamPeriods;	
	
	@FindBy(xpath="//*[@translate='global.menu.entities.predmeti']")
	WebElement getCourses;	
	
	@FindBy(xpath="//*[@translate='global.menu.entities.ispitnePrijave']")
	WebElement getExamRegistration;
	
	
	//Navigations to pages
	
	//navigation to students
	public void navigateToStudenti(){
		Utils.clickOnWait(driver,dropdownEntities, 10);
		Utils.clickOnWait(driver,getStudents, 10);
	}
	//navigation to teachers
	public void navigateToNastavnici(){
		Utils.clickOnWait(driver,dropdownEntities, 10);
		Utils.clickOnWait(driver,getTeachers, 10);
	}
	//navigation to examination period
	public void navigateToIspitniRokovi(){
		Utils.clickOnWait(driver,dropdownEntities, 10);
		Utils.clickOnWait(driver,getExamPeriods, 10);
	}
	//navigation to exam registration
	public void navigateToIspitnePrijaveNav(){
		Utils.clickOnWait(driver,dropdownEntities, 10);
		Utils.clickOnWait(driver,getExamRegistration, 10);
}	
	//navigation to subjects
		public void navigateToPredmeti(){
			Utils.clickOnWait(driver,dropdownEntities, 10);
			Utils.clickOnWait(driver,getCourses, 10);
	}	
}
