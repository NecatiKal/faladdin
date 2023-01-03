package pages;

import common.Action;
import common.BaseConfiguration;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;


public class LoginPage {

    public final By firstPagefaladdinLogo = By.id("com.faladdin.app:id/imgIcon");

    public final By languageCodeButton = By.id("com.faladdin.app:id/tvLanguageCode");

    public final By exploreButton = By.id("com.faladdin.app:id/getStartedButton");

    public final By homePageFaladdinLogo = By.id("com.faladdin.app:id/imgViewHeader");

    public final By accountButton = By.id("com.faladdin.app:id/imageBtnAccount");

    public final By continueWithEmailButton = By.id("com.faladdin.app:id/btnMail");

    public final By emailTextBox = By.id("com.faladdin.app:id/editTextEmail");

    public final By sendButton = By.id("com.faladdin.app:id/btnSend");


    Action action;

    public LoginPage() {
        action = new Action();
    }

    public void initializeTest() throws MalformedURLException {
        action.startDriver();
    }

    public void tearDownTest() {
        action.endDriver();
    }

    public void confirmFirstPage() {
        action.confirm(firstPagefaladdinLogo, "Uygulama açıldı");
    }

    public void selectLanguage(String language) {
        String languageCode = null;
        String xpath = null;
        WebElement element = null;

        switch (language) {

            case "English":
                languageCode = "EN";
                break;

            case "Türkçe":

                languageCode = "TR";
                break;
        }

        if (!Action.androidDriver.findElement(languageCodeButton).getText().equals(languageCode)) {
            action.fluentWaitForVisibility(languageCodeButton, 2);
            action.click(languageCodeButton, "Dil menüsü açıldı");

            xpath = "//*[contains(@text,'" + language + "')]";
            element = Action.androidDriver.findElement(By.xpath(xpath));
            element.click();
        }


    }

    public void clickExploreButton() {
        action.fluentWaitForVisibility(exploreButton, 2);
        action.click(exploreButton, "Explore butonuna tıklandı");
    }

    public void confirmHomePage() {
        action.confirm(homePageFaladdinLogo, "Ana sayfa görüntülendi");
    }

    public void clickAccountButton() {
        action.fluentWaitForVisibility(accountButton, 2);
        action.click(accountButton, "Hesabım butonuna tıklandı");
    }

    public void clickContinueWithEmailButton() {
        action.fluentWaitForVisibility(continueWithEmailButton, 2);
        action.click(continueWithEmailButton, "Continue with Email butonuna tıklandı");
    }

    public void sendKeysEmailTextButton(String eMail) {
        BaseConfiguration baseConfiguration = new BaseConfiguration();
        String text = baseConfiguration.getProperty(eMail);
        action.fluentWaitForVisibility(emailTextBox, 2);
        action.click(emailTextBox, "Continue with Email butonuna tıklandı");
        action.enter(emailTextBox, text, "Email kutusuna email adresi girildi");
    }

    public void clickSendButton() {
        action.fluentWaitForVisibility(sendButton, 2);
        action.click(sendButton, "Send butonuna tıklandı");
    }

    public boolean textControl(String textName) {

        try {
            action.staticWait(2000);
            String xpath = "//*[contains(@text,'" + textName + "')]";

            WebElement element = Action.androidDriver.findElement(By.xpath(xpath));
            Assert.assertTrue(element.isDisplayed());

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void textIsVisible(String text) {
        Assert.assertTrue(textControl(text));
    }

    public void swipeLineElement() {
        if (textControl("Select Account")) {
            action.pressBackButton("Giriş seçenekleri sekmesi aşağı kaydırıldı");
        }
    }
}
