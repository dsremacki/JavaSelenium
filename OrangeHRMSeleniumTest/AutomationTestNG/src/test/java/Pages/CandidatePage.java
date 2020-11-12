package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pages.BasePage;
import Utils.Utils;

public class CandidatePage extends BasePage {
	
	public CandidatePage(WebDriver driver) {
		super();
		BasePage.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	//Locators
	@FindBy(id="btnAdd")
     WebElement addButton;
	
	@FindBy(id="addCandidate_firstName")
	WebElement firstName;
	
	@FindBy(id="addCandidate_lastName")
	WebElement lastName;
	
	@FindBy(id="addCandidate_email")
	WebElement email;
	
	@FindBy(id="//*[@id='addCandidate_vacancy']//option[text()='Senior QA Lead']")
	WebElement optionQA;
	
	@FindBy(id="btnSave")
	WebElement saveButton;
	
	@FindBy(id="btnBack")
	WebElement btnBack; 
	
	@FindBy(id="addCandidate_vacancy")
	WebElement vacancy; 
	
	@FindBy(id="btnDelete")
	WebElement btnDelete; 
	
	@FindBy(id="dialogDeleteBtn")
	WebElement modalOk; 
	
	@FindBy(id="helpMessage")
	WebElement helpMsg;
	
	
	
	
	//return number of candidates from site
	public int numOfCandidates(){
		int s = driver.findElements(By.xpath("//tbody//tr")).size();
		System.out.println(s);  
		return s;
	}
	
	//Fill form and create candidate
	public void createFillFormNewCandidate(String name, String ln, String e,String select){
		Utils.clickOnWait(driver, addButton, 10);
		firstName.clear();
		Utils.sendKeysWait(driver, firstName, 10, name);
		lastName.clear();
		Utils.sendKeysWait(driver, lastName, 10, ln);
		email.clear();
		Utils.sendKeysWait(driver, email, 10, e);
		Utils.select(vacancy, select);
		Utils.clickOnWait(driver, saveButton, 10);
	}
	//click on back button
	public void backButton() throws InterruptedException{
		Thread.sleep(1200);
		Utils.clickOnWaitAndVisible(driver, btnBack, 10);
		
	}
	
	//locator by name of candidate(need to spaces between name and last name )
	public WebElement getcandidate(String name){
		return driver.findElement(By.xpath("//tbody//tr[td[a[text()=\""+ name + "\"]]]/td/input"));
	}
	//delete candidate by name 
	public void deleteCandidate(String name){
		getcandidate(name).click();
		Utils.clickOnWait(driver, btnDelete, 10);
		Utils.clickOnWait(driver, modalOk, 10);
	}
	
	//waiter
	public void waitOnHelpMsg(){
		Utils.waitOnEltoBeVisible(driver, helpMsg, 10);
	}
	
}
