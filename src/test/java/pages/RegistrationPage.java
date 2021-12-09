package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegistrationPage {

    @FindBy(name = "Gender")
    private List<WebElement> genderRadioButtons; //both genders, male and female
    @FindBy(id = "FirstName")
    private WebElement firstName;
    @FindBy(id="LastName")
    private WebElement lastName;
    @FindBy(name = "DateOfBirthDay") // "0 element matching" -> Same for Month and Year
    private WebElement dayOfBirthDropdown;
    @FindBy(name = "DateOfBirthMonth")
    private WebElement monthOfBirthDropdown;
    @FindBy(name = "DateOfBirthYear")
    private WebElement yearOfBirthDropdown;
    @FindBy(id="Email")
    private WebElement email;
    @FindBy(id="Company")
    private WebElement companyName;
    @FindBy(id = "Newsletter")
    private WebElement newsletterCheckbox;
    @FindBy(id="Password")
    private WebElement password;
    @FindBy(id="ConfirmPassword")
    private WebElement confirmPassword;
    @FindBy(id="register-button")
    private WebElement registerButton;
    @FindBy(className="ico-logout")
    private WebElement logoutButton;
    @FindBy(className="ico-login")
    private WebElement loginButton;

    public void logout(){
        logoutButton.click();
    }

    public LoginPage goToLoginPage(){
        loginButton.click();
        return new LoginPage(driver);

    }

    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillInRegistrationForm(String firstname, String lastname, String Email,
                                       String companyname, String Password, String confirmpassword)
    {
        firstName.sendKeys(firstname);
        lastName.sendKeys(lastname);
        email.sendKeys(Email);
        companyName.sendKeys(companyname);
        password.sendKeys(Password);
        confirmPassword.sendKeys(confirmpassword);
        registerButton.click();
    }

    public void selectGender(String gender){
        if(gender.equalsIgnoreCase("male"))
            genderRadioButtons.get(0).click();
        else if (gender.equalsIgnoreCase("female"))
            genderRadioButtons.get(1).click();
    }

    public void selectDayOfBirth(String day) {
        Select dobDropdown = new Select(dayOfBirthDropdown);
        dobDropdown.selectByVisibleText(day);
    }

    public void selectMonthOfBirth(String month) {
        Select dobDropdown = new Select(monthOfBirthDropdown);
        dobDropdown.selectByVisibleText(month);
    }

    public void selectYearOfBirth(String year) {
        Select dobDropdown = new Select(yearOfBirthDropdown);
        dobDropdown.selectByVisibleText(year);
    }

    public void selectNewsletterCheckbox(){
        if(!newsletterCheckbox.isSelected()) // operatorul de negare
            newsletterCheckbox.click();
    }

}
