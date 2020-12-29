package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.Utils;

public class StudentPage extends BasePage{

	public StudentPage(WebDriver driver) {
		super();
		BasePage.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	//locators
	@FindBy(xpath="//*[@translate='ssluzbaApp.studenti.home.createLabel']")
	WebElement getCreateButton;	
	
	@FindBy(id="field_indeks")
	WebElement getIndex;	
	
	@FindBy(id="field_ime")
	WebElement getName;

	@FindBy(id="field_prezime")
	WebElement getLastName;	
	
	@FindBy(id="field_grad")
	WebElement getCity;

	@FindBy(xpath = "//*[@translate='entity.action.save']")
	WebElement getSaveButton;
	
	@FindBy(linkText = "E1234")
	public WebElement getStudent1;
	
	@FindBy(linkText = "E5652")
	public WebElement getStudent2;
	
	@FindBy(xpath = "//div[@class='modal-content']//*[@translate=\"entity.action.delete\"]")
	WebElement getConfirmButtonModal;
	
	//click on edit button by student index number
	public void clickEditOnStudent(String studentIndeks) {
		WebElement student = driver.findElement(By.xpath("//tr[td/a[text()=\""+studentIndeks+"\"]]//td//*[@ui-sref=\"studenti.edit({id:studenti.id})\"]"));
		Utils.clickOnWait(driver, student, 10);
	}
	
	//get locator by index
	public WebElement getStudentByIndex(String i){
		return driver.findElement(By.xpath("//tr[td/a[text()=\""+ i +"\"]]/td[4]"));
	}	
	
	//delete student by index
	public void deleteStudent(String i) throws InterruptedException{
		Thread.sleep(1500);
		WebElement s = driver.findElement(By.xpath("//tr[td/a[text()=\""+ i +"\"]]//td//*[@ui-sref=\"studenti.delete({id:studenti.id})\"]"));
		s.click();
		Utils.clickOnWait(driver, getConfirmButtonModal, 10);
	}
	//return locator for index by index number
	public WebElement getIndex(String i) {
		return driver.findElement(By.xpath("//tr[td/a/text() = \"" + i + "\"]"));
	}
	
	//edit student city
	public void addStudent(String city) {
		getCity.clear();
		Utils.sendKeysWait(driver, getCity, 10, city);
		Utils.clickOnWait(driver, getSaveButton, 10);
		
	}
	/*add new student / edit student
	* @param indexNumber 
	* @param name 
	* @param lastName
	* @param city
	*/
	public void addStudent(String indexNumber, String name, String lastName, String city){
		Utils.clickOnWait(driver, getCreateButton, 10);
		getIndex.clear();
		Utils.sendKeysWait(driver, getIndex, 10, indexNumber);
		getName.clear();
		Utils.sendKeysWait(driver, getName, 10, name);
		getLastName.clear();
		Utils.sendKeysWait(driver, getLastName, 10, lastName);
		getCity.clear();
		Utils.sendKeysWait(driver, getCity, 10, city);
		Utils.clickOnWait(driver, getSaveButton, 10);
	}
}
