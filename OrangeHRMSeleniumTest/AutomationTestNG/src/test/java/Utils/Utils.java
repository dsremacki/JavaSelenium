package Utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//helper class
public class Utils {
	//method for sendKeys with condition
	public static void sendKeysWait(WebDriver localDriver, WebElement element, int timeout, String value){
		  new WebDriverWait(localDriver, timeout).until(ExpectedConditions.visibilityOf(element));
		  element.sendKeys(value);
	  }
		
	//method for click with condition
	  public static void clickOnWaitAndVisible(WebDriver localDriver, WebElement element, int timeout){
		  new WebDriverWait(localDriver, timeout).until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(element), ExpectedConditions.visibilityOf(element)));
		  element.click();
	  }
	//method for click with condition
	  public static void clickOnWait(WebDriver localDriver, WebElement element, int timeout){
		  new WebDriverWait(localDriver, timeout).until(ExpectedConditions.visibilityOf(element));
		  element.click();
	  }
	//method for click with condition
	  public static void waitOnEltoBeClickable(WebDriver localDriver, WebElement element, int timeout){
		  new WebDriverWait(localDriver, timeout).until(ExpectedConditions.elementToBeClickable(element));		  
	  }
	//method for visible condition
	  public static WebElement waitOnEltoBeVisible(WebDriver localDriver, WebElement element, int timeout){
		  new WebDriverWait(localDriver, timeout).until(ExpectedConditions.visibilityOf(element));
		  return element;
	  }
	  //select method 
	  public static void select(WebElement el, String select) {
		  Select s = new Select(el);
		  s.selectByVisibleText(select);
	  }
	  
}
