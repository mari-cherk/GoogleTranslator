package pages.modals;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

import static step.Hooks.getDriver;

public class SettingsModal extends BasePage {

    @AndroidFindBy(xpath = "//*[contains(@text,'Настройка')]")
    private MobileElement settingsModalTitle;
    @AndroidFindBy (xpath = "//*[contains(@text,'Основной язык')][1]")
    private MobileElement primaryLanguageLabel;
    @AndroidFindBy (xpath = "//*[contains(@text,'Основной язык перевода')]")
    private MobileElement translationLanguageLabel;
    @AndroidFindBy (className = "android.widget.CheckBox")
    private MobileElement offlineCheckBox;
    @AndroidFindBy (className = "android.widget.Button")
    private MobileElement closeButton;
    @AndroidFindBy (xpath = "//*[@resource-id='com.google.android.apps.translate:id/primary_lang_spinner']/*[@resource-id='android:id/text1']")
    private MobileElement primaryLanguage;
    @AndroidFindBy (xpath = "//*[@class='android.widget.CheckedTextView' and @index='1']")
    private MobileElement chosenPrimaryLanguage;
    @AndroidFindBy (xpath = "//*[contains(@text,'азербайджанский')]")
    public MobileElement azerPrimaryLanguage;
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
                && isElementPresent(primaryLanguageLabel)
                &&isElementPresent(translationLanguageLabel)
                && settingsModalTitle.getText().equalsIgnoreCase("Настройка");
    }

    public boolean isCloseButtonPresent() {
        return isElementPresent(closeButton);
    }

    public boolean isOfflineCheckboxChecked() {
        return offlineCheckBox.isSelected();
    }

    public void tapPrimaryLanguage(){
        waitToBeVisible(primaryLanguage);
        tapElement(primaryLanguage);
    }

    public void tapOfflineCheckbox(){
        waitToBeVisible(offlineCheckBox);
        tapElement(offlineCheckBox);
    }

    public void tapTranslationLanguage(){
        tapElement(translationLanguage);
    }

    public String getPrimaryLanguage(){
        waitToBeVisible(primaryLanguage);
        return primaryLanguage.getText();
    }

    public String getTranslationLanguage(){
        waitToBeVisible(translationLanguage);
        return translationLanguage.getText();
    }

    public void scrollToTopLanguage(MobileElement element){
        for (int i = 0; i < 15; i++) {
            try {
                waitToBeVisible(element);
                break;
            } catch (NoSuchElementException | TimeoutException e) {
                scrollUpList(2);
            }
        }
        // to scroll card into view fully
        scrollUpList(1);
    }

    public void scrollDownToLanguage(String language){
        //MobileElement element = getDriver().findElement(By.xpath("//*[contains(@text,'" + language +"')]"));
        for (int i = 0; i < 10; i++) {
            try {
                waitToBeVisible(getDriver().findElement(By.xpath("//*[contains(@text,'" + language +"')]")));
                break;
            } catch (NoSuchElementException | TimeoutException e) {
                scrollDownList(1);
            }
        }
        // to scroll card into view fully
        scrollDownList(1);
    }

    public void chooseNeededLanguage(String language) {
        if (getDriver().findElement(By.xpath("//*[contains(@text,'" + language + "')]")).isDisplayed()) {
            tapElement(getDriver().findElement(By.xpath("//*[contains(@text,'" + language + "')]")));
        } else {
            for (int i = 0; i < 10; i++) {
                try {
                    waitToBeVisible(getDriver().findElement(By.xpath("//*[contains(@text,'" + language + "')]")));
                    break;
                } catch (NoSuchElementException | TimeoutException e) {
                    scrollDownList(1);
                }
            }
            // to scroll card into view fully
            tapElement(getDriver().findElement(By.xpath("//*[contains(@text,'" + language + "')]")));
        }
    }

    public void chooseLanguage(String language) {
        String xPath = "//*[contains(@text,'" + language + "')]";
        waitToBeVisible(getDriver().findElement(By.xpath(xPath)));
            tapElement(getDriver().findElement(By.xpath(xPath)));
    }


}
