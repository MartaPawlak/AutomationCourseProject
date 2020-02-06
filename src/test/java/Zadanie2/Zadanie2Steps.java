package Zadanie2;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class Zadanie2Steps {
    WebDriver driver;

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
    public void logInToUserAccountEmailIPassword(String Email, String Password) {
        Zadanie2Page page = new Zadanie2Page(driver);
        page.loginAs(Email, Password);
    }

    @Then("^in search box put Hummingbird Printed Sweater and click search$")
    public void inSearchBoxPutHummingbirdPrintedSweaterAndClickSearch() {

        Zadanie2Page page = new Zadanie2Page(driver);
        page.searchProduct();
    }

    @And("^click on Hummingbird Printed Sweater picture$")
    public void clickOnHummingbirdPrintedSweaterPicture() {
        Zadanie2Page page = new Zadanie2Page(driver);
        page.chooseProduct();
    }

    @And("^chose (.*)$")
    public void choseSize(String size) {
        Zadanie2Page page = new Zadanie2Page(driver);
        page.chooseProductSize(size);
    }

    @And("^write (.*)$")
    public void writeQuantity(char quantity) {
        Zadanie2Page page = new Zadanie2Page(driver);
        page.chooseProductQuantity(quantity);
    }

    @And("^add to cart$")
    public void addToCart() {
        Zadanie2Page page = new Zadanie2Page(driver);
        page.addToCart();
    }

    @And("^proceed to checkout$")
    public void proceedToCheckout() throws InterruptedException {
        Zadanie2Page page = new Zadanie2Page(driver);
        page.proceedToCheckout();
    }

    @And("^confirm proceed to checkout$")
    public void confirmProceedToCheckout() {
        Zadanie2Page page = new Zadanie2Page(driver);
        page.confirmProceedToCheckout();
    }

    @And("^confirm address$")
    public void confirmAddress() {
        Zadanie2Page page = new Zadanie2Page(driver);
        page.confirmDeliverAddress();
    }

    @And("^choose shipping method PrestaShop pick up in store,$")
    public void chooseShippingMethodPrestaShopPickUpInStore() {
        Zadanie2Page page = new Zadanie2Page(driver);
        page.chooseDelivery();
    }

    @And("^pay by check$")
    public void payByCheck() {
        Zadanie2Page page = new Zadanie2Page(driver);
        page.choosePayOption();
    }

    @And("^order with an obligation to pay$")
    public void orderWithAnObligationToPay() {
        Zadanie2Page page = new Zadanie2Page(driver);
        page.agreeOfTermsAndOrder();
    }

//    @And("^take a screenshot with confirmation of order$")
//    public void takeAScreenshotWithConfirmationOfOrder() {
//        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(scrFile, new File("//home///user//Pulpit//screen.jpg"));
//    }

    @And("^close browser$")
    public void closeBrowser() {
        driver.quit();
    }

}
