package Tests;

import org.testng.annotations.Test;

import Utils.Utils;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.NoSuchElementException;

public class Tests extends BaseTest {
	
	 
	//login to page
	@Test(priority = 0)
	  public void login()  {
		   loginPage.loginUser("admin", "admin");
		   assertEquals(loginPage.getLoginMessage.getText(), "You are logged in as user \"admin\".");
		   
	  }
	//go to student page, create student and check if student is created
		@Test(dependsOnMethods = {"login"})
		public void createStudents()  {
			homePage.navigateToStudenti();
			studentPage.addStudent("E1234","Marko", "Markovic","Novi Sad");
			studentPage.addStudent("E5652","Nikola", "Nikolic","Beograd");
			assertTrue(studentPage.getStudent1.isDisplayed(), "Student with index number E1234 doesnt exist");
			assertTrue(studentPage.getStudent2.isDisplayed(), "Student with index number E5652 doesnt exist");
			
		}
	//find specific student and edit city name
		@Test(dependsOnMethods = {"createStudents"})
		public void editStudent(){
			studentPage.clickEditOnStudent("E5652");
			studentPage.addStudent("Kraljevo");
			assertEquals(studentPage.getStudentByIndex("E5652").getText(), "Kraljevo");
		}
	//delete student by index and check if table is empty
		@Test(dependsOnMethods = {"editStudent"})
		public void deleteStudents() throws InterruptedException {
			studentPage.deleteStudent("E5652");
			studentPage.deleteStudent("E1234");
			
			 try {
				 studentPage.getIndex("E5652");
				  assertFalse(true, "Fail! Student with index E5652 is still present, it should be deleted");
				  } catch (NoSuchElementException e) {
		  	  }
				  
			  try{
				  studentPage.getIndex("E1234");
				  assertFalse(true, "Fail! Student with index E1234 is still present, it should be deleted");
			  } catch(NoSuchElementException e){
		  }
	}
		//create teacher and check if teacher is created
			  @Test(dependsOnMethods = {"login", "deleteStudents"})
				public void addTeacher(){
					homePage.navigateToNastavnici();
					teacherPage.addNewTeacher("Milan", "Markovic", "Profesor");
					Utils.waitOnEl(driver, teacherPage.getTeacher, 10);
					assertTrue(teacherPage.getTeacher.isDisplayed(), "Proffessor Markovic doesnt exist");
				}
		//create students and check if student are created
				@Test(dependsOnMethods = {"addTeacher"})
				public void addStudents() {
					homePage.navigateToStudenti();
					studentPage.addStudent("E1234","Marko", "Markovic","Novi Sad");
					studentPage.addStudent("E5652","Nikola", "Nikolic","Beograd");
					assertTrue(studentPage.getStudent1.isDisplayed(), "Student with index E1234 is not present");
					assertTrue(studentPage.getStudent2.isDisplayed(), "Student with index E5652 is still present");
				}
		//create subject and check if subject is added
				@Test(dependsOnMethods = {"addStudents"})
				public void addSubject(){
					homePage.navigateToPredmeti();
					subjectPage.addNewCourse("Matematika", "Marko Markovic", "Milan Markovic");
					Utils.waitOnEl(driver, subjectPage.getCourse("Matematika"), 10);
					assertTrue(subjectPage.getCourse("Matematika").isDisplayed(),"Course Matematika doesnt exist");
					
				} 
				
		//add exam period and check if it is added
				@Test(dependsOnMethods={"addSubject"})
				public void addExamPeriod() {
					homePage.navigateToIspitniRokovi();
					examPage.addExamPeriod("April", "2016-04-16", "2016-04-24");	
					Utils.waitOnEl(driver, examPage.getExamMonth, 10);
					assertTrue(examPage.getExamMonth.isDisplayed(),"April exam period doesnt exist");
				}
		//add exam registration and check if registration is added
				@Test(dependsOnMethods={"addExamPeriod"})
				public void addExamRegistration() {
					homePage.navigateToIspitnePrijaveNav();
					registerExamPage.fillExamRegistration();
					Utils.waitOnEl(driver, registerExamPage.getExamMonth, 10);
					assertTrue(registerExamPage.getExamMonth.isDisplayed(),"Exam registration for April doesnt exist");
				}
				
}
