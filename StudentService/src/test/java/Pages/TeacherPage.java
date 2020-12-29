package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.Utils;

public class TeacherPage extends BasePage{
	public TeacherPage(WebDriver driver) {
		super();
		BasePage.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	//locators
	@FindBy(xpath="//*[@translate='ssluzbaApp.nastavnici.home.createLabel']")
	WebElement getCreateButton;
	
	@FindBy(css="#field_ime")
	WebElement getName;
	
	@FindBy(css="#field_prezime")
	WebElement getLastName;
	
	@FindBy(css="#field_zvanje")
	WebElement getProffesion;
		
	@FindBy(linkText="Milan")
	public WebElement getTeacher;
	
	@FindBy(xpath="//*[@translate='entity.action.save']")
	WebElement getSaveButton;
	
	
	/*add new teacher / edit teacher
	* @param name 
	* @param lastName 
	* @param proffesion
	*/
	public void addNewTeacher(String name, String lastName, String proffesion) {
		Utils.clickOnWait(driver,  getCreateButton, 10);
		getName.clear();
		Utils.sendKeysWait(driver, getName, 10, name);
		getLastName.clear();
		Utils.sendKeysWait(driver, getLastName, 10, lastName);
		getProffesion.clear();
		Utils.sendKeysWait(driver, getProffesion, 10, proffesion);
		Utils.clickOnWait(driver, getSaveButton, 10);
	}
}
