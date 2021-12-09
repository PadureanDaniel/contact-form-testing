package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BuildYourComputer {

    @FindBy(xpath = "//select[@id='product_attribute_2']")
    private WebElement dropDownForRam;
    @FindBy(className = "option-list")
    private List<WebElement> radioButtonForHdd;
    @FindBy(id="add-to-cart-button-1")
    private WebElement addToCartButtonBuildYourPC;


    private WebDriver driver;
    WebDriverWait wait;


    public BuildYourComputer(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    public void selectRam (String ram){

        Select dropDownForRamVar = new Select(dropDownForRam);
        dropDownForRamVar.selectByVisibleText(ram);

    }
    public void selectHdd (String hdd){

        if(hdd.equalsIgnoreCase("320 gb"))
            driver.findElement(By.id("product_attribute_3_6")).click();
        else
            driver.findElement(By.id("product_attribute_3_7")).click();

    }
    public void addToCartProduct (){

        addToCartButtonBuildYourPC.click();

    }

}
