package pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://automationexercise.com")
public class LoginPage extends PageObject {

    @FindBy(xpath = "//a[@href='/login']")
    private WebElementFacade loginLink;

    @FindBy(xpath = "//p[text()='Consent']")
    private WebElementFacade consentButton;

    @FindBy(xpath = "//h2[text()='Login to your account']")
    private WebElementFacade loginHeading;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElementFacade emailTextBox;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElementFacade passwordTextBox;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    private WebElementFacade loginButton;

    @FindBy(xpath = "//a[contains(text(),'Logged in as')]")
    private WebElementFacade loggedInUser;

    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    private WebElementFacade loginErrorMessage;

    public void clickLoginLink() {
        loginLink.waitUntilClickable().click();
    }

    public void verifyLoginPage() {
        loginHeading.shouldBeVisible();

        String currentUrl = getDriver().getCurrentUrl();
        assertTrue(currentUrl.contains("/login"));


    }

    public void acceptCookiesIfDisplayed() {

        try {
            consentButton.waitUntilVisible().waitUntilClickable()
                    .click();
        } catch (Exception ignored) {
        }
    }

    public void enterEmail(String email) {
        emailTextBox.waitUntilVisible().type(email);
    }

    public void enterPassword(String password) {
        passwordTextBox.type(password);
    }

    public void clickLoginButton() {
        loginButton.waitUntilClickable().click();
    }

    public void verifySuccessfulLogin(String username) {
        loggedInUser.waitUntilVisible();
        loggedInUser.shouldContainText("Logged in as " + username);
    }

    public void verifyLoginError(String expectedMessage) {
        loginErrorMessage.waitUntilVisible();
        System.out.println(loginErrorMessage.getText());
        loginErrorMessage.shouldContainText(expectedMessage);
    }

}
