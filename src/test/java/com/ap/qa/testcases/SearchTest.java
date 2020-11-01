package com.ap.qa.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.qa.base.TestBase;
import com.ap.qa.pages.HomePage;
import com.ap.qa.pages.LoginPage;
import com.ap.qa.pages.SearchPage;

public class SearchTest  extends TestBase{
	LoginPage login;
	SearchPage searchPage;
    HomePage homePage;
	
    public SearchTest() {
    	super();
    }	
    	@BeforeMethod
    	public void setUp() {
    		initialization();
    		
    		
    		login= new LoginPage();
    		homePage=new HomePage();
    		searchPage=new SearchPage();
    	}
    	
    	@Test
    	public void testSearchItem() {
    		String product= "Evening";
    		homePage.clickOnSignIn();
    		homePage=login.logIn(prop.getProperty("username"), prop.getProperty("password"));
    		searchPage=homePage.searchProduct("Evening");
    	String header=	searchPage.getHeader();
    	System.out.println(header);
    	Assert.assertTrue(header.toLowerCase().contains(product.toLowerCase()));
    	homePage.logoutPage();
    	}
    	
    	@AfterMethod
    	public void tearDown() {
    		driver.quit();
    	}
    }

