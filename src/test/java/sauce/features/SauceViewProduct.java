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

	@Steps(actor = "Jane Doe")
	private LoginSteps loginSteps;

	@Steps(actor = "Jane Doe")
	private InventorySteps inventorySteps;

	@Steps(actor = "Jane Doe")
	private ProductDetailsSteps productDetailsSteps;

	@Before
	public void openSauceSite() {
		loginSteps.navigateToWebApp();
		loginSteps.attemptToLoginSuccessfully("standard_user", "secret_sauce");
	}

	@Test
	@Title("View Product Details")
	public void shouldViewProductSuccesfully() {
		String productName = "Test.allTheThings() T-Shirt (Red)";
		String productPrice = "$15.99";

		inventorySteps.attemptToDisplayProductDetails(productName);
		productDetailsSteps.verifyProductDetails(productName, productPrice);
	}
}
