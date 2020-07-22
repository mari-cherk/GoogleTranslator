@smoke
Feature: Background mode

  Scenario Outline: The Settings Modal is displayed correctly after Background mode
    Given I am launching the application
    When The phone goes to Background mode for <mills> seconds
    Then The Settings Modal is displayed correctly

    Examples:
      | mills |
      | 2       |