package com.ap.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.ap.qa.base.TestBase;

public class ProductDetails extends TestBase{
	
	@FindBy(id="quantity_wanted")
	WebElement quantityInput;
	
	@FindBy(css="[id='group_1']")
	WebElement sizeInput;
	
	@FindBy(css="[id='add_to_cart']")
	WebElement addCart;
	
	@FindBy(css="[title='Proceed to checkout']")
	WebElement Proceedtocheckout;
	
	@FindBy(css="[title='Add to my wishlist']")
	WebElement addToWishList;
	
	@FindBy(css="[class='fancybox-inner']")
	WebElement addToWishMsg;
	
	@FindBy(css="[class='fancybox-item fancybox-close']")
	WebElement addToWishMsgClosingButton;
	

	public ProductDetails() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyAddwishlishMessage() {
		Assert.assertEquals(addToWishMsg.getText(), "Added to your wishlist");
		addToWishMsgClosingButton.click();
	}
	//
	public ProductDetails selectProductColor(String color) {
		String locator= "[name='"+color+"']";
		driver.findElement(By.cssSelector(locator)).click();
		return this;
	}
	public ProductDetails inputQuantity(String quantity) {
		quantityInput.clear();
		quantityInput.sendKeys(quantity);
		return this;
	}
	
	public ProductDetails selectSize(String size) {
		Select select =new Select (sizeInput);
		select.deselectByVisibleText(size);
		return this;
		
	}
	
	public ProductDetails ClickAddCart() {
		addCart.click();
		return this;
	}
	public ProductDetails clickWishListButton() {
		addToWishList.click();
		return this;
	}
	
	public OrderSummary proceedToCheckOut() {
		Proceedtocheckout.click();
		return new OrderSummary();
	}
	
}
