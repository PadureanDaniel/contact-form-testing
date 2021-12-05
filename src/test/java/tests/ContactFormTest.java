package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ContactFromPage;
import pages.ContactFromResultPage;

public class ContactFormTest {

    @Test
    public void checkValidContactForm(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dapadurean\\IdeaProjects\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/contactus");

        ContactFromPage formPage = new ContactFromPage(driver);
        ContactFromResultPage formResult = formPage.completeForm("Alexandru", "Alexandru.florin@cosmin.com", "Bla bla bla bla bla");

    }


}
