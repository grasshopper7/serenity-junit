package sauce.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.At;

public class InventoryPageObject extends PageObject {

	public String getProductPageHeadingText() {
		return $(By.xpath("//div[@id='header_container']//span[@class='title']")).getTextValue();
	}

	public void selectProductByName(String name) {
		$(By.xpath("//div[@class='inventory_item_description']//div[@class='inventory_item_name' and text()='" + name
				+ "']")).click();
	}

	public void addProductToCart(String name) {
		$(By.xpath("//div[@class='inventory_item_name' and text()='" + name
				+ "']//ancestor::div[@class='inventory_item_label']//following-sibling::div[@class='pricebar']/button[@id='add-to-cart-sauce-labs-backpack']"))
						.click();
	}
}
