package com.ap.qa.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.ap.qa.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener {
	
	public void beforeNavigateTo(String appURL, WebDriver driver) {
		System.out.println("Before navigating to: ' " + appURL + " ' ");
	}
	
	public void afterNavigateTo(String appURL, WebDriver driver ) {
		System.out.println("After navigating to : ' " + appURL + " ' ");
	}
	

	public void beforeChangeValueOf(WebElement element, WebDriver driver ) {
		System.out.println("Elemnt value change to : ' " + element.toString());
	}
	
	
	public void afterChangeValueOf(WebElement element, WebDriver driver ) {
		System.out.println("After element value change to : ' " +element.toString() );
	}
	
	public void beforeClickon(WebElement element, WebDriver driver ) {
		System.out.println("Trying to click on : ' " +element.toString() );
}

	public void afterClickon(WebElement element, WebDriver driver ) {
		System.out.println("Clicked on : ' " +element.toString() );	
	
	
	}
	
	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back to previous page");
	}
	
	public void aftereNavigateBack(WebDriver driver) {
		System.out.println("Navigating after page");
	
	}
	
	public void beforeNavigateforword(WebDriver driver) {
		System.out.println("Navigating forword to next page");
	}
	
	public void afterNavigateforword(WebDriver driver) {
		System.out.println("Navigating after to next page");
	}
	
	public void onException(Throwable error, WebDriver driver ) {
		System.out.println("Expected Occuresd : " + error);
		try {
			TestUtil.takesScreenshotAtEndofTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void beforeFindBy(By by, WebElement element , WebDriver driver) {
		System.out.println("Trying to find element by: "+ by.toString());
	}
	
	public void afterFindBy(By by, WebElement element , WebDriver driver) {
		System.out.println("Found element by: "+ by.toString());
	}
	
	public void beforeScript(String script, WebDriver driver) {
		
	}
	
	public void afterScript(String script, WebDriver driver) {
		
	}

	public void beforeAlertAccept(WebDriver driver) {
		
		
	}

	public void afterAlertAccept(WebDriver driver) {
	
		
	}

	public void afterAlertDismiss(WebDriver driver) {
		
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		
		
	}

	public void afterNavigateBack(WebDriver driver) {
		
		
	}

	public void beforeNavigateForward(WebDriver driver) {
		
		
	}

	public void afterNavigateForward(WebDriver driver) {
		
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		
		
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		
		
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		
		
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		
		
	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
	
		
	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		
		
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
	
		
	}
	
}
	
	
	
	
	