package tests;

import pages.HomePage;
import utils.RandomEmail;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ContactFromPage;
import pages.LoginPage;
import pages.RegistrationPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RegistrationPageTest {

    WebDriver driver;
    @BeforeEach
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dapadurean\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
    }

    @Test
    public void canSendContactRequestWithValidData() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        String email = RandomEmail.generateRandomEmail();
        registrationPage.fillInRegistrationForm("meh","meh",email,"meh", "mehmeh", "mehmeh");
    }

    @Test
    public void verifyLoginAfterSuccessfulRegistration(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        String email = RandomEmail.generateRandomEmail();
        registrationPage.fillInRegistrationForm("meh","meh",email,"meh", "mehmeh", "mehmeh");
        registrationPage.logout();
        LoginPage loginPage = registrationPage.goToLoginPage();
        loginPage.completeLoginPage(email, "mehmeh");


    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
