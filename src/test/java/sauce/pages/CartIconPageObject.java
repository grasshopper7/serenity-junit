package sauce.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.PageObject;

public class CartIconPageObject extends PageObject {

	public int productCountInCart() {
		ListOfWebElementFacades count = $$(
				By.xpath("//div[@id='shopping_cart_container']//span[@class='shopping_cart_badge']"));
		return count.size() == 0 ? 0 : Integer.parseInt(count.get(0).getTextValue());
	}

	public void displayProductsInCart() {
		$(By.id("shopping_cart_container")).click();
	}
}
