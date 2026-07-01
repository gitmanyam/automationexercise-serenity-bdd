package testdata;

public class CheckoutData {

    private String comments;
    private String cardName;
    private String cardNumber;
    private String cvc;
    private String expiryMonth;
    private String expiryYear;

    public CheckoutData() {

        this.comments = "Please call before delivery.";
        this.cardName = "John";
        this.cardNumber = "4111111111111111";
        this.cvc = "123";
        this.expiryMonth = "12";
        this.expiryYear = "2030";
    }

    public String getComments() {

        return comments;
    }

    public String getCardName() {

        return cardName;
    }

    public String getCardNumber() {

        return cardNumber;
    }

    public String getCvc() {

        return cvc;
    }

    public String getExpiryMonth() {

        return expiryMonth;
    }

    public String getExpiryYear() {

        return expiryYear;
    }
}