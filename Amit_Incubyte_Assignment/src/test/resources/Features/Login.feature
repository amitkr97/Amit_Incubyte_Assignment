@SmokeTest

Feature: User Sign In on Magento Website

  Scenario: Successful User Sign In
    Given I navigate to Magento sign-in page
    When I sign in with the newly created <user> and <pass>
    Then I should be logged in successfully and see the user dashboard

	Examples:
 	| user | pass |
 	| amit.kumar002@example.com | Password123 |