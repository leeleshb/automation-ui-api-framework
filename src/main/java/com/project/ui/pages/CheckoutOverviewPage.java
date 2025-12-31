package com.project.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage {

	WebDriver driver;
	
	@FindBy(className = "title")
	private WebElement checkoutOverviewHeading;
	
	public CheckoutOverviewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean displayCheckoutOverviewHeading() {
		return checkoutOverviewHeading.isDisplayed();
	}
}
