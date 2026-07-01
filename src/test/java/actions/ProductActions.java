package actions;

import net.serenitybdd.annotations.Step;
import pages.ProductPage;

public class ProductActions {

    ProductPage productPage;

    @Step
    public void openApplication() {

        productPage.open();
    }

    @Step
    public void navigateToProductsPage() {

        productPage.acceptCookiesIfDisplayed();
        productPage.clickProducts();
    }

    @Step
    public void verifyProductsPage() {

        productPage.verifyProductsPage();
    }

    @Step
    public void searchProduct(String product) {

        productPage.searchProduct(product);
    }

    @Step
    public void verifySearchResults() {

        productPage.verifySearchResults();
    }

    @Step
    public void addProductToCart() {

        productPage.addProductToCart();
    }

    @Step
    public void navigateToCart() {

        productPage.viewCart();
    }

    @Step
    public void verifyProductInCart(String product) {

        productPage.verifyProductInCart(product);
    }

}
