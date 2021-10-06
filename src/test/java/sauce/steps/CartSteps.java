package sauce.steps;

import static org.assertj.core.api.Assertions.assertThat;

import net.thucydides.core.annotations.Step;
import sauce.pages.Cart;
import sauce.pages.CartIcon;

public class CartSteps {

	private String actor;

	private CartIcon cartIcon;

	private Cart cart;

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
