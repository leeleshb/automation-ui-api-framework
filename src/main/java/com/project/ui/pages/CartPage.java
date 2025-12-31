package com.project.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.project.ui.utils.Utilities;

public class CartPage {

	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(className = "inventory_item_name")
	private WebElement productName;
	
	@FindBy(xpath = "//button[contains(text(),'Remove')]")
	private WebElement btnRemove;
	
	@FindBy(id = "checkout")
	private WebElement btnCheckout;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Utilities.explicitWait);
	}
	
	public boolean navigateToYourCartPage(String url) {
		return driver.getCurrentUrl().contains(url);
	}
	
	public String getProductNameInCart() {
		return wait.until(ExpectedConditions.visibilityOf(productName)).getText();
	}
	
	public boolean displayStatusOfRemoveButton() {
		return wait.until(ExpectedConditions.visibilityOf(btnRemove)).isDisplayed();
	}
	
	public void clickCheckoutButton() {
		wait.until(ExpectedConditions.elementToBeClickable(btnCheckout)).click();
	}
}
