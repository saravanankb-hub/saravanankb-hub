Feature: Login Module

  @Test
  Scenario: Valid Login credentials
    Given user navigates to login Page
    When user successfully enters the login details
    Then user should be able to view the product details