package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.LoginPage;

import java.net.MalformedURLException;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Before
    public void start() throws MalformedURLException {
        loginPage.initializeTest();
    }

    @After
    public void tearDown() {
        loginPage.tearDownTest();
    }

    @Given("^Kullanici giris sayfasini goruntuler$")
    public void kullaniciGirisSayfasiniGoruntuler() {
        loginPage.confirmFirstPage();
    }

    @And("Explore butonuna tiklanir")
    public void exploreButonunaTiklanir() {
        loginPage.clickExploreButton();
    }

    @And("Hesabim butonuna tiklanir")
    public void hesabimButonunaTiklanir() {
        loginPage.clickAccountButton();
    }

    @And("Continue with Email butonuna tiklanir")
    public void continueWithEmailButonunaTiklanir() {
        loginPage.clickContinueWithEmailButton();
    }

    @And("^Email address kutusu (.*) ile doldurulur$")
    public void emailAddressKutusuIleDoldurulur(String mail) {
        loginPage.sendKeysEmailTextButton(mail);
    }

    @And("Ana sayfa goruntulenir")
    public void anaSayfaGoruntulenir() {
        loginPage.confirmHomePage();
    }

    @And("^Sayfa uzerindeki (.*) yazisi gorulur$")
    public void sayfaUzerindekiYazisiGorulur(String text) {
        loginPage.textIsVisible(text);
    }

    @And("Daha once giris yapılmıssa giris secenekleri sekmesi asagi kaydirilir")
    public void dahaOnceGirisYapılmıssaGirisSecenekleriSekmesiAsagiKaydirilir() {
        loginPage.swipeLineElement();
    }

    @And("Send butonuna tiklanir")
    public void sendButonunaTiklanir() {
        loginPage.clickSendButton();
    }

    @And("^Dil olarak (.*) secilir$")
    public void dilOlarakSecilir(String language) {
        loginPage.selectLanguage(language);

    }
}
