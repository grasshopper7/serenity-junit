package sauce.steps;

import net.thucydides.core.annotations.Step;
import sauce.pages.Inventory;

import static org.assertj.core.api.Assertions.assertThat;

public class InventorySteps {

	private String actor;

	private Inventory sauceInventory;

	@Step("#actor should see products displayed")
	public void verifyProductsDisplayed() {
		assertThat(sauceInventory.getProductPageHeadingText()).isEqualTo("PRODUCTS");
	}

	@Step("#actor selects product named '{0}'")
	public void attemptToDisplayProductDetails(String productName) {
		sauceInventory.selectProductByName("Test.allTheThings() T-Shirt (Red)");
	}
}
