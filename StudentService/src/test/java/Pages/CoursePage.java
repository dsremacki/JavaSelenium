package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.Utils;

public class CoursePage extends BasePage{
	public CoursePage(WebDriver driver) {
		super();
		BasePage.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	//locators
	@FindBy(xpath="//*[@translate='ssluzbaApp.predmeti.home.createLabel']")
	WebElement getCreateButton;
	
	@FindBy(css="#field_naziv")
	WebElement getSubjectName;
	
	@FindBy(xpath="//*[@translate='entity.action.save']")
	WebElement getSaveButton;
		
	
	//method that select student by full name  
	public WebElement selectStudent(String fullName){
		return driver.findElement(By.xpath("//select[@id='field_studenti']//option[@label=\"" + fullName + "\"]"));		
	}
	//method that select teacher by full teacher name  
	public WebElement selectTeacher(String teacher){
		return driver.findElement(By.xpath("//select[@id='field_nastavnici']//option[@label=\""+ teacher +"\"]"));		
	}
	//Method that returns course name by course name
	public WebElement getCourse(String courseName) {
		return driver.findElement(By.xpath("//tr//td[a/text()=\"" + courseName + "\"]"));
	}
	
	/*add new course / edit course
	* @param name 
	* @param lastName 
	* @param proffesion
	*/
	public void addNewCourse(String courseName, String student, String teacher){
		Utils.clickOnWait(driver, getCreateButton, 10);
		getSubjectName.clear();
		Utils.sendKeysWait(driver, getSubjectName, 10, courseName);
		Utils.clickOnWait(driver, selectStudent(student), 10);
		Utils.clickOnWait(driver, selectTeacher(teacher), 10);
		Utils.clickOnWait(driver, getSaveButton, 10);
	}
}
