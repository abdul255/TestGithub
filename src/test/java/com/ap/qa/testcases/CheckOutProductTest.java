package com.ap.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.datamodel.ProductData;
import com.ap.qa.base.TestBase;
import com.ap.qa.dataProvider.DataProviders;
import com.ap.qa.pages.HomePage;
import com.ap.qa.pages.LoginPage;
import com.ap.qa.pages.OrderSummary;
import com.ap.qa.pages.ProductDetails;
import com.ap.qa.pages.SearchPage;

public class CheckOutProductTest extends TestBase {
	
	LoginPage login;
	HomePage homePage;
	SearchPage searchPage;
	ProductDetails productDetail;
	OrderSummary orderSummarry;
	
	// reffering testbase
	public CheckOutProductTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		login= new LoginPage();
		homePage= new HomePage();
		searchPage= new SearchPage();
		productDetail= new ProductDetails();
		orderSummarry= new OrderSummary();
	}
	
	// datamodel package dataprovider package
	@Test(dataProvider= "ProductData", dataProviderClass=DataProviders.class)
	public void testChechoutProcess(ProductData data) {
		String product=data.getProductName();
		homePage.clickOnSignIn();
		homePage=login.logIn(prop.getProperty("username"), prop.getProperty("password"));
		
		searchPage= homePage.searchProduct(product);
		String header =	searchPage.getHeader();
		System.out.println(header);
		Assert.assertTrue(header.toLowerCase().contains(product.toLowerCase()));
		
		productDetail = searchPage.selectProduct(product);
		productDetail.inputQuantity(data.getquantity());
		productDetail.selectProductColor(data.getcolor());
		productDetail.selectSize(data.getsize());
		productDetail.ClickAddCart();
		
		
		orderSummarry= productDetail.proceedToCheckOut();
		orderSummarry.proceedToCheck();
		orderSummarry.proceedAddress();
		orderSummarry.proceedShipping();
		orderSummarry.confirmOrder();
		
	String message=	orderSummarry.getConfirmMessage();
	Assert.assertEquals("Your order on My Store is complete. ", message);
	homePage.logoutPage();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	
		
		
	}

}
