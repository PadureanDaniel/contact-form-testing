package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage {

    @FindBy(xpath = "//button[contains(@class, 'product-box-add-to-cart-button')]")
    private List<WebElement> addToCartButtons;
    @FindBy(className = "close")
    private WebElement closeNotificationButton;
    @FindBy(className = "cart-label")
    private WebElement shoppingCartLabel;
    @FindBy(className = "name")
    private List<WebElement> productsInCart;
    @FindBy(className = "valid")
    private WebElement dropDownForRam;
    @FindBy(id = "product_attribute_input_3")
    private List<WebElement> radioButtonForHdd;
    @FindBy(id="add-to-cart-button-1")
    private WebElement addToCartButtonBuildYourPC;




    private WebDriver driver;
    WebDriverWait wait;


    public HomePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void addToCartProductWithIndex (int index){

        addToCartButtons.get(index).click();

    }

//    public void addToCartProductWithIndex (int index, String ram, String hdd){
//
//        addToCartButtons.get(index).click();
//
//        if(index == 0 ){
//            wait.until(ExpectedConditions.urlToBe("https://demo.nopcommerce.com/build-your-own-computer"));
//            Select dropDownForRamVar = new Select(dropDownForRam);
//            dropDownForRamVar.selectByVisibleText(ram);
//            if(hdd.equalsIgnoreCase("320 GB"))
//                radioButtonForHdd.get(0).click();
//            else
//                radioButtonForHdd.get(1).click();
//        }
//        addToCartButtonBuildYourPC.click();
//    }

    public void closeAddToCartNotification(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(closeNotificationButton));
        closeNotificationButton.click();
        wait.until(ExpectedConditions.invisibilityOf(closeNotificationButton));


    }

    public List<String> getProductsFromCart() {

        Actions actions = new Actions(driver);
        actions.moveToElement(shoppingCartLabel).perform();
        wait.until(ExpectedConditions.visibilityOfAllElements(productsInCart));
        List<String> productNames = new ArrayList<>();
        for( int i = 0; i < productsInCart.size(); i++) {

            productNames.add(productsInCart.get(i).getText());

        }
        return productNames;
    }

//    public void selectRam (String ram){
//
//        Select dropDownForRamVar = new Select(dropDownForRam);
//        dropDownForRamVar.selectByVisibleText(ram);
//
//    }
//    public void selectHdd (String hdd){
//
//        if(hdd.equalsIgnoreCase("320 GB"))
//            radioButtonForHdd.get(0).click();
//        else
//            radioButtonForHdd.get(1).click();
//
//    }

}


