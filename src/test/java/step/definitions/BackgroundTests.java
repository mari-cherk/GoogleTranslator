package step.definitions;

import cucumber.api.java.en.When;
import pages.modals.SettingsModal;

public class BackgroundTests {

    SettingsModal settingsModal = new SettingsModal();

    @When("^The phone goes to Background mode for (\\d+) seconds$")
    public void the_phone_goes_to_Background_mode_for_seconds(int mills) {
        settingsModal.goToBackgroundMode(mills);
    }
}
