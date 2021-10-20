package sauce.steps;

import static org.assertj.core.api.Assertions.assertThat;

import net.thucydides.core.annotations.Step;
import sauce.pages.CartPageObject;
import sauce.pages.CartIconPageObject;

public class CartSteps {

	private String actor;

	private CartIconPageObject cartIcon;

	private CartPageObject cart;

	@Step("#actor should see '{0}' products count in cart icon")
	public void verifyProductCountInCartIcon(int count) {
		assertThat(cartIcon.productCountInCart()).isEqualTo(count);
	}

	@Step("#actor should see product '{0}' available in cart")
	public void verifyProductAvailableInCart(String name) {
		assertThat(cart.isProductAvailable(name)).isEqualTo(true);
	}

	@Step("#actor attempts to see products in cart")
	public void attemptToDisplayCartDetails() {
		cartIcon.displayProductsInCart();
	}
}
