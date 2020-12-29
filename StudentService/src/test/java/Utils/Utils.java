package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	//method that waits for element and fill
	public static void sendKeysWait(WebDriver localDriver, WebElement element, int timeout, String value){
		  new WebDriverWait(localDriver, timeout).until(ExpectedConditions.visibilityOf(element));
		  element.sendKeys(value);
	  }
		
	//method that waits for element and click
	  public static void clickOnWait(WebDriver localDriver, WebElement element, int timeout){
		  new WebDriverWait(localDriver, timeout).until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(element), ExpectedConditions.visibilityOf(element)));
		  element.click();
	  }
	//method that waits for element
	  public static void waitOnEl(WebDriver localDriver, WebElement element, int timeout){
		  new WebDriverWait(localDriver, timeout).until(ExpectedConditions.visibilityOf(element));
		  
	  }
}
