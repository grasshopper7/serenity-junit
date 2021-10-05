package sauce.steps;

import static org.assertj.core.api.Assertions.assertThat;

import net.thucydides.core.annotations.Step;
import sauce.pages.ProductDetails;

public class ProductDetailsSteps {

	private String actor;

	private ProductDetails sauceProductDetails;

	@Step("#actor should see name - '{0}' name and price - '{1}' displayed")
	public void verifyProductDetails(String name, String price) {
		assertThat(sauceProductDetails.getProductName()).isEqualTo(name);
		assertThat(sauceProductDetails.getProductPrice()).isEqualTo(price);
	}
}
