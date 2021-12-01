Feature: To Calculate the borrowing estimate

Scenario: Giving Person details to calculate borrowing estimate
    Given launch the application and application type should be single
    And number of dependents should be zero
    When property you would like to buy home to live in
    And enter income in earnings
    And enter other income in earnings
    And enter living expenses in expenses
    And enter current home loan repayments in expenses
    And enter other loan repayments in expenses
 		And enter other commitments in expenses
  	And enter total credit card limits in expenses
  	Then click on how much I could borrow
  	Given click on start over
  	And enter living expenses in expenses again
  	Then click on work out how much i could borrow