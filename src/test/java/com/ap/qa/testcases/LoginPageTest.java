package com.ap.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.qa.base.TestBase;
import com.ap.qa.pages.HomePage;
import com.ap.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage= new HomePage();
		
	}
	
	@Test
	public void loginTest() {
		homePage.clickOnSignIn();
		// homepage is a global page then you go to anotherpage
		// everytime you have to come homepage than you go to anotherPage
		// and sign out button in the homePage
		homePage= loginPage.logIn(prop.getProperty("username"), prop.getProperty("password"));
		homePage.logoutPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
