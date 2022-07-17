Feature: Automated E2E Tests
  Description : The purpose of this feature file is to test End 2 End integration.

  Scenario Outline: Customer places an order by purchasing an item from search
    Given user is on Home Page
    When he search for "dress"
    And choose to buy the first item
    And moves to checkout from mini cart
    And enter "<Customer>" personal details on checkout page
    #And select same delivery address
    #And select payment method as "check" payment
    And place the order
    #Then verify the order details
    Examples:
		|Customer|
		|Automation|