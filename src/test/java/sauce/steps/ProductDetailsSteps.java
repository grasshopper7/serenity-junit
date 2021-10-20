package sauce.steps;

import static org.assertj.core.api.Assertions.assertThat;

import net.thucydides.core.annotations.Step;
import sauce.pages.ProductDetailsPageObject;

public class ProductDetailsSteps {

	private String actor;

	private ProductDetailsPageObject sauceProductDetails;

	@Step("#actor should see name - '{0}' name and price - '{1}' displayed")
	public void verifyProductDetails(String name, String price) {
		assertThat(sauceProductDetails.getProductName()).isEqualTo(name);
		assertThat(sauceProductDetails.getProductPrice()).isEqualTo(price);
	}

	@Step("#actor adds product named '{0}' to cart")
	public void attemptToAddProductToCart(String productName) {
		sauceProductDetails.addProductToCart(productName);
	}

}
