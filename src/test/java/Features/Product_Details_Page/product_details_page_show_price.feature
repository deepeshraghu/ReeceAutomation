Feature: Show pricing for all publicly visible products on PDP

  @test
  Scenario: Show price on PDP for Anonymous user / Retail product

    Given I am on the home page
    And I search for product "9503799" as retail user
    And I set the postcode to "3204"
    And I click on the "9503799" product id in the search results
    Then I should see the CMP price
    And click on Add to cart button
    Then I should see the "950399" product in the cart

  @test
  Scenario: Show price on PDP for Anonymous user / trade public visible product

    Given I am on the home page
    And I search for product "1405540" as retail user
    And I click on the "1405540" product id in the search results
    And I set the postcode to "3166" on pdp page
    Then I should see the CMP price
    And I should not see the ADD button on the product details page

  @test
  Scenario: Show price on PDP for Retail user / Retail product
    Given I login to my account with "test_retail_user@gmail.com" and "Password1000"
    And    I search for product "9503799" as retail user
    And    I click on the "9503799" product id in the search results
    Then   I should see the CMP price
    And    click on Add to cart button
    Then   I should see the "9503799" product in the cart
    And    I logout

  @test
  Scenario: Show price on PDP for Retail user / trade public visible product

    Given I login to my account with "test_retail_user@gmail.com" and "Password1000"
    And I search for product "1621251" as retail user
    And I click on the "1621251" product id in the search results
    Then I should see the CMP price
    And I should not see the ADD button on the product details page
    And I logout
#
#  @showprice_pdp_tradeuser_retailproduct @regression @au_ignore
#    # general user - will not work in prod environment
#  Scenario: Show price on PDP for Trade user / Retail product
#
#    Given I login with a general user
#    And I search for product "950399"
#    And I click on the "950399" product id in the search results
#    And I see the Your Price tab
#    And I see the CMP tab
#    And I logout
#
#
#  @showprice_pdp_tradeuser_trade_public_visible_product @regression @au_ignore
#    # general user - will not work in prod environment
#  Scenario: Show price on PDP for Trade user / trade public visible product
#
#    Given I login with a general user
#    When I access the new My Account trade pages
#    And I search for product "3101396"
#    And I click on the "3101396" product id in the search results
#    And I see the Your Price tab
#    And I see the CMP tab
#    And I logout
#
#
  @test
  Scenario: Show price on PDP for unlinked trade user / Retail product
    Given I login to my account with "maxankita@reece.com.au" and "Password1000"
    And   I search for product "9503799"
    And   I click on the "9503799" product id in the search results
    Then   I should see the CMP price
    And   click on Add to cart button
    Then  I should see the "9503799" product in the cart
    And   I logout


  @test
  Scenario: Show price on PDP for Unlinked trade user / trade public visible product
    Given I login to my account with "maxankita@reece.com.au" and "Password1000"
    And   I search for product "1621251" as retail user
    And   I click on the "1621251" product id in the search results
    Then   I should see the CMP price
    And   I should not see the ADD button on the product details page
    And   I logout
#
#  @showprice_pdp_tradeuser__public_NOT_visible_product @regression @au_ignore
#    # general user - will not work in prod environment
#  Scenario: Show price on PDP for Unlinked trade user / trade public visible product
#    Given I login with a general user
#    And   I search for product "7702712"
#    And   I click on the "7702712" product id in the search results
#    And   I see the Your Price tab
#    And   I see the CMP tab
#    And   I logout
#
#
  @test
  Scenario: Show price on PDP for Unlinked trade user / trade public visible product
    Given I login to my account with "test_retail_user@gmail.com" and "Password1000"
    And   I search for product "7702712" as retail user
    Then  I get the product search with no results
    And   I logout