package step.definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.modals.SettingsModal;

public class RotationTests {

    SettingsModal settingsModal = new SettingsModal();

    @When("^I rotate phone$")
    public void i_rotate_phone() {
        settingsModal.rotateToLandscape();
    }

    @Then("^The Settings Modal is displayed correctly$")
    public void the_Settings_Modal_is_displayed_correctly() {
        settingsModal.isSettingsModalDisplayed();
    }
}
