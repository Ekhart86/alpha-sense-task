@all
@Pet
Feature: Pet tests

  @PetCreation
  Scenario: Adding a Pet to the store
    When add a new pet with random parameters to the store
    Then created Pet exists in the app

  @PetRemoval
  Scenario: Removal a Pet from the store
    When add a new pet with random parameters to the store
    Then created Pet exists in the app
    When delete the created Pet
    Then deleted Pet no longer exists in the app
