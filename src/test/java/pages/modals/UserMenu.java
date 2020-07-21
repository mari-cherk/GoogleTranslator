package pages.modals;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

import static step.Hooks.getDriver;

public class UserMenu extends BasePage {

    @AndroidFindBy(id = "com.google.android.apps.translate:id/account_list_button")
    private MobileElement listButton;

    @AndroidFindBy(id = "com.google.android.apps.translate:id/menu_home")
    private MobileElement menuHome;

    @AndroidFindBy(id = "com.google.android.apps.translate:id/menu_phrasebook")
    private MobileElement menuPphrasebook;

    @AndroidFindBy(id = "com.google.android.apps.translate:id/menu_offline")
    private MobileElement menuOffline;

    @AndroidFindBy(id = "com.google.android.apps.translate:id/menu_settings")
    private MobileElement menuSettings;

    @AndroidFindBy(id = "com.google.android.apps.translate:id/menu_help_n_feedback")
    private MobileElement menuHelpAndFeedback;


    public UserMenu() {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    public boolean isUserMenuDisplayed() {
        return isElementPresent(listButton)
                && isElementPresent(menuHome)
                &&isElementPresent(menuOffline)
                && isElementPresent(menuHelpAndFeedback);
    }
}
