package com.project.ui.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.project.ui.utils.Utilities;

public class ProductsPage{

	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(className = "inventory_item")
	private List<WebElement> products;
	
	@FindBy(className = "shopping_cart_link")
	private WebElement shoppingCartIcon;
	
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Utilities.explicitWait);
	}
	
	public boolean navigateToProductPage(String url) {
		return driver.getCurrentUrl().contains(url);
	}
	
	public void addProductToCart(String productName) {

        boolean productFound = false;

        for (WebElement product : products) {
        		String name = product.findElement(By.className("inventory_item_name")).getText();
            if (name.equalsIgnoreCase(productName)) {
                product.findElement(By.tagName("button")).click();
                productFound = true;
                break;
            }
        }

        if (!productFound) {
            throw new RuntimeException("Product not found: " + productName);
        }
    }
	
	public void NavigateToShoppingCart() {
		wait.until(ExpectedConditions.elementToBeClickable(shoppingCartIcon)).click();
	}
}
