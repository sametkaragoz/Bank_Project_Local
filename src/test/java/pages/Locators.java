package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Locators {

    public Locators() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "")
    public WebElement aa;

    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement insanFiguru;

    @FindBy(xpath = "//span[text()='Register']")
    public WebElement registerButonu;

    @FindBy(xpath = "//span[text()='Registration']")
    public WebElement registrationSayfasiYazisiElementi;

    @FindBy(xpath = "//input[@name='ssn']")
    public WebElement ssnBox;

    @FindBy(xpath = "//input[@name='firstname']")
    public WebElement firstNameBox;

    @FindBy(xpath = "//input[@name='lastname']")
    public WebElement lastNameBox;

    @FindBy(xpath = "//input[@name='address']")
    public WebElement addressBox;

    @FindBy(xpath = "//input[@name='mobilephone']")
    public WebElement phoneNumberBox;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@name='firstPassword']")
    public WebElement firstPasswordBox;

    @FindBy(xpath = "(//li[@class='point'])[5]")
    public WebElement passwordStrength;

    @FindBy(xpath = "//input[@name='secondPassword']")
    public WebElement secondPasswordBox;

    @FindBy(xpath = "//strong[text()='Registration saved!']")
    public WebElement registrationSavedElementi;

    @FindBy(xpath = "")
    public WebElement aaurthg;

    @FindBy(xpath = "")
    public WebElement aahtrfgf;

    @FindBy(xpath = "")
    public WebElement aayujhg;

    @FindBy(xpath = "")
    public WebElement aatyjghm;

    @FindBy(xpath = "")
    public WebElement aaloik;

    @FindBy(xpath = "")
    public WebElement aaktguyj;

    @FindBy(xpath = "")
    public WebElement aakukj;
}
