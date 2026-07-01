Feature: User Registration

  As a new customer
  User has to register to purchase products

  @Smoke
  Scenario Outline: Validate successful user registration

    Given the user navigates to the Homepage
    When the user clicks and navigates to the Signup page
    And the user provides name "<name>" and email address "<email>"
    And the user clicks on Signup button
    Then the user should be navigated to the Account Information page
    When the user enters the required account information
    And the user enters the address information
    And the user submits the registration form
    Then the user account should be created successfully

    Examples:
      | name  | email             |
      | Johnc | johnmails@test.com |

  @Smoke
  Scenario Outline: Validate unsuccessful user registration

    Given the user navigates to the Homepage
    When the user clicks and navigates to the Signup page
    And the user provides name "<name>" and email address "<email>"
    And the user clicks on Signup button
    Then the user should see "<expectedResult>"

    Examples:
      | name | email         | expectedResult               |
      | john | john@test.com | Email Address already exist! |