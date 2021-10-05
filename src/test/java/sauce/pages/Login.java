package sauce.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;

@DefaultUrl("https://www.saucedemo.com/")
public class Login extends PageObject {

	public void navigateToLogin() {
		open();
	}

	@WhenPageOpens
	public void checkLoginButtonIsVisible() {
		$(By.id("login-button")).waitUntilVisible();
	}

	public void attemptToLoginWithCredentials(String username, String password) {
		enterUserName(username);
		enterPassword(password);
		submitLogin();
	}

	public void enterUserName(String username) {
		$(By.id("user-name")).type(username);
	}

	public void enterPassword(String password) {
		$(By.id("password")).type(password);
	}

	public void submitLogin() {
		$(By.id("login-button")).submit();
	}

	public String getLoginFailureMessage() {
		return $(By.xpath("//div[@id='login_button_container']//div[@class='error-message-container error']"))
				.getTextValue();
	}
}
