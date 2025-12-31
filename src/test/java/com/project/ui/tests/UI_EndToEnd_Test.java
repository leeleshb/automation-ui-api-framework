package com.project.ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.ui.base.BaseTest;
import com.project.ui.pages.CartPage;
import com.project.ui.pages.CheckoutInfoPage;
import com.project.ui.pages.CheckoutOverviewPage;
import com.project.ui.pages.LoginPage;
import com.project.ui.pages.ProductsPage;

public class UI_EndToEnd_Test extends BaseTest{

	LoginPage loginPage;
	ProductsPage productsPage;
	CartPage cartPage;
	CheckoutInfoPage info;
	CheckoutOverviewPage overview;
	
	@Test
	public void verifyUserJorneyfromLoginToCheckout() {
	
		loginPage = new LoginPage(driver);
		Assert.assertTrue(loginPage.navigateToLoginPage(dataprop.getProperty("loginPageNavigationUrl")), "Navigating to Login Page unsuccessful");
		loginPage.enterUserName(prop.getProperty("validUserName"));
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickLoginButton();
		productsPage = new ProductsPage(driver);
		Assert.assertTrue(productsPage.navigateToProductPage(dataprop.getProperty("productsPageNavigationUrl")), "Navigating to Products Page unsuccessful");
		productsPage.addProductToCart(dataprop.getProperty("productName5"));
		productsPage.NavigateToShoppingCart();
		cartPage = new CartPage(driver);
		Assert.assertTrue(cartPage.navigateToYourCartPage(dataprop.getProperty("cartPageNavigationUrl")), "Navigating to Your Cart Page unsuccessful");
		Assert.assertEquals(cartPage.getProductNameInCart(), dataprop.getProperty("productName5"), "Product name does not matches");
		Assert.assertTrue(cartPage.displayStatusOfRemoveButton(), "Remove button is not displayed");
		cartPage.clickCheckoutButton();
		info = new CheckoutInfoPage(driver);
		Assert.assertTrue(info.displayCheckoutInfoHeading(), "Checkout Information heading is not displayed");
		info.enterCustomerInformation(dataprop.getProperty("firstName"), dataprop.getProperty("lastName"), dataprop.getProperty("postalCode"));
		info.clickContinueButton();
		overview = new CheckoutOverviewPage(driver);
		Assert.assertTrue(overview.displayCheckoutOverviewHeading(), "Checkout Overview heading is not displayed");
	}
}
