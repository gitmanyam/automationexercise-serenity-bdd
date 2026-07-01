package testdata;

public class AccountData {

    private String password;
    private String firstName;
    private String lastName;
    private String company;
    private String address;
    private String country;
    private String state;
    private String city;
    private String zipCode;
    private String mobileNumber;

    // Test data
    public AccountData() {

        this.password = "Test@123";
        this.firstName = "John";
        this.lastName = "Cena";
        this.company = "Company";
        this.address = "London";
        this.country = "United States";
        this.state = "state";
        this.city = "London";
        this.zipCode = "1234567";
        this.mobileNumber = "1234567891";
    }

    public String getPassword() {

        return password;
    }

    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public String getCompany() {

        return company;
    }

    public String getAddress() {

        return address;
    }

    public String getCountry() {

        return country;
    }

    public String getState() {

        return state;
    }

    public String getCity() {

        return city;
    }

    public String getZipCode() {

        return zipCode;
    }

    public String getMobileNumber() {

        return mobileNumber;
    }
}