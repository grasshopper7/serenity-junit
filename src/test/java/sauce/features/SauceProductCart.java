package sauce.features;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import sauce.steps.CartSteps;
import sauce.steps.InventorySteps;
import sauce.steps.LoginSteps;
import sauce.steps.ProductDetailsSteps;

@RunWith(SerenityRunner.class)
public class SauceProductCart {

	@Managed
	private WebDriver driver;

	@Steps(actor = "Jane Doe")
	private LoginSteps loginSteps;

	@Steps(actor = "Jane Doe")
	private InventorySteps inventorySteps;
	
	@Steps(actor = "Jane Doe")
	private ProductDetailsSteps productDetailsSteps;

	@Steps(actor = "Jane Doe")
	private CartSteps cart;

	@Before
	public void openSauceSite() {
		loginSteps.navigateToWebApp();
		loginSteps.attemptToLoginSuccessfully("standard_user", "secret_sauce");
	}

	@Test
	@Title("Add to Cart from All Products Page")
	public void shouldAddToCartFromAllProductsSuccesfully() {
		String productName = "Sauce Labs Backpack";
		inventorySteps.attemptToAddProductToCart(productName);
		cart.verifyProductCountInCartIcon(1);
		cart.attemptToDisplayCartDetails();
		cart.verifyProductAvailableInCart(productName);
	}

	@Test
	@Title("Add to Cart from Product Details Page")
	public void shouldAddToCartFromProductDetailSuccesfully() {
		String productName = "Sauce Labs Bike Light";
		inventorySteps.attemptToDisplayProductDetails(productName);
		productDetailsSteps.attemptToAddProductToCart(productName);
		cart.verifyProductCountInCartIcon(1);
		cart.attemptToDisplayCartDetails();
		cart.verifyProductAvailableInCart(productName);
	}

}
