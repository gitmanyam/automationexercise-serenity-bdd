package actions;

import net.serenitybdd.annotations.Step;
import pages.RegistrationPage;
import testdata.AccountData;

public class RegistrationActions {

    RegistrationPage registrationPage;
    AccountData accountData = new AccountData();

    @Step
    public void openApplication() {
        registrationPage.open();
    }

    @Step
    public void goToSignupPage() {
        registrationPage.acceptCookiesIfDisplayed();
        registrationPage.clickSignupLogin();
    }

    @Step
    public void enterSignupDetails(String name, String email) {
        registrationPage.enterName(name);
        registrationPage.enterEmail(email);
    }

    @Step
    public void clickSignup() {
        registrationPage.clickSignupButton();
    }

    @Step
    public void verifyAccountInformationPage() {
        registrationPage.verifyAccountInformationPage();
    }

    @Step
    public void enterAccountInformation() {
        registrationPage.enterAccountInformation(accountData);
    }

    @Step
    public void enterAddressInformation() {
        registrationPage.enterAddressInformation(accountData);
    }

    @Step
    public void submitRegistration() {
        registrationPage.clickCreateAccount();
    }

    @Step
    public void verifyAccountCreated() {
        registrationPage.verifyAccountCreated();
    }

    @Step
    public void verifyValidationMessage(String expected) {

        registrationPage.verifyValidationMessage(expected);
    }
}
