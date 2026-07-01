package steps;

import actions.CheckoutActions;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;

public class CheckoutSteps {

    @Steps
    CheckoutActions checkoutActions;

    @Given("the user logs into the application using email {string} and password {string}")
    public void login(String email, String password) {
        checkoutActions.login(email, password);
    }

    @And("the user searches and adds product {string} to the cart")
    public void addProduct(String product) {
        checkoutActions.addProduct(product);
    }

    @When("the user proceeds to checkout")
    public void proceedToCheckout() {
        checkoutActions.proceedToCheckout();
    }

    @Then("the user should be navigated to the Checkout page")
    public void verifyCheckoutPage() {
        checkoutActions.verifyCheckoutPage();
    }

    @When("the user reviews the delivery address")
    public void reviewAddress() {
        checkoutActions.reviewAddress();
    }

    @And("the user enters payment details")
    public void paymentDetails() {
        checkoutActions.enterPaymentDetails();
    }

    @And("the user confirms the order")
    public void confirmOrder() {
        checkoutActions.confirmOrder();
    }

    @Then("the order should be placed successfully")
    public void verifyOrderPlaced() {
        checkoutActions.verifyOrderPlaced();
    }
}
