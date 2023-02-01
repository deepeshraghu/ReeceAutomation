Feature: As a anonymous User
   I need to be able to check out successfully

  @checkout
  Scenario: Test that an anonymous user who access the site will be able to submit contact us form

    Given I am on the home page
    And I search for product "9507324" as retail user
    And   I set the postcode to "3125"
    When I click on ADD button
    And I click on my cart icon
    And I click on check out cta
    Then I click on check out as guest cta
    And I fill billing details
    And I click on place order cta


