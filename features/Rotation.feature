@smoke
Feature: Rotation

  Scenario: Settings Modal should be shown when starting the app
    Given I am launching the application
    When I rotate phone
    Then The Settings Modal is displayed correctly