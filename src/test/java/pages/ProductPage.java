package pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://automationexercise.com")
public class ProductPage extends PageObject {

    @FindBy(xpath = "//a[@href='/products']")
    private WebElementFacade productsLink;

    @FindBy(xpath = "//p[text()='Consent']")
    private WebElementFacade consentButton;

    @FindBy(xpath = "//h2[text()='All Products']")
    private WebElementFacade allProductsHeading;

    @FindBy(id = "search_product")
    private WebElementFacade searchProduct;

    @FindBy(id = "submit_search")
    private WebElementFacade searchButton;

    @FindBy(xpath = "//h2[text()='Searched Products']")
    private WebElementFacade searchedProductsHeading;

   @FindBy(xpath = "(//div[@class='product-image-wrapper'])[1]")
   // @FindBy(xpath="//a[normalize-space()='View Product']")
    private WebElementFacade firstProduct;

    @FindBy(xpath = "(//a[contains(text(),'Add to cart')])[1]")
   // @FindBy(xpath= "//button[@type='button']")
    private WebElementFacade addToCartButton;

    @FindBy(xpath = "//u[text()='View Cart']")
    private WebElementFacade viewCart;

    @FindBy(xpath = "//td[@class='cart_description']//a")
    private WebElementFacade cartProduct;

    public void acceptCookiesIfDisplayed() {

        try {
            consentButton.waitUntilVisible().waitUntilClickable()
                    .click();
        } catch (Exception ignored) {
        }
    }
    public void clickProducts() {
        productsLink.waitUntilVisible();
        productsLink.waitUntilClickable().click();
    }
    
    public void verifyProductsPage() {
        allProductsHeading.waitUntilVisible();
        String currentUrl = getDriver().getCurrentUrl();
        assertTrue(currentUrl.contains("/products"));
    }

    public void searchProduct(String product) {
        withAction().scrollByAmount(0,400).perform();
        searchProduct.type(product);
        searchButton.click();
    }

    public void verifySearchResults() {
        searchedProductsHeading.shouldBeVisible();
    }

    public void addProductToCart() {
       Actions actions = new Actions(getDriver());
        actions.moveToElement(firstProduct).perform();
        withAction().scrollByAmount(0,400).perform();
        withAction().scrollByAmount(0,400).perform();
        addToCartButton.waitUntilClickable().click();
    }

    public void viewCart() {
        viewCart.waitUntilClickable().click();
    }

    public void verifyProductInCart(String product) {
        cartProduct.shouldContainText(product);
    }

}
