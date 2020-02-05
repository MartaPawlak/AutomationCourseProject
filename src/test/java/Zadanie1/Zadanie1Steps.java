package Zadanie1;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class Zadanie1Steps {
    private static WebDriver driver;

    @Given("^open website https://prod-kurs\\.coderslab\\.pl/index\\.php\\?controller=authentication&back=addresses$")
    public void openWebsiteHttpsProdKursCoderslabPlIndexPhpControllerAuthenticationBackAddresses() {
        System.setProperty("webdriver.gecko.driver",
                "src/main/resources/drivers/geckodriver");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
    }

    @When("^log in to user account <Email> i <Password>$")
    public void logInToUserAccountEmailIPassword(String email, String password) {
        WebElement Email = driver.findElement(By.name("email"));
        Email.click();
        Email.clear();
        Email.sendKeys(email);

        WebElement Password = driver.findElement(By.name("password"));
        Password.click();
        Password.clear();
        Password.sendKeys(password);

        WebElement signInButton = driver.findElement(By.name("submit-login"));
        signInButton.click();
    }

    @Then("^click user button$")
    public void clickUserButton() {
        WebElement User = driver.findElement(By.className("hidden-sm-down"));
        User.click();
        }


    @Then("^click Create new address$")
    public void clickCreateNewAddress() {
        WebElement CreateNewAddress = driver.findElement(By.id("address-link"));
        CreateNewAddress.click();
    }

    @And("^entered alias <alias>$")
    public void enteredAliasAlias(String alias) {
        WebElement Alias = driver.findElement( By.id("alias"));
        Alias.clear();
        Alias.sendKeys(alias);
    }

    @And("^entered address <address>$")
    public void enteredAddressAddress(String address) {
        WebElement Address = driver.findElement(By.id("address"));
        Address.clear();
        Address.sendKeys(address);
    }

    @And("^entered city <city>$")
    public void enteredCityCity(String city) {
        WebElement City = driver.findElement(By.id("city"));
        City.clear();
        City.sendKeys(city);
    }

    @And("^entered zip <zip>$")
    public void enteredZipZip(String zip) {
        WebElement Zip = driver.findElement(By.id("zip"));
        Zip.clear();
        Zip.sendKeys(zip);
    }

    @And("^entered country <country>$")
    public void enteredCountryCountry(String country) {
        WebElement Country = driver.findElement(By.id("country"));
        Country.clear();
        Country.sendKeys(country);
    }

    @And("^entered phone <phone>$")
    public void enteredPhonePhone(String phone) {
        WebElement Phone = driver.findElement(By.id("phone"));
        Phone.clear();
        Phone.sendKeys(phone);
    }

    @And("^submit new address$")
    public void submitNewAddress() {
    }

}

