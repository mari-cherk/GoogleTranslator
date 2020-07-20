package step.definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import static org.assertj.core.api.Assertions.assertThat;

import cucumber.api.java.en.When;
import org.assertj.core.api.Assert;
import pages.modals.SettingsModal;
import utils.DeviceService;

import static org.junit.Assert.assertEquals;
import static step.Hooks.getDriver;

public class SettingsModalTests {

    SettingsModal settingsModal = new SettingsModal();

    @Given("^I am launching the application$")
    public void i_am_launching_the_application() {
        /*DeviceService deviceService = new DeviceService(getDriver());
        deviceService.removeApp();
        deviceService.installNewBuild();*/
        assertThat(settingsModal.isSettingsModalDisplayed()).isEqualTo(true);

    }

    @Then("^The Settings Modal opens$")
    public void the_Settings_Modal_opens() {
        //assertThat(settingsModal.isSettingsModalDisplayed()).isEqualTo(true);
        assertThat(settingsModal.isCloseButtonPresent()).isEqualTo(true);
    }

    @Given("^I am on Settings Modal$")
    public void i_am_on_Settings_Modal() {
        assertThat(settingsModal.isSettingsModalDisplayed()).isEqualTo(true);
    }

    @When("^I change primary language$")
    public void i_change_primary_language() {
        settingsModal.tapPrimaryLanguage();
        String neededLanguage = settingsModal.getChosenPrimaryLanguage();
        System.out.println(neededLanguage);
        settingsModal.tapChosenPrimaryLanguage();
        System.out.println(settingsModal.getPrimaryLanguage());
        assertEquals("The primary language wasn't changed", neededLanguage, settingsModal.getPrimaryLanguage().toLowerCase());
    }

    @Then("^The changing primary language is applied$")
    public void the_changing_primary_language_is_applied() {
        assertThat(settingsModal.getPrimaryLanguage().contains("РУССКИЙ")).isEqualTo(false);
    }


}
