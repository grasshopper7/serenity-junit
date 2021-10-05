package sauce.features;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import sauce.steps.InventorySteps;
import sauce.steps.LoginSteps;
import sauce.steps.ProductDetailsSteps;

@RunWith(SerenityRunner.class)
public class SauceViewProduct {

	@Managed
	private WebDriver driver;

	@Steps(actor = "Cleopatra")
	private LoginSteps login;

	@Steps(actor = "Cleopatra")
	private InventorySteps inventory;

	@Steps(actor = "Cleopatra")
	private ProductDetailsSteps product;

	@Before
	public void openSauceSite() {
		login.navigateToWebApp();
		login.attemptToLoginSuccessfully("standard_user", "secret_sauce");
		inventory.verifyProductsDisplayed();
	}

	@Test
	@Title("Select Product Details")
	public void shouldViewProductSuccesfully() {
		String productName = "Test.allTheThings() T-Shirt (Red)";
		String productPrice = "$15.99";

		inventory.attemptToDisplayProductDetails(productName);
		product.verifyProductDetails(productName, productPrice);
	}
}
