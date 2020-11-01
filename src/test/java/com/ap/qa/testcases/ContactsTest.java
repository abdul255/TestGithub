package com.ap.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.qa.base.TestBase;
import com.ap.qa.pages.ContactsPage;
import com.ap.qa.pages.HomePage;

public class ContactsTest extends TestBase{
	ContactsPage contactPage;
	HomePage homePage;
	
	public ContactsTest() {
		super();
	}	
		@BeforeMethod
		public void setUp() {
			initialization();
			contactPage=new ContactsPage();
			homePage=new HomePage();
	}
		
		@Test
		public void testContact() {
			homePage.clickInContact();
			contactPage=contactPage.fillContactForm("Customer Service", "Abdulchowdhury607@yahoo.com", "Idiot4565", "this is test purpose");
			contactPage.submitMessage();
		String successMesage=	contactPage.getMessage();
		Assert.assertEquals(successMesage, "Your message has been successful sent to our team");
		}
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}

}
