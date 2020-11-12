package Utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//helper class
public class Utils {
	//send keys after condition
	  public static void sendKeysWait(WebDriver localDriver, WebElement element, int timeout, String value){
		  new WebDriverWait(localDriver, timeout).until(ExpectedConditions.visibilityOf(element));
		  element.sendKeys(value);
	  }
		
	//click after condition
	  public static void clickOnWaitAndVisible(WebDriver localDriver, WebElement element, int timeout){
		  new WebDriverWait(localDriver, timeout).until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(element), ExpectedConditions.visibilityOf(element)));
		  element.click();
	  }
	//click after condition
	  public static void clickOnWait(WebDriver localDriver, WebElement element, int timeout){
		  new WebDriverWait(localDriver, timeout).until(ExpectedConditions.visibilityOf(element));
		  element.click();
	  }
	//click after condition
	  public static void waitOnEltoBeClickable(WebDriver localDriver, WebElement element, int timeout){
		  new WebDriverWait(localDriver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		  
	  }
	  //return  element after condition
	  public static WebElement waitOnEltoBeVisible(WebDriver localDriver, WebElement element, int timeout){
		  new WebDriverWait(localDriver, timeout).until(ExpectedConditions.visibilityOf(element));
		  return element;
	  }
	  	 
	  //method for screenshot
	  public static void takeScreenshot(WebDriver localDrive, String pathname) throws IOException {
		    File src = ((TakesScreenshot) localDrive).getScreenshotAs(OutputType.FILE);
		    FileUtils.copyFile(src, new File((".//screenshots//") + pathname + ".png"));
	  }
	  
	  //select method
	  public static void select(WebElement el, String select) {
		  Select s = new Select(el);
		  s.selectByVisibleText(select);
	  }
	  
}
