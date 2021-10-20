package sauce.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.PageObject;

public class CartPageObject extends PageObject {

	public boolean isProductAvailable(String name) {
		ListOfWebElementFacades products = $$(
				By.xpath(String.format("//div[@class='inventory_item_name' and text()='%s']", name)));
		return products.size() == 0 ? false : true;
	}
}
