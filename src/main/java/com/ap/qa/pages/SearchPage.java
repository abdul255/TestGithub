package com.ap.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.qa.base.TestBase;

public class SearchPage extends TestBase{
	
	@FindBy(css="[title='Add to cart']")
	WebElement addCartButton;
	
	@FindBy(css="[title='Proceed to checkout']")
	WebElement checkOut;
	
	@FindBy(css="[class='page-heading product-listing']")
	WebElement searchHeading;
	
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
	// first select the product you want and picking from product details class
	// whatever dree i provide in my exceel you should handle by getting name ,title
	public ProductDetails selectProduct(String productName) {
		String locator ="[class='Product-name'][title='"+ productName+"']";
				driver.findElement(By.cssSelector(locator)).click();
		return new ProductDetails();
	}
	public String getHeader () {
		return searchHeading.getText();
	}
	
	
	

}
