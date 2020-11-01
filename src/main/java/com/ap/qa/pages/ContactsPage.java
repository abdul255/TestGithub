package com.ap.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ap.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	
	// findby annotation absorve all the locator value
	
	@FindBy(id="id_contact")
	WebElement headingDropdown; // hold the locator value 
	
	@FindBy(id="email")
	WebElement emailInput;
	
	@FindBy(id="id_order")
	WebElement OrderReference;
	
	@FindBy(id="message")
	WebElement  messageTextbox;
	
	@FindBy(id="submitMessage")
	WebElement submitMessageButton;
	
	@FindBy(css="[class='alert alert-success']")
	WebElement successMessage;
	


// creating constructor referencing the main class
// pagefactory allow you to contact with locator , init element basicallly we are calling the driver
// the word this overriding the driver	
public ContactsPage() {
	PageFactory.initElements(driver, this);
	
}
	// creating a method to perform the action
	public ContactsPage fillContactForm(String heading, String email, String reference, String message) {
		Select select =new Select(headingDropdown);
		select.selectByVisibleText(heading);
		emailInput.sendKeys(email);
		OrderReference.sendKeys(reference);
		messageTextbox.sendKeys(message);
		return this;
	}
	
	public void submitMessage() {
		submitMessageButton.click();
	}
	
	public String getMessage() {
		return successMessage.getText();
	}
	
}























