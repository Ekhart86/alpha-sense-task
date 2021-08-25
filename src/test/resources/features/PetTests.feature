@all
@Pet
Feature: Pet tests

  @PetCreation
  Scenario: Adding a Pet to the store
    When add new Pet to the store with random parameters
    Then created Pet exists in the app

  @PetRemoval
  Scenario: Removal a Pet from the store
    When add new Pet to the store with random parameters
    Then created Pet exists in the app
    When delete the created Pet
    Then deleted pet no longer exists in the app
