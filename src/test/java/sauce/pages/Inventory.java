package sauce.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.At;

@At("https://www.saucedemo.com/inventory.html")
public class Inventory extends PageObject {

	// Only called when page is explicitly called
	/*
	 * @WhenPageOpens public void checkLoginButtonIsVisible() {
	 * $(By.xpath("//div[@id='header_container']//span[@class='title']")).
	 * waitUntilVisible(); }
	 */

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
