package Pages;

import java.awt.Desktop.Action;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.Utils;

public class DemoQAPage extends BasePage {
	
	public DemoQAPage(WebDriver driver) {
		super();
		BasePage.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	//Locators
	@FindBy(xpath="//div[@class='category-cards']//h5[text()='Interactions']")
	WebElement interaction;
	
	@FindBy(xpath= "//*[@id='item-3']//*[text()='Droppable']")
	WebElement toDroppable;
	
	
	@FindBy(id="draggable")
	WebElement draggable;
	
	@FindBy(id="droppable")
	WebElement droppable;
	
	@FindBy(xpath="//*[@id='droppable']/p")
	public WebElement droppableText;
	
	@FindBy(id="droppableExample-tab-simple")
	WebElement simple;
	
	@FindBy(xpath="//div[@class='element-group']//*[text()='Widgets']")
	WebElement widget;
	
	@FindBy(xpath="//ul[@class='menu-list']//*[text()='Tool Tips']")
	WebElement tooltips;
	
	@FindBy(id="toolTipButton")
	WebElement elementToBeHovered;
	
	@FindBy(xpath="//div[@class='tooltip-inner']")
	public WebElement hoverText;
	
	//waits for element to be visible
	public void waitDropTextVisible(){
		Utils.waitOnEltoBeVisible(driver, droppableText, 10);
	}
	//waits condition and click	on element
	public void clickInteractions(){
		Utils.clickOnWait(driver, interaction, 10);
	}
	
	public void clickDroppable(){
		js.executeScript("window.scrollBy(0,500)");
		Utils.clickOnWait(driver, toDroppable, 10);
	}
	//Method for drag and drop
	public void dragDrop()  {
        Actions builder = new Actions(driver);
        Utils.clickOnWait(driver, simple, 10);
        builder.dragAndDrop(draggable, droppable).build().perform();
    }
	//Method that make screenshot of page
	public void takeScreenshot(String nameSnapShot) throws IOException {
		Utils.takeScreenshot(driver,  nameSnapShot);
	}	
	//Method for navigating to widget tool tips
	public void navigateToWidgetToolTips(){
		Utils.waitOnEltoBeVisible(driver, widget, 10);
		Utils.clickOnWait(driver, widget, 10);
		js.executeScript("window.scrollBy(0,500)");
		Utils.clickOnWait(driver, tooltips, 10);
	}
	//Method: wait for element to be visible
	public void waitHoverElVisible(){
		Utils.waitOnEltoBeVisible(driver, elementToBeHovered, 10);
		
	}
	
	//Method: hover on element
	public void hoverElement() {
		Actions action = new Actions(driver);
        action.moveToElement(elementToBeHovered).perform();
        Utils.clickOnWait(driver, elementToBeHovered, 10);
	}
	
	
}
