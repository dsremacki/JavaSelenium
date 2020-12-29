package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.Utils;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver) {
		super();
		BasePage.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	//locators
	@FindBy(linkText="sign in")
	WebElement textLogin;
		
	@FindBy(id="username")
	WebElement username;
			
	@FindBy(id="password")
	WebElement password;
				
	@FindBy(xpath="//button[@translate = 'login.form.button']")
	WebElement loginButton;
	
	@FindBy(xpath="//*[@translate = 'main.logged.message']")
	public WebElement getLoginMessage;
	
	//fill username
	public void fillUsername(String u){
		this.username.clear();
		Utils.sendKeysWait(driver, username, 10, u);
	}
	//fill password
	public void fillPassword(String pass){
		this.password.clear();
		Utils.sendKeysWait(driver, password, 10, pass);
	}
	
	/*Fill form and login
	*@param username
	*@param password 
	*/
	public void loginUser(String username, String password){
	Utils.clickOnWait(driver, textLogin, 10);
	this.fillUsername(username); 
	this.fillPassword(password);
	Utils.clickOnWait(driver, loginButton, 10); 
	Utils.waitOnEl(driver, getLoginMessage, 10);
	}
}
