@new_prod_pricing @trade-dev @retailuser @anonymousretailuser
Feature: As a Retail User
  I need to be able to see the pricing of a product
  from the Product Browse page

  @test
  Scenario: Test that a retail user with postcode should be able to see
  CMP gst inc amounts for all products

    Given I login to my account with "9raghu8@gmail.com" and "Coke@123"
    And I search for product "tap" as retail user
    Then  I should see description of product contains "Tap"
    And   I should see list of product codes
    And   I should see list of CMP gst inc prices
    And   I should see gst inc note
    And I search for product "103511" as retail user
    And I should see list of CMP gst inc prices
    And I should see gst inc note
    And I should see that the button name is "Trade Accounts only"
    When I click on the "103511" product id in the search results
    Then I should not see the ADD button on the product details page
    Then I logout

  #Not testing for legacy user
#  @retail
#  Scenario: Test that a retail user with no postcode should be forced to update its credentials before seeing the CMP
#
#    Given I login to my account with "9raghu8@gmail.com" and "Coke@123"
#    And I search for product "9503799" as retail user
#    Then I should see that the ADD button is disabled
#    And I should see the postcode link beside the product
#    And I should not see the CMP
#    And I click on the "9503799" product id in the search results
#    Then I should see the price unavailable note
#    And I should see link to local branch info
#    Then I logout

  #Not testing for complete the look section as it is deprecated
#  @retail
#  Scenario: Test that retail user when search for product with complimentary products
#  they, are able to add complimentary products to cart from product details page.
#  - This scenario also tests that retail user is not able to buy trade product from product search
#
#    Given I login to my account with "9raghu8@gmail.com" and "Coke@123"
#    And   I search for product "9509218" as retail user
#    And   I click on the "9509218" product id in the search results
#    Then  I should see a complete the look button
#    And   I should see a complete the look section
#    When  I click "1814522" complimentary product
#    And   I click Add to cart button on product details page
#    Given I go to the cart page
#    Then  I should see the "1814522" product in the cart
#    And   I logout