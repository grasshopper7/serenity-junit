package sauce.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;

public class ProductDetailsPageObject extends PageObject {

	public String getProductName() {
		return $(By.xpath("//div[@id='inventory_item_container']//div[@class='inventory_details_name large_size']"))
				.getTextValue();
	}

	public String getProductPrice() {
		return $(By.xpath("//div[@id='inventory_item_container']//div[@class='inventory_details_price']"))
				.getTextValue();
	}

	public void addProductToCart(String name) {
		$(By.id("add-to-cart-sauce-labs-bike-light")).click();
	}
}
