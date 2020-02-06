package Zadanie1;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

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

    @When("^log in to user account (.*) i (.*)$")
    public void logInToUserAccountEmailIPassword(String email, String password) {
        WebElement Email = driver.findElement(By.name("email"));
        Email.click();
        Email.clear();
        Email.sendKeys(email);

        WebElement Password = driver.findElement(By.name("password"));
        Password.click();
        Password.clear();
        Password.sendKeys(password);

        WebElement signInButton = driver.findElement(By.id("submit-login"));
        signInButton.click();
    }

    @Then("^click user button$")
    public void clickUserButton() {
        WebElement User = driver.findElement(By.className("account"));
        User.click();
        }


    @Then("^click Create new address$")
    public void clickCreateNewAddress() {
        WebElement CreateNewAddress = driver.findElement(By.cssSelector("#address-link > span:nth-child(1)"));
        CreateNewAddress.click();
    }

    @And("^entered alias (.*)$")
    public void enteredAliasAlias(String alias) {
        WebElement Alias = driver.findElement( By.name("alias"));
        Alias.clear();
        Alias.sendKeys(alias);
    }

    @And("^entered address (.*)$")
    public void enteredAddressAddress(String address) {
        WebElement Address = driver.findElement(By.name("address1"));
        Address.clear();
        Address.sendKeys(address);
    }

    @And("^entered city (.*)$")
    public void enteredCityCity(String city) {
        WebElement City = driver.findElement(By.name("city"));
        City.clear();
        City.sendKeys(city);
    }

    @And("^entered zip (.*)$")
    public void enteredZipZip(String zip) {
        WebElement Zip = driver.findElement(By.name("postcode"));
        Zip.clear();
        Zip.sendKeys(zip);
    }

    @And("^entered country (.*)$")
    public void enteredCountryCountry(String country) {
//        WebElement Country = driver.findElement(By.name("id_country"));
//        Actions(driver).keyDown(Keys.CONTROL).click(country);

        driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/form/section/div[10]/div[1]/select/option[1]")).click();
        driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/form/section/div[10]/div[1]/select/option[2]")).click();

    }

    @And("^entered phone (.*)$")
    public void enteredPhonePhone(String phone) {
        WebElement Phone = driver.findElement(By.name("phone"));
        Phone.clear();
        Phone.sendKeys(phone);
    }

    @And("^submit new address$")
    public void submitNewAddress() {
        WebElement Save = driver.findElement(By.cssSelector("button.btn"));
        Save.click();
    }

    @And("^delete address$")
    public void deleteAddress() {
        WebElement Delete = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div[1]/article/div[2]/a[2]"));
        Delete.click();
            }

    @And("^close browser$")
    public void closeBrowser() {
        driver.quit();
    }


}

