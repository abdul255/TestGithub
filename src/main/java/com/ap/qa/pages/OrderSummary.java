package com.ap.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.qa.base.TestBase;

public class OrderSummary extends TestBase{
	
	@FindBy(css="body.product.product-5.product-printed-summer-dress.category-11.category-summer-dresses.hide-left-column.hide-right-column.lang_en:nth-child(2) div.header-container div.container div.row div.clearfix div.layer_cart_cart.col-xs-12.col-md-6 div.button-container:nth-child(5) a.btn.btn-default.button.button-medium > span:nth-child(1)")
	WebElement proceedToCheckOut;
	
	@FindBy(css="[name='proceedAddress']")
	WebElement proceedAddress;
	
	@FindBy(css="input#cgv")
	WebElement termAndCondition;
	
	@FindBy(xpath="//button[@name='processCarrier']")
	WebElement proceesCarrier;
	
	@FindBy(css=".bankwire")
	WebElement payByBankwire;
	
	@FindBy(css="[class='button btn btn-default button-medium'][type='submit']")
	WebElement confirmOrder;
	
	@FindBy(xpath="//strong[text()='Your order on My Store is complete.']")	
	WebElement orderConfirm;
	
	public OrderSummary() {
		PageFactory.initElements(driver, this);
	}	
	public OrderSummary proceedToCheck() {
		proceedToCheckOut.click();
		return this;
	}
	
	public OrderSummary proceedAddress() {
		 proceedAddress.click();
		 return this;
	}
	
	public OrderSummary proceedShipping() {
		termAndCondition.click();
		proceesCarrier.click();
		return this;
	}
	

	public OrderSummary confirmOrder() {
		payByBankwire.click();
		confirmOrder.click();
		return this;
	}
	public String getConfirmMessage() {
		return orderConfirm.getText();
	}
}
