package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BuildYourComputer;

public class BuildYourComputerTest {

    WebDriver driver;
    @BeforeEach
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dapadurean\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/build-your-own-computer");
    }

    @Test
    public void checkSuccesfulBuildYourComputer (){

        BuildYourComputer buildYourComputer = new BuildYourComputer(driver);

        buildYourComputer.selectRam("2 GB");
        buildYourComputer.selectHdd("400 GB");
        buildYourComputer.addToCartProduct();


    }


//    @AfterEach
//    public void tearDown(){
//        driver.quit();
//    }

}
