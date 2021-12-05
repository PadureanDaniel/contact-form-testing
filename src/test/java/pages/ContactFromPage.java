package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactFromPage {

    @FindBy(xpath = "//input[@id='FullName']")
    private WebElement yourNameTextBox;

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement yourEmailTextBox;

    @FindBy(xpath = "//textarea[@id='Enquiry']")
    private WebElement enquiryTextBox;

    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    private WebElement submitForm;

    protected WebDriver driver;

    public ContactFromPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public ContactFromResultPage completeForm(String query1, String query2, String query3){

        yourNameTextBox.sendKeys(query1);
        yourEmailTextBox.sendKeys(query2);
        enquiryTextBox.sendKeys(query3);

        submitForm.click();

        return new ContactFromResultPage(driver);

    }

}
