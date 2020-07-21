package step.definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import static org.assertj.core.api.Assertions.assertThat;
import cucumber.api.java.en.When;
import pages.modals.SettingsModal;
import pages.modals.UserMenu;

public class SettingsModalTests {

    SettingsModal settingsModal = new SettingsModal();
    UserMenu userMenu = new UserMenu();

    @Given("^I am launching the application$")
    public void i_am_launching_the_application() {
        assertThat(settingsModal.isSettingsModalDisplayed()).isEqualTo(true);

    }

    @Then("^The Settings Modal opens$")
    public void the_Settings_Modal_opens() {
        assertThat(settingsModal.isCloseButtonPresent()).isEqualTo(true);
    }

    @Given("^I am on Settings Modal$")
    public void i_am_on_Settings_Modal() {
        assertThat(settingsModal.isSettingsModalDisplayed()).isEqualTo(true);
    }


    @When("^I change primary language to \"([^\"]*)\"$")
    public void i_change_primary_language_to(String language) {
        settingsModal.tapPrimaryLanguage();
        settingsModal.scrollToTopLanguage(settingsModal.azerPrimaryLanguage);
        settingsModal.scrollDownToLanguage(language);
        settingsModal.chooseLanguage(language);
    }

    @Then("^The \"([^\"]*)\" primary language is applied$")
    public void the_primary_language_is_applied(String chosenLanguage){
        assertThat(settingsModal.getPrimaryLanguage().contains(chosenLanguage)).isEqualTo(true);
    }

    @When("^I change translation language to \"([^\"]*)\"$")
    public void i_change_translation_language_to(String language) {
        settingsModal.tapTranslationLanguage();
        settingsModal.scrollToTopLanguage(settingsModal.azerPrimaryLanguage);
        settingsModal.scrollDownToLanguage(language);
        settingsModal.chooseLanguage(language);

    }

    @Then("^The \"([^\"]*)\" translation language is applied$")
    public void the_translation_language_is_applied(String chosenLanguage) {
        assertThat(settingsModal.getTranslationLanguage().contains(chosenLanguage)).isEqualTo(true);
    }

    @When("^I tap translation checkbox$")
    public void i_tap_translation_checkbox() {
        settingsModal.tapOfflineCheckbox();
    }

    @Then("^The translation checkbox is unchecked$")
    public void the_translation_checkbox_is_unchecked() {
        assertThat(settingsModal.isOfflineCheckboxChecked()).isEqualTo(false);
    }

    @When("^I tap Close button$")
    public void i_tap_Close_button() {
        settingsModal.tapCloseButton();
    }

    @Then("^The Settings Modal closes$")
    public void the_Settings_Modal_closes() {
        assertThat(settingsModal.isSettingsModalDisplayed()).isEqualTo(false);
    }

    @Then("^The User Menu opens$")
    public void the_User_Menu_opens() {
        assertThat(userMenu.isUserMenuDisplayed()).isEqualTo(true);
    }

}
