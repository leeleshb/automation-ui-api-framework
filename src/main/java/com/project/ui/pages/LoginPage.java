package com.project.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.project.ui.utils.Utilities;

public class LoginPage {

	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(id = "user-name")
	private WebElement inputUserName;
	
	@FindBy(id = "password")
	private WebElement inputPassword;
	
	@FindBy(id = "login-button")
	private WebElement buttonLogin;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Utilities.explicitWait);
	}
	
	public boolean navigateToLoginPage(String url) {
		return driver.getCurrentUrl().equals(url);
	}
	public void enterUserName(String userName) {
		inputUserName.sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		inputPassword.sendKeys(password);
	}
	
	public void clickLoginButton() {
		wait.until(ExpectedConditions.elementToBeClickable(buttonLogin)).click();
	}
}
