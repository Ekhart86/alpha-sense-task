@all
@Store
Feature: Store tests

  @OrderCreation
  Scenario: Placing an Order to buy a Pet
    When add new Pet to the store with random parameters
    Then created Pet exists in the app
    When place an Order for a created pet with parameters:
      | status |
      | placed |
    Then created Order exists in the app

  @OrderRemovalFailed
  Scenario: Send request for Order Removal with incorrect orderId
    When send request for Order removal by orderId 123454321
    Then response status code is 404