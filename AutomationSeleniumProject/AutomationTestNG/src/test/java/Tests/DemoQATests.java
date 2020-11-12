package Tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

public class DemoQATests extends BaseTest {
	
	
	 //navigate to demoQA site and navigate to drag and drop take screenshot and check results
  @Test(priority = 0)  
  public void TestDragAndDrop() throws IOException {
	  driver.get("http://www.google.com");
	  googlePage.fillGoogle("demoqa.com");
	  googlePage.clickFirstResult();
	  demoQAPage.clickInteractions();
	  demoQAPage.clickDroppable();
	  demoQAPage.dragDrop();
	  demoQAPage.waitDropTextVisible();
	  assertEquals(demoQAPage.droppableText.getText(), "Dropped!");
	  demoQAPage.takeScreenshot("skreenshotsite");
	  
  }
  
  //after first test is done, navigate to Tool Tips check and screenshot results 
  @Test(dependsOnMethods = {"TestDragAndDrop"})
  public void TestHoverElementOnToolTips() throws IOException, InterruptedException {
	  demoQAPage.navigateToWidgetToolTips();
	  demoQAPage.waitHoverElVisible();
	  demoQAPage.hoverElement();	  
	  Thread.sleep(1500);
	  System.out.println(demoQAPage.hoverText.getText());
	  assertEquals(demoQAPage.hoverText.getText(), "You hovered over the Button");
	  demoQAPage.takeScreenshot("skreenshotsite2");
	  
  }
  

  
}