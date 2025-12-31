package com.project.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.project.ui.utils.Utilities;

public class CheckoutInfoPage {

	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(className = "title")
	private WebElement checkoutInfoHeading;
	
	@FindBy(id = "first-name")
	private WebElement inputFirstName;
	
	@FindBy(id = "last-name")
	private WebElement inputLastName;
	
	@FindBy(id = "postal-code")
	private WebElement inputZipPostalCode;
	
	@FindBy(id = "continue")
	private WebElement btnContinue;
	
	public CheckoutInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Utilities.explicitWait);
	}
	
	public boolean displayCheckoutInfoHeading() {
		return checkoutInfoHeading.isDisplayed();
	}
	
	public void enterCustomerInformation(String firstName, String lastName, String postalCode) {
		inputFirstName.sendKeys(firstName);
		inputLastName.sendKeys(lastName);
		inputZipPostalCode.sendKeys(postalCode);
	}
	
	public void clickContinueButton() {
		wait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
	}
}
