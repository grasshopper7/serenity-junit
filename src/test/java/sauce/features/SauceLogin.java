package sauce.features;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import sauce.steps.InventorySteps;
import sauce.steps.LoginSteps;

@RunWith(SerenityRunner.class)
public class SauceLogin {

	@Managed
	private WebDriver driver;

	@Steps(actor = "Mounish")
	private LoginSteps login;

	@Steps(actor = "Mounish")
	private InventorySteps inventory;

	@Before
	public void openSauceSite() {
		login.navigateToWebApp();
	}

	@Test
	@Title("Successful Login Test")
	public void shouldLoginSuccesfully() {
		login.attemptToLoginSuccessfully("standard_user", "secret_sauce");
		inventory.verifyProductsDisplayed();
	}

	@Test
	@Title("Failed Login Test")
	public void unableToLoginWithIncorrectDetails() {
		login.failToLoginSuccessfully("wrong_user", "open_sauce");
		login.verifyLoginFailureMessage();
	}
}
