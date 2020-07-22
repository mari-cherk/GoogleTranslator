
Feature: Rotation

  Scenario: The Settings Modal is displayed correctly after rotation
    Given I am launching the application
    When I rotate phone
    Then The Settings Modal is displayed correctly