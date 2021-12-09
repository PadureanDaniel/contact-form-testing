package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "Email")
    private WebElement userNameInput;

    @FindBy(id = "Password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    private WebElement loginButton;

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void completeLoginPage(String email, String password){

        userNameInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();

    }
}
