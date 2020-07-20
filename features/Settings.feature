@smoke
Feature: Settings Modal

  Scenario: Settings Modal should be shown when starting the app
    Given I am launching the application
    Then The Settings Modal opens


 # Scenario: User should be able to choose primary language
  #  Given I am on Settings Modal
  #  When I change primary language to language
  #  Then The chosenLanguage primary language is applied

    #Examples:
    #  | language      | chosenLanguage |
     # | "самоанский"  | "САМОАНСКИЙ"   |

  #Scenario Outline: User should be able to choose translation language
   # Given I am on Settings Modal
   # When I change translation language to <language>
   # Then The <chosenLanguage> translation language is applied

   # Examples:
    #  | language   | chosenLanguage |
    #  | "арабский"  | "АРАБСКИЙ"      |

  Scenario: User should be able to uncheck translation checkbox
    Given I am on Settings Modal
    When I tap translation checkbox
    Then The translation checkbox is unchecked