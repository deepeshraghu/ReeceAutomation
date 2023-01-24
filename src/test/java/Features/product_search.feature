#@new_prod_pricing  @trade-dev @anonymous_ps  @anonymousretailuser
Feature: As a anonymous or retail User
  I need to be able to see the pricing of a product
  from the Product Browse page

  @chromeOptions
  Scenario: Test that an anonymous user who access the site will see the product list displayed with CMP price only,
  Show GST checkbox checked by default, gst inc prices displayed, Show CMP Price dropdown disabled

    Given I am on the home page
    And I search for product "Tap" as retail user
    Then I should not see price details
    When  I set the postcode to "3125"
    Then  I should see description of product contains "Tap"
    And   I should see list of product codes
    And   I should see list of CMP gst inc prices
    And   I should see gst inc note


  @test
  Scenario: Test that an anonymous user who access the site will see the product list displayed with CMP price only,
  Show GST checkbox checked by default, gst inc prices displayed, Show CMP Price dropdown disabled

    Given I am on the home page
    When  I navigate to "Shop by Product,Tapware & Accessories,Basin Mixers"
    Then I should not see price details
    When  I set the postcode to "3125"
    Then  I should see description of product contains "Tap"
    And   I should see list of product codes
    And   I should see list of CMP gst inc prices
    And   I should see gst inc note

  @test
  Scenario: Test that an anonymous user who access the site and does not enter a post code will see the add button as inactive
  for a retail product but can still add the product to the wishlist

    Given I am on the home page
    And I search for product "Tap" as retail user
    Then I should see that the ADD button is "false"
    Then I should not see price details
    And I should see the add to Wishlist button
    When I click Add to wishlist button
    Then the count for wishlist item is added by 1
    When  I set the postcode to "3125"
    Then  I should see description of product contains "Tap"
    And   I should see list of product codes
    And   I should see list of CMP gst inc prices
    And   I should see gst inc note
    Then I should see that the ADD button is "true"
    When I click on ADD button
    Then the count for the My Cart is added by 1
    Then the count for wishlist item is added by 1


  @test
  Scenario: Test that an anonymous user who access the site search for a trade product will see the Add button as Shop in Max

    Given I am on the home page
    And I search for product "3801210" as retail user
    And   I set the postcode to "3204"
    And   I should see that the button name is "Shop in maX"
    And   I should see the add to Wishlist button
    When  I click the shop in max button for a product as a retail user
    Then  I should be redirected to the login page
    When  I login to my account with "9raghu8@gmail.com" and "Coke@123"
    Then  I am forwarded to product details page of "3801210" product
    And   I click Add to cart button on product details page
    And   I logout


  @test
  Scenario: Test that PLP view toggles are retain when changing category or brand filters,
  Sort choice, page item choice or changing page number (OSOS-2741)

    Given I am on the home page
    And I search for product "Tap" as retail user
    When  I set the postcode to "3125"
    Then I should see that the selected view is "grid" view
    When I click on "Most Popular" on sort view options
    Then I should see that the selected view is "grid" view
    When I click on "Tapware & Accessories" category
    When I click on 'Basin Tapware' category
    Then I should see that the selected view is "grid" view
    When I click on Brand "Milli"
    Then I should see that the selected view is "grid" view
    When I click on 30 on page list control
    Then I should see that the selected view is "grid" view
    When I click on 15 on page list control
    When I click on 2 option on pagination dropdown
    Then I should see that the selected view is "grid" view
    And  I click on next icon on pagination
    Then I should see that the selected view is "grid" view
    When I click on list view icon
    Then I should see that the selected view is "list" view
    When I click on "Most Relevant" on sort view options
    Then I should see that the selected view is "list" view
    And I click Clear link on "Brand" filter
    When I click on "Basin Tap Sets" category
    Then I should see that the selected view is "list" view
    And I click Clear link on "Categories" filter
    When I click on "Tapware & Accessories" category
    When I click on 'Basin Tapware' category
    When I click on Brand "Milli"
    When I click on Brand "Pure"
    When I click on list view icon
    Then I should see that the selected view is "list" view
    When I click on 45 on page list control
    Then I should see that the selected view is "list" view
    And I click Clear link on "Brand" filter
    When I click on 3 option on pagination dropdown
    Then I should see that the selected view is "list" view
    And  I click on next icon on pagination
    Then I should see that the selected view is "list" view

