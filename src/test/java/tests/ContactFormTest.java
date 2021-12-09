package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ContactFromPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactFormTest {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dapadurean\\IdeaProjects\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/contactus");
    }

    @Test
    public void checkValidContactForm(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dapadurean\\IdeaProjects\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/contactus");

        ContactFromPage formPage = new ContactFromPage(driver);
        ContactFromPage formResult = formPage.completeForm("Alexandru", "", "Bla bla bla bla bla");

    }

//    @Test
//    public void checkErrorMessage(){
//        ContactFromPage formPage = new ContactFromPage(driver);
//        formPage.completeForm("","","");
//        assertEquals(formPage.checkFullNameErrMess(), "Enter your name");
//        assertEquals(formPage.checkEmailErrMess(), "Enter email");
//        assertEquals(formPage.checkEnquiryErrMess(), "Enter enquiry");
//    }
//
//    @Test
//    public void checkValidEmail(){
//
//        ContactFromPage formPage = new ContactFromPage(driver);
//        formPage.completeForm("asd","asd","asd");
//        assertEquals(formPage.checkEmailErrMess(), "Wrong email");
//
//    }


    @AfterEach
    public void tearDown() {

        driver.quit();

    }


}
