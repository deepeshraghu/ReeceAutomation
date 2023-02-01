Feature: OSOS-509 Quantity input fields on product search and product details page does not accept decimal values

  @test
  Scenario Outline: Test that the quantity field on the product search page follow the validation rules of:
  numeric values only allows 0.01 to 30000.00 truncates decimal values to 2 does not accept negative values
  trigger on Enter, Add to Cart

    Given I login to my account with "9raghu8@gmail.com" and "Coke@123"
    And I search for product "nail"
    When I change the value of the quantity field of the first product to "<Quantity>" and enter
    Then I should see an error message of "Please enter a valid quantity." below the field
    And Add button is not clickable
    And I logout
    Examples:
      |Quantity|
    |    31000  |
    |    0.01    |
    |    -1.45253    |