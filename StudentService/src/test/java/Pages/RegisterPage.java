package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.Utils;

public class RegisterPage extends BasePage{
	public RegisterPage(WebDriver driver) {
		super();
		
		BasePage.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	//locators
	@FindBy(id="login")
	WebElement username;	
	
	@FindBy(id="email")
	WebElement email;	
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="confirmPassword")
	WebElement confirmPassword;	
	
	@FindBy(xpath="//button[@type='submit'][text()='Register']")
	public WebElement register;	
	
	@FindBy(xpath="//*[@translate=\"register.messages.success\"]")
	public WebElement message;
	
	//locator for user message error		
	@FindBy(xpath="//*[@translate='register.messages.error.userexists']")
	public WebElement errorMessageU;
	
	//locator for user email error
	@FindBy(xpath="//*[@translate='register.messages.error.emailexists']")
	public WebElement errorMessageE;
	
	//locator for short password message error
	@FindBy(xpath="//*[@translate='global.messages.validate.newpassword.minlength']")
	public WebElement shortPassError;
	
	//locator for long password message error
	@FindBy(xpath="//*[@translate='global.messages.validate.newpassword.maxlength']")
	public WebElement longPassError;	
		
	//clear registration form 
	public void registerUser() {
		this.username.clear();
		this.email.clear();
		this.password.clear();
		this.confirmPassword.clear();		
	}	
	
	/*register new user of the web application, possible roles admin/user
	* @param user 
	* @param email 
	* @param pass
	* @param confPass - confirmation password
	*/
	
	public void registerUser(String user, String email, String pass, String confPass, Boolean y) {
		this.username.clear();
		Utils.sendKeysWait( driver, this.username, 10, user);
		this.email.clear();
		Utils.sendKeysWait(driver, this.email, 10, email);
		this.password.clear();
		Utils.sendKeysWait( driver, this.password, 10, pass);
		this.confirmPassword.clear();
		Utils.sendKeysWait( driver, this.confirmPassword, 10, confPass);
		
		if(y.equals(true)){
			Utils.clickOnWait(driver, register, 10);
		}
		else {
			System.out.println("Register button is not clickable");
		}
		
	}
}
