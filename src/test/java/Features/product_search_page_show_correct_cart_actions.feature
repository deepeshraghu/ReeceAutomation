
Feature: Show Correct Cart Actions on search result page based on product visibility and purchase ability

  @sample1
  Scenario Outline: Show Correct Cart Actions on PLP for Anonymous user / Product visible

    Given I am on the home page
    And I search for product "<product>"
    And I set the postcode to "3204"
    Then I should see list of CMP gst inc prices
    And I should see that the button name is "<button_type>"

    Examples:
      |product  |button_type    |
      |9505824  | Add           |
      |1400300  | Shop in maX   |
      |2217589  | In-Store      |

  @sample1
  Scenario Outline: Show Correct Cart Actions on PLP for retail / unlinked user / Product visible
    Given I login to my account with "9raghu8@gmail.com" and "Coke@123"
    And I search for product "<product>"
    Then I should see list of CMP gst inc prices
    And I should see that the button name is "<button_type>"
    And I logout

    Examples:
      |product  |button_type          |
      | 9503799 | Add                 |
      | 1400200 | Trade Accounts only |
      | 2217565 | In-Store            |

  @sample1
  Scenario Outline: Show Correct Cart Actions on PLP for Anonymous user / Product visible
    Given I am on the home page
    And I search for product "<product>"
    And I set the postcode to "3204"
    Then I should see list of CMP gst inc prices
    And I should see that the button name is "<button_type>"
    And I logout

    Examples:
      |product                     |button_type  |
      | 3801210                    | Shop in maX |
      | 8002365                    | Shop in maX |

  @sample1
  Scenario Outline: Show Correct Cart Actions on PLP for retail / unlinked user / Product visible
    Given I login to my account with "9raghu8@gmail.com" and "Coke@123"
    And I search for product "<product>"
    Then I should see list of CMP gst inc prices
    And I should see that the button name is "<button_type>"
    And I logout

    Examples:
      |product                     |button_type          |
      | 3801210                    | Trade Accounts only |
      | 9800007                    | Trade Accounts only |

  @sample1
  Scenario Outline: Show Correct Cart Actions on PLP for Anonymous user / Product visible
    Given I am on the home page
    And I search for product "<product>"
    And I set the postcode to "3204"
    Then I should see list of CMP gst inc prices
    And I should see that the button name is "<button_type>"

    Examples:
      |product                     |button_type  |
      | 1604473                    | Shop in maX |
      | 1402397                    | Shop in maX |

  @sample1
  Scenario Outline: Show Correct Cart Actions on PLP for retail / unlinked user / Product visible
    Given I login to my account with "9raghu8@gmail.com" and "Coke@123"
    And I search for product "<product>"
    Then I should see list of CMP gst inc prices
    And I should see that the button name is "<button_type>"
    And I logout

    Examples:
      |product                     |button_type           |
      | 1604473                    | Trade Accounts only  |
      | 1402397                    | Trade Accounts only  |

  @sample
  Scenario Outline: Show Correct Cart Actions on PLP for Anonymous user / Product visible
    Given I am on the home page
    And I search for product "<product>"
    And I set the postcode to "3204"
    Then I should see list of CMP gst inc prices
    And I should see that the button name is "<button_type>"

    Examples:
      |product                     |button_type  |
      | 1601780                    | Shop in maX |
      | 1601777                    | Shop in maX |

  @sample
  Scenario Outline: Show Correct Cart Actions on PLP for retail / unlinked user / Product visible
    Given I login to my account with "9raghu8@gmail.com" and "Coke@123"
    And I search for product "<product>"
    And I set the postcode to "0600"
    Then I should see list of CMP gst inc prices
    And I should see that the button name is "<button_type>"
    And I logout

    Examples:
      |product                     |button_type           |
      | 9503799                    | Trade Accounts only  |
      | 1400200                    | Trade Accounts only  |

  @test
  Scenario Outline: Show Correct Cart Actions on PLP for MAX LINKED ACCOUNT USER / Product visible
    Given I login to my account with "9raghu8@gmail.com" and "Coke@123"
    And I search for product "<product>"
    Then I should see list of CMP gst inc prices
    And I should see that the button name is "<button_type>"
    And I logout

    Examples:
      |product                      |button_type    |
      | 2131528                     | Add           |
      | 1400200                     | Add           |
      | 2307086                     | Add           |
      | 7702712                     | Add           |

  @test
  Scenario: Show Correct Cart Actions on PLP for Anonymous user / Product not visible

    Given I am on the home page
    And I search for product "7702712"
    Then I get the product search with no results

  @test
  Scenario: Show Correct Cart Actions on PLP for retail user / Product not visible

    Given I login to my account with "9raghu8@gmail.com" and "Coke@123"
    And I search for product "7702712"
    Then I get the product search with no results
    And I logout