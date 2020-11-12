package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pages.BasePage;
import Utils.Utils;

public class OrangeHrmLoginPage extends BasePage {
	public OrangeHrmLoginPage(WebDriver driver) {
		super();
		BasePage.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	//Locators
	@FindBy(id="txtUsername")
	 WebElement username;
	
	@FindBy(id="txtPassword")
	 WebElement password;
	
	@FindBy(id="btnLogin")
	 public WebElement loginButton;
	
	
	//Filling log in form
	public void fillLogin(String user,String pass) {
		username.clear();
		Utils.sendKeysWait(driver, username, 10, user);
		password.clear();
		Utils.sendKeysWait(driver, password, 10, pass);
		Utils.clickOnWait(driver, loginButton, 10);
		
	}
	
}
