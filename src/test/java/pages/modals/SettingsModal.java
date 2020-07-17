package pages.modals;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

import static step.Hooks.getDriver;

public class SettingsModal extends BasePage {

    @AndroidFindBy(xpath = "//*[contains(@text,'Настройка')]")
    private MobileElement settingsModalTitle;
    @AndroidFindBy (xpath = "//*[contains(@text,'Основной язык')][1]")
    private MobileElement primeryLanguageLabel;
    @AndroidFindBy (xpath = "//*[contains(@text,'Основной язык перевода')]")
    private MobileElement translationLanguageLabel;
    @AndroidFindBy (className = "android.widget.CheckBox")
    private MobileElement offlineCheckBox;
    @AndroidFindBy (className = "android.widget.Button")
    private MobileElement closeButton;
    @AndroidFindBy (xpath = "//*[@resource-id='com.google.android.apps.translate:id/primary_lang_spinner']/*[@resource-id='android:id/text1']")
    private MobileElement primeryLanguage;
    @AndroidFindBy (xpath = "//*[@class='android.widget.CheckedTextView' and @index='1']")
    private MobileElement chosenPrimeryLanguage;
    @AndroidFindBy (xpath = "//*[@resource-id='com.google.android.apps.translate:id/translation_lang_spinner']/*[@resource-id='android:id/text1']")
    private MobileElement translationLanguage;
    @AndroidFindBy (xpath = "//*[@class='android.widget.CheckedTextView' and @index='1']")
    private MobileElement chosentranslationLanguage;


    public SettingsModal() {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    public void tapGotItButton() {
        tapElement(closeButton);
    }

    public boolean isSettingsModalDisplayed() {
        return isElementPresent(settingsModalTitle)
                && isElementPresent(primeryLanguageLabel)
                &&isElementPresent(translationLanguageLabel)
                && settingsModalTitle.getText().equalsIgnoreCase("Настройка");
    }
}
