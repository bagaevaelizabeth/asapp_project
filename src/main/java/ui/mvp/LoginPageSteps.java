package ui.mvp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class LoginPageSteps {

    private static LoginPageSteps loginPageInstance;
    private WebDriver driver;

    private LoginPageSteps(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }

    public static LoginPageSteps getInstance(WebDriver driver) {
        if (loginPageInstance == null) {
            loginPageInstance = new LoginPageSteps(driver);
        }
        return loginPageInstance;
    }

    @FindBy(id = "username")
    WebElement userNameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(xpath = "//*[text()='Please Login']")
    WebElement title;

    @FindBy(xpath = "//*[text()='Log In']")
    WebElement logInButton;

    public LoginPageSteps setUserName(String userName) {
        userNameInput.clear();
        userNameInput.sendKeys(userName);
        return this;
    }

    public LoginPageSteps setPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginPageSteps clickLogInButton() {
        logInButton.isDisplayed();
        logInButton.click();
        return this;
    }

    public LoginPageSteps checkPleaseLoginIsDisplayed() {
        title.isDisplayed();
        return this;
    }

}
