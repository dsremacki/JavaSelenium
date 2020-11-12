package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pages.BasePage;
import Utils.Utils;

public class HomePage extends BasePage{
	public HomePage(WebDriver driver) {
		super();
		BasePage.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	//Locators
	@FindBy(xpath="//*[@id='menu_recruitment_viewRecruitmentModule']//*[text()='Recruitment']")
	 WebElement recruitmentButton;
	
	@FindBy(id="menu_recruitment_viewCandidates")
	 WebElement candidatesButton;
	
	@FindBy(id="welcome")
	public WebElement welcome;
	
	@FindBy(xpath="//a[text()='Logout']")
	public WebElement logout;
	
	//navigation to candidates
	public void navigateToCandidates(){
        Utils.clickOnWait(driver, recruitmentButton, 10);
		Utils.clickOnWait(driver, candidatesButton, 10);
		
	}
	//method for logout
	public void logOut(){
		Utils.clickOnWait(driver, welcome, 10);
		Utils.clickOnWait(driver, logout, 10);		
	}
	
	
}
