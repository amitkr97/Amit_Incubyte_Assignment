Feature: User Sign Up on Magento Website

  Scenario: Successful User Sign Up
    Given I am on the Magento sign-up page
    When I enter a valid <firstname>, <lastname>, <email>, <password> and <confirmationpassword>
    And I click on the "Create an Account" button
    Then I should see a success message confirming my account creation

   Examples:
    | firstname | lastname | email | password | confirmationpassword |
    | Amit | Test3 | amittest3@gmail.com | Password123 | Password123 |