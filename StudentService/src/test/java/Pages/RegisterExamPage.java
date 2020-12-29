package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.Utils;

public class RegisterExamPage extends BasePage{
	public RegisterExamPage(WebDriver driver) {
		super();
		BasePage.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	//locators
	@FindBy(xpath="//*[@translate='ssluzbaApp.ispitnePrijave.home.createLabel']")
	WebElement getCreateButton;
			
	@FindBy(xpath="//*[@id='field_ispitniRok']/*[@label='April']")
	WebElement examPeriod;
	
	@FindBy(xpath="//*[@id='field_student']/*[@label='E1234 Marko Markovic']")
	WebElement studentName;
	
	@FindBy(xpath="//*[@id='field_predmet']/*[@label='Matematika']")
	WebElement courseName;
	
	@FindBy(xpath="//*[@translate='entity.action.save']")
	WebElement getSaveButton;
	
	@FindBy(xpath="//tr//td[a/text()='April']")
	public WebElement getExamMonth;
	
	
	//fill exam registration by choosing displayed options
	public void fillExamRegistration(){
		Utils.clickOnWait(driver, getCreateButton, 10);
		Utils.clickOnWait(driver, examPeriod, 10); //select exam period, example: "April"
		Utils.clickOnWait(driver, studentName, 10); //select student name
		Utils.clickOnWait(driver, courseName, 10); //select course name
		Utils.clickOnWait(driver, getSaveButton, 10);
		
	}
}
