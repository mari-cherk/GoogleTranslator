@smoke
Feature: Settings Modal

  Scenario: Settings Modal should be shown when starting the app
    Given I am launching the application
    Then The Settings Modal opens


  Scenario: User should be able to change primary language
    Given I am on Settings Modal
    When I change primary language
    Then The changing primary language is applied