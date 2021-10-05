package sauce.steps;

import static org.assertj.core.api.Assertions.assertThat;

import net.thucydides.core.annotations.Step;
import sauce.pages.Login;

public class LoginSteps {

	private String actor;

	private Login sauceLogin;

	@Step("#actor navigates to sauce demo site")
	public void navigateToWebApp() {
		sauceLogin.navigateToLogin();
	}

	@Step("#actor succesfully logs in with username '{0}' and password '{1}'")
	public void attemptToLoginSuccessfully(String username, String password) {
		sauceLogin.attemptToLoginWithCredentials(username, password);
	}

	@Step("#actor fails to logs in with username '{0}' and password '{1}'")
	public void failToLoginSuccessfully(String username, String password) {
		sauceLogin.attemptToLoginWithCredentials(username, password);
	}

	@Step("#actor should see login failure message")
	public void verifyLoginFailureMessage() {
		assertThat(sauceLogin.getLoginFailureMessage())
				.isEqualTo("Epic sadface: Username and password do not match any user in this service");
	}
}
