package steps;

import actions.LoginActions;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;

    public class LoginSteps {

        @Steps
        LoginActions loginActions;

        @Given("user navigates to the Homepage")
        public void navigateToHomePage() {

            loginActions.openApplication();
        }

        @When("the user clicks and navigates to the Login page")
        public void navigateToLoginPage() {

            loginActions.navigateToLoginPage();
        }

        @Then("the user should be navigated to the Login page")
        public void verifyLoginPage() {

            loginActions.verifyLoginPage();
        }

        @When("the user enters email address {string} and password {string}")
        public void enterCredentials(String email, String password) {

            loginActions.enterCredentials(email, password);
        }

        @And("the user clicks on Login button")
        public void clickLoginButton() {

            loginActions.clickLoginButton();
        }

        @Then("the user should be logged as {string}")
        public void verifySuccessfulLogin(String user) {

            loginActions.verifySuccessfulLogin(user);
        }

        @Then("user should see {string}")
        public void verifyLoginError(String expectedMessage) {

            loginActions.verifyLoginError(expectedMessage);
        }

    }

