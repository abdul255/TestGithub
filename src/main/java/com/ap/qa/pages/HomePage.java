package com.ap.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(css="div#contact-link")
	WebElement contact;
	
	@FindBy(css=".header_user_info")
	WebElement signIn;
	
	@FindBy (xpath="//input[@id='search_query_top']")
	WebElement searchItem;
	
	@FindBy (xpath="button[name='submit_search']")
	WebElement searchInputBox;
	
	@FindBy (css="[class='logout']")
	WebElement logoutButton;
	
	// driver has to know go get the elements - this implement to initialize in this class
	public HomePage() {
		PageFactory.initElements(driver, this); // initiliaze the webDriver to find the element- this reference to driver
	}
	
	public SearchPage searchProduct(String productName) {
		searchItem.sendKeys(productName);
		searchInputBox.click();
		return new SearchPage();
	}
	
	public void clickOnSignIn() {
		signIn.click();
	}

	public void clickInContact() {
		contact.click();
	}
	
	public void logoutPage() {
		logoutButton.click();
	}
}
