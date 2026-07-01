package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.support.FindBy;
import testdata.CheckoutData;

public class CheckoutPage extends PageObject {

    @FindBy(xpath="//a[contains(text(),'Proceed To Checkout')]")
    private WebElementFacade proceedToCheckoutButton;

    @FindBy(xpath="//h2[text()='Address Details']")
    private WebElementFacade addressHeading;

    @FindBy(xpath="//textarea[@name='message']")
    private WebElementFacade comments;

    @FindBy(xpath="//a[contains(text(),'Place Order')]")
    private WebElementFacade placeOrderButton;

    @FindBy(name="name_on_card")
    private WebElementFacade cardName;

    @FindBy(name="card_number")
    private WebElementFacade cardNumber;

    @FindBy(name="cvc")
    private WebElementFacade cvc;

    @FindBy(name="expiry_month")
    private WebElementFacade expiryMonth;

    @FindBy(name="expiry_year")
    private WebElementFacade expiryYear;

    @FindBy(id="submit")
    private WebElementFacade payButton;

    @FindBy(xpath="//b[text()='Order Placed!']")
    private WebElementFacade orderPlacedMessage;

    public void clickProceedToCheckout() {
        withAction().scrollByAmount(0,400).perform();
        proceedToCheckoutButton.waitUntilClickable().click();
    }

    public void verifyCheckoutPage() {
        addressHeading.shouldBeVisible();
        String currentUrl = getDriver().getCurrentUrl();
        assertTrue(currentUrl.contains("/checkout"));
    }

    public void checkDeliveryAddress(CheckoutData checkoutData) {
        comments.type(checkoutData.getComments());
    }

    public void enterPaymentDetails(CheckoutData checkoutData) {
        placeOrderButton.click();
        cardName.type(checkoutData.getCardName());
        cardNumber.type(checkoutData.getCardNumber());
        cvc.type(checkoutData.getCvc());
        expiryMonth.type(checkoutData.getExpiryMonth());
        expiryYear.type(checkoutData.getExpiryYear());
    }

    public void clickPayAndConfirm() {
        withAction().scrollByAmount(0,400).perform();
        payButton.waitUntilClickable().click();
    }

    public void verifyOrderPlaced() {
        orderPlacedMessage.waitUntilVisible();
        orderPlacedMessage.shouldContainText("ORDER PLACED!");
    }
}
