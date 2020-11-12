package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.Utils;

public class GooglePage extends BasePage {
	
	public GooglePage(WebDriver driver) {
		super();
		BasePage.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	 //Locators
	@FindBy(xpath="//input[@class='gLFyf gsfi'][@name='q']")
	WebElement googleSearchBox;		
	@FindBy(xpath="//div[@class='g'][1]//a[1]")
	WebElement firstResult;
	
	//Method that fill text in Google search box
	public void fillGoogle(String text){
		googleSearchBox.clear();
		Utils.sendKeysWait(driver, googleSearchBox, 10, text);
		googleSearchBox.sendKeys(Keys.ENTER);
	}
	
	// click on first google result  
	public void clickFirstResult(){
		Utils.clickOnWait(driver, firstResult, 10);
		
	}
	
	
}
