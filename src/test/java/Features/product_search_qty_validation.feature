@regression
Feature: OSOS-509 Quantity input fields on product search and product details page does not accept decimal values


  Scenario: Test that the quantity field on the product search page follow the validation rules of:
  numeric values only
  allows 0.01 to 30000.00
  truncates decimal values to 2
  does not accept negative values
  trigger on Enter, Add to Cart

    Given I login to my account with "9raghu8@gmail.com" and "Coke@123"
    And I search for product "nail"

    When I change the value of the quantity field of the first product to "31000" and enter
    Then I should see an error message of "Please enter a valid quantity." below the field
#    And the field surrounded by a red box

    When I change the value of the quantity field of the first product to "0.00" and enter
    Then I should see an error message of "Please enter a valid quantity." below the field
#    And the field surrounded by a red box

    When I change the value of the quantity field of the first product to "~`!@#$%^&*()_+-=" and enter
    Then I should see an error message of "Please enter a valid quantity." below the field
#    And the field surrounded by a red box
#
    When I change the value of the quantity field of the first product to "QWERTYUIOP{}" and enter
    Then I should see an error message of "Please enter a valid quantity." below the field
#    And the field surrounded by a red box
#
    When I change the value of the quantity field of the first product to "ASDFGHJK" and enter
    Then I should see an error message of "Please enter a valid quantity." below the field
#    And the field surrounded by a red box
#
    When I change the value of the quantity field of the first product to ":|;'" and enter
    Then I should see an error message of "Please enter a valid quantity." below the field
#    And the field surrounded by a red box
#
    When I change the value of the quantity field of the first product to "ZXCVBNM" and enter
    Then I should see an error message of "Please enter a valid quantity." below the field
#    And the field surrounded by a red box

    And I change the value of the quantity field of the first product to "0.01" and enter
    Then I should see an error message of "Please enter a valid quantity." below the field

    And I change the value of the quantity field of the first product to "-1.45253" and enter
    Then I should see an error message of "Please enter a valid quantity." below the field

#    When I take note of the widget item count
#    And I change the value of the quantity field of the first product to "30000.00"
#    And I click  the ADD button
##    And the field IS NOT surrounded by a red box
#    And the cart item count increased by "1"
#
#    When I take note of the widget item count
#    And I change the value of the quantity field of the first product to "1.253345" and enter
##    Then I should see the field value becomes "1.25"
##    And the field IS NOT surrounded by a red box
#    And I click  the ADD button
#    And the cart item count increased by "1"



    And I logout
