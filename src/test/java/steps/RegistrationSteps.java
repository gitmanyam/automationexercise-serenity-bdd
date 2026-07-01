package steps;

import actions.RegistrationActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class RegistrationSteps {

    @Steps
    RegistrationActions registrationActions;

    @Given("the user navigates to the Homepage")
    public void openHomePage() {

        registrationActions.openApplication();
    }

    @When("the user clicks and navigates to the Signup page")
    public void signupPage() {

        registrationActions.goToSignupPage();
    }

    @And("the user provides name {string} and email address {string}")
    public void enterUserDetails(String name, String email) {

        registrationActions.enterSignupDetails(name, email);
    }

    @And("the user clicks on Signup button")
    public void clickSignup() {
        registrationActions.clickSignup();
    }

    @Then("the user should be navigated to the Account Information page")
    public void verifyAccountInformationPage() {

        registrationActions.verifyAccountInformationPage();
    }

    @When("the user enters the required account information")
    public void enterAccountInformation() {

        registrationActions.enterAccountInformation();
    }

    @When("the user enters the address information")
    public void enterAddressInformation() {

        registrationActions.enterAddressInformation();
    }

    @And("the user submits the registration form")
    public void submitRegistration() {

        registrationActions.submitRegistration();
    }

    @Then("the user account should be created successfully")
    public void verifyAccountCreated() {

        registrationActions.verifyAccountCreated();
    }

    @Then("the user should see {string}")
    public void verifyValidationMessage(String expected) {

        registrationActions.verifyValidationMessage(expected);
    }
}
