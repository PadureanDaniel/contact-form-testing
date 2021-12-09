package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

public class HomePageTest {

    WebDriver driver;
    @BeforeEach
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dapadurean\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
    }
    @Test
    public void checkShoppingCartTest () {

        HomePage homePage = new HomePage(driver);
        homePage.addToCartProductWithIndex(2);
        homePage.closeAddToCartNotification();
        System.out.println(homePage.getProductsFromCart());

    }


    @AfterEach
    public void tearDown(){
        driver.quit();
    }

}
