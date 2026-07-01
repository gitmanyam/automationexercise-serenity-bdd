package steps;

import actions.ProductActions;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;

public class ProductSteps {

    @Steps
    ProductActions productActions;

    @Given("the user navigates to Homepage")
    public void openHomePage() {
        productActions.openApplication();
    }

    @When("the user clicks and navigates to the Products page")
    public void navigateToProducts() {
        productActions.navigateToProductsPage();
    }

    @Then("the user should be navigated to the Products page")
    public void verifyProductsPage() {
        productActions.verifyProductsPage();
    }

    @When("the user searches for the product {string}")
    public void searchProduct(String product) {
        productActions.searchProduct(product);
    }

    @Then("the searched product should be displayed")
    public void verifySearchResults() {
        productActions.verifySearchResults();
    }

    @When("the user adds the searched product to the cart")
    public void addProduct() {
        productActions.addProductToCart();
    }

    @And("the user navigates to the Cart page")
    public void viewCart() {
        productActions.navigateToCart();
    }

    @Then("the selected product {string} should be available in the cart")
    public void verifyCart(String product) {
        productActions.verifyProductInCart(product);
    }

}
