package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.Utils;

public class ExamPage extends BasePage{
	public ExamPage(WebDriver driver) {
		super();
		BasePage.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//locators
	@FindBy(xpath="//*[@translate='ssluzbaApp.ispitniRokovi.home.createLabel']")
	WebElement getCreateButton;
	
	@FindBy(css="#field_naziv")
	WebElement getCourseName;
	
	@FindBy(css="#field_pocetak")
	WebElement getExamStartDate;
	
	@FindBy(css="#field_kraj")
	WebElement getExamEndDate;
	
	@FindBy(xpath="//button/*[@translate='entity.action.save']")
	WebElement getSaveButton;
	
	//locator needed for assertion
	@FindBy(xpath="//tr//td/a[text()='April']")
	public WebElement getExamMonth;
	
	
	/*add new exam period / edit exam period
	* @param examName 
	* @param startDate 
	* @param endDate
	*/
	public void addExamPeriod(String examName, String startDate, String endDate){
		Utils.clickOnWait(driver, getCreateButton, 10);
		getCourseName.clear();
		Utils.sendKeysWait(driver, getCourseName, 10, examName);
		getExamStartDate.clear();
		Utils.sendKeysWait(driver, getExamStartDate, 10, startDate);
		getExamEndDate.clear();
		Utils.sendKeysWait(driver, getExamEndDate, 10, endDate);
		Utils.clickOnWait(driver, getSaveButton, 10);
	}

}
