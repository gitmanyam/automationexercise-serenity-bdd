Feature: User Login

  As a registered customer
  User should be able to login to access the application

@Smoke
  Scenario Outline: Validate successful user login

    Given user navigates to the Homepage
    When the user clicks and navigates to the Login page
    Then the user should be navigated to the Login page
    When the user enters email address "<email>" and password "<password>"
    And the user clicks on Login button
    Then the user should be logged as "<user>"

    Examples:
      | email              | password | user  |
      | johnny@test.com    | Test@123 | John1 |

  @Smoke
  Scenario Outline: Validate unsuccessful user login

    Given user navigates to the Homepage
    When the user clicks and navigates to the Login page
    Then the user should be navigated to the Login page
    When the user enters email address "<email>" and password "<password>"
    And the user clicks on Login button
    Then user should see "<expectedResult>"

    Examples:
      | email             | password | expectedResult                        |
      | johnny@test.com   | Test123  | Your email or password is incorrect! |