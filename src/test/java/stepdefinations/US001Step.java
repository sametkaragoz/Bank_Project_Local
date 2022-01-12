package stepdefinations;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.Locators;
import utilities.ConfigurationReader;
import utilities.Driver;

public class US001Step {

    Locators locators = new Locators();
    Faker faker = new Faker();
    // actions objesi olusturulurken parametre olarak driverimizi gireriz
    Actions actions = new Actions(Driver.getDriver());
    String password = faker.random().hex(7) + ".a";

    @When("GMIBank sayfasina gidilir")
    public void gmi_bank_sayfasina_gidilir() {
        Driver.getDriver().get(ConfigurationReader.getProperty("GMIBANKURL"));
    }

    @Then("Sag ustteki insan figurune tiklanir ve ardindan register butonuna tiklanir")
    public void sagUsttekiInsanFiguruneTiklanirVeArdindanRegisterButonunaTiklanir() {
        locators.insanFiguru.click();
        locators.registerButonu.click();
    }

    @Then("Acilan Registration sayfasinin dogru sayfa oldugu kontrol edilir")
    public void acilanRegistrationSayfasininDogruSayfaOlduguKontrolEdilir() {
        Assert.assertTrue(locators.registrationSayfasiYazisiElementi.isDisplayed());
    }

    @Then("SSN, 9 haneli ve ***-**-**** formatinda olmalidir")
    public void ssn_haneli_ve_formatinda_olmalidir() {
        locators.ssnBox.sendKeys(faker.idNumber().ssnValid());
        actions.sendKeys(Keys.TAB).perform();
    }

    @Then("First Name bilgisi girilir")
    public void first_name_bilgisi_girilir() {
        actions.sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .perform();
    }

    @Then("Last Name bilgisi girilir")
    public void last_name_bilgisi_girilir() {
        actions.sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .perform();
    }

    @Then("Adress bilgisi girilir")
    public void adress_bilgisi_girilir() {
        actions.sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .perform();
    }

    @Then("Phone Number, 10 haneli ve ***-***-**** formatinda olmalidir")
    public void phone_number_10_haneli_ve__formatinda_olmalidir() {
        actions.sendKeys(String.valueOf(faker.number().digits(10)))
                .sendKeys(Keys.TAB)
                .perform();
        String actualPhoneNumber = locators.phoneNumberBox.getAttribute("value");
        Assert.assertEquals(actualPhoneNumber.indexOf("-"), 3);
        Assert.assertEquals(actualPhoneNumber.substring(7, 8), "-");
        Assert.assertEquals(actualPhoneNumber.length(), 12);
    }

    @Then("Username bilgisi girilir")
    public void username_bilgisi_girilir() {
        actions.sendKeys(faker.name().username())
                .sendKeys(Keys.TAB)
                .perform();
    }

    @Then("Email, '@' ve '.' karakterlerini icermelidir")
    public void email_at_ve_nokta_karakterlerini_icermelidir() {
        actions.sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .perform();
        String actualEmailBox = locators.emailBox.getAttribute("value");
        Assert.assertTrue(actualEmailBox.contains("@") && actualEmailBox.contains("."));
    }

    @Then("New password, en guclu olmasi icin en az bir rakam, buyuk harf, ozel karakter ve toplam 7 hane icermelidir")
    public void new_password_en_guclu_olmasi_icin_en_az_bir_rakam_buyuk_harf_ozel_karakter_ve_toplam_7_hane_icermelidir() {
        actions.sendKeys(password)
                .sendKeys(Keys.TAB)
                .perform();
    }

    @Then("Password strength, tum barlar dolmali ve yesil olmalidir")
    public void password_strength_tum_barlar_dolmali_ve_yesil_olmalidir() {
        Assert.assertEquals(locators.passwordStrength.getAttribute("style"), "background-color: rgb(0, 255, 0);");
    }

    @Then("New password confirmation, new password ile ayni olmalidir")
    public void new_password_confirmation_new_password_ile_ayni_olmalidir() {
        String newPassword = locators.firstPasswordBox.getAttribute("value");
        actions.sendKeys(newPassword)
                .sendKeys(Keys.TAB)
                .perform();

    }

    @Then("Gerekli bilgi kutularinin hepsinin bos olmadigi test edilir")
    public void gerekli_bilgi_kutularinin_hepsinin_bos_olmadigi_test_edilir() {
        Assert.assertTrue(locators.ssnBox.isDisplayed());
        Assert.assertTrue(locators.firstNameBox.isDisplayed());
        Assert.assertTrue(locators.lastNameBox.isDisplayed());
        Assert.assertTrue(locators.addressBox.isDisplayed());
        Assert.assertTrue(locators.phoneNumberBox.isDisplayed());
        Assert.assertTrue(locators.usernameBox.isDisplayed());
        Assert.assertTrue(locators.emailBox.isDisplayed());
        Assert.assertTrue(locators.firstPasswordBox.isDisplayed());
        Assert.assertTrue(locators.secondPasswordBox.isDisplayed());
    }

    @Then("Register butonuna basilir ve kayit mesaji alinir")
    public void register_butonuna_basilir_ve_kayit_mesaji_alinir() {
        actions.sendKeys(Keys.SPACE).perform();
        Assert.assertTrue(locators.registrationSayfasiYazisiElementi.isDisplayed());
    }
}