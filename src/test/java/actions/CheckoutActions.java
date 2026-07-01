package actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import pages.CheckoutPage;
import testdata.CheckoutData;

public class CheckoutActions {

    CheckoutPage checkoutPage;

    @Steps
    LoginActions loginActions;

    @Steps
    ProductActions productActions;

    private final CheckoutData checkoutData = new CheckoutData();

    @Step
    public void login(String email, String password) {

        loginActions.openApplication();
        loginActions.navigateToLoginPage();
        loginActions.verifyLoginPage();
        loginActions.enterCredentials(email, password);
        loginActions.clickLoginButton();

    }

    @Step
    public void addProduct(String product) {

        productActions.navigateToProductsPage();
        productActions.verifyProductsPage();
        productActions.searchProduct(product);
        productActions.verifySearchResults();
        productActions.addProductToCart();
        productActions.navigateToCart();
        productActions.verifyProductInCart(product);
    }

    @Step
    public void proceedToCheckout() {

        checkoutPage.clickProceedToCheckout();
    }

    @Step
    public void verifyCheckoutPage() {

        checkoutPage.verifyCheckoutPage();
    }

    @Step
    public void reviewAddress() {

        checkoutPage.checkDeliveryAddress(checkoutData);
    }

    @Step
    public void enterPaymentDetails() {

        checkoutPage.enterPaymentDetails(checkoutData);
    }

    @Step
    public void confirmOrder() {

        checkoutPage.clickPayAndConfirm();
    }

    @Step
    public void verifyOrderPlaced() {

        checkoutPage.verifyOrderPlaced();
    }
}