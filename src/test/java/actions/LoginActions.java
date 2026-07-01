package actions;

import net.serenitybdd.annotations.Step;
import pages.LoginPage;

public class LoginActions {

    LoginPage loginPage;

    @Step
    public void openApplication() {

        loginPage.open();

    }

    @Step
    public void navigateToLoginPage() {

        loginPage.acceptCookiesIfDisplayed();
        loginPage.clickLoginLink();
    }

    @Step
    public void verifyLoginPage() {

        loginPage.verifyLoginPage();
    }

    @Step
    public void enterCredentials(String email, String password) {

        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @Step
    public void clickLoginButton() {

        loginPage.clickLoginButton();
    }

    @Step
    public void verifySuccessfulLogin(String username) {

        loginPage.verifySuccessfulLogin(username);
    }

    @Step
    public void verifyLoginError(String expectedMessage) {

        loginPage.verifyLoginError(expectedMessage);
    }
}