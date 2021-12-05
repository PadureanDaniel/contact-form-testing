package pages;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactFromResultPage {

    protected WebDriver driver;

    public ContactFromResultPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//*[@class='result']")
    private String formSentSuccessfully;

    public String getTextFromResultPage() {

        String succes = formSentSuccessfully;

        return succes;


    }

}
