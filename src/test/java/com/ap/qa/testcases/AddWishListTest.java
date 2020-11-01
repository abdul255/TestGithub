package com.ap.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.qa.base.TestBase;
import com.ap.qa.pages.HomePage;
import com.ap.qa.pages.LoginPage;
import com.ap.qa.pages.ProductDetails;
import com.ap.qa.pages.SearchPage;

public class AddWishListTest extends TestBase {
	
	LoginPage login;
	SearchPage searchPage;
	ProductDetails productDetail;
	HomePage homePage;
	
	public AddWishListTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		login= new LoginPage();
		searchPage= new SearchPage();
		productDetail=new ProductDetails();
		homePage= new HomePage();
		
	}
	
	@Test
	public void testWishList() {
		String product= "Printed Chffon Dress";
		homePage.clickOnSignIn();
		homePage=login.logIn(prop.getProperty("username"), prop.getProperty("password"));
		searchPage= homePage.searchProduct(product);
		String header=searchPage.getHeader();
		Assert.assertTrue(header.toLowerCase().contains(product.toLowerCase()));
		productDetail = searchPage.selectProduct(product);
		
		productDetail.clickWishListButton();
		productDetail.verifyAddwishlishMessage();
		homePage.logoutPage();
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
