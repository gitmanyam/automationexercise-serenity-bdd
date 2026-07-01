package pages;

import testdata.AccountData;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://automationexercise.com")
public class RegistrationPage extends PageObject {

    @FindBy(xpath = "//a[@href='/login']")
    private WebElementFacade signupLoginLink;

    @FindBy(xpath = "//p[text()='Consent']")
    private WebElementFacade consentButton;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    private WebElementFacade signupName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElementFacade signupEmail;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElementFacade signupButton;

    @FindBy(xpath = "//b[text()='Enter Account Information']")
    private WebElementFacade accountInformationHeading;

    @FindBy(id = "id_gender1")
    private WebElementFacade titleMr;

    @FindBy(id = "password")
    private WebElementFacade password;

    @FindBy(id = "days")
    private WebElementFacade day;

    @FindBy(id = "months")
    private WebElementFacade month;

    @FindBy(id = "years")
    private WebElementFacade year;

    @FindBy(id = "newsletter")
    private WebElementFacade newsletter;

    @FindBy(id = "optin")
    private WebElementFacade offers;

    @FindBy(id = "first_name")
    private WebElementFacade firstName;

    @FindBy(id = "last_name")
    private WebElementFacade lastName;

    @FindBy(id = "company")
    private WebElementFacade company;

    @FindBy(id = "address1")
    private WebElementFacade address;

    @FindBy(id = "country")
    private WebElementFacade country;

    @FindBy(id = "state")
    private WebElementFacade state;

    @FindBy(id = "city")
    private WebElementFacade city;

    @FindBy(id = "zipcode")
    private WebElementFacade zipCode;

    @FindBy(id = "mobile_number")
    private WebElementFacade mobileNumber;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    private WebElementFacade createAccountButton;

    @FindBy(xpath = "//b[text()='Account Created!']")
    private WebElementFacade accountCreatedMessage;

    @FindBy(xpath = "//p[text()='Email Address already exist!']")
    private WebElementFacade emailAlreadyExistsMessage;

    public void acceptCookiesIfDisplayed() {
        try {
            consentButton.waitUntilVisible().waitUntilClickable()
                    .click();
        } catch (Exception ignored) {
        }
    }

    public void clickSignupLogin() {
        signupLoginLink.waitUntilClickable().click();
    }

    public void enterName(String name) {
        signupName.waitUntilVisible().type(name);
    }

    public void enterEmail(String email) {
        signupEmail.type(email);
    }

    public void clickSignupButton() {
        signupButton.waitUntilClickable().click();
    }

    public void verifyAccountInformationPage() {
        accountInformationHeading.shouldBeVisible();
        String currentUrl = getDriver().getCurrentUrl();
        assertTrue(currentUrl.contains("/signup"));
    }

    public void enterAccountInformation(AccountData accountData) {
        titleMr.click();
        password.type(accountData.getPassword());
        day.selectByVisibleText("10");
        month.selectByVisibleText("May");
        year.selectByVisibleText("1998");
        withAction().scrollByAmount(0,400).perform();
        newsletter.click();
        offers.click();
    }
    
    public void enterAddressInformation(AccountData accountData) {
      withAction().scrollByAmount(0,400).perform();
       withAction().scrollByAmount(0,400).perform();
        firstName.type(accountData.getFirstName());
        lastName.type(accountData.getLastName());
        company.type(accountData.getCompany());
        address.type(accountData.getAddress());
        country.selectByVisibleText(accountData.getCountry());
        state.type(accountData.getState());
        city.type(accountData.getCity());
        zipCode.type(accountData.getZipCode());
        mobileNumber.type(accountData.getMobileNumber());
    }

    public void clickCreateAccount() {
        withAction().scrollByAmount(0,400).perform();
        createAccountButton.waitUntilClickable().click();
    }

    public void verifyAccountCreated() {
        accountCreatedMessage.shouldBeVisible();
        accountCreatedMessage.shouldContainText("ACCOUNT CREATED!");
    }

    public void verifyValidationMessage(String expectedMessage) {
        emailAlreadyExistsMessage.shouldBeVisible();
        emailAlreadyExistsMessage.shouldContainText(expectedMessage);
    }

}
