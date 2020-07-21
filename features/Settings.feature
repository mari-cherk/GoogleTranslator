@smoke
Feature: Settings Modal

  Scenario: Settings Modal should be shown when starting the app
    Given I am launching the application
    Then The Settings Modal opens


  Scenario Outline: User should be able to choose primary language
    Given I am on Settings Modal
    When I change primary language to <language>
    Then The <chosenLanguage> primary language is applied

    Examples:
      | language     | chosenLanguage |
      | "английский" | "АНГЛИЙСКИЙ"   |

  Scenario Outline: User should be able to choose translation language
    Given I am on Settings Modal
    When I change translation language to <language>
    Then The <chosenLanguage> translation language is applied

    Examples:
      | language   | chosenLanguage |
      | "русский"  | "РУССКИЙ"      |

  Scenario: User should be able to uncheck translation checkbox
    Given I am on Settings Modal
    When I tap translation checkbox
    Then The translation checkbox is unchecked

  Scenario: User should be able to close Settings Modal
    Given I am on Settings Modal
    When I tap Close button
    Then The Settings Modal closes
    Then The User Menu opens