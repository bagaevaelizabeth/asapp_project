package ui;

import api.bin.User;
import api.steps.LoginRegisterSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.mvp.LoginPageSteps;
import ui.mvp.StorePageSteps;
import utils.ConfProperties;

import java.io.IOException;

import static api.Utils.getRandomString;
import static ui.mvp.LoginPageSteps.getInstance;

public class LoginTest extends BaseTest{

    private User user;
    private LoginPageSteps loginPage;
    private StorePageSteps storePage;
    private LoginRegisterSteps loginRegisterSteps;

    @BeforeEach
    public void prepareData() {
        loginPage = getInstance(webDriver);
        storePage = StorePageSteps.getInstance(webDriver);
        loginRegisterSteps = LoginRegisterSteps.getInstance();
        user = new User(getRandomString(), getRandomString());
        webDriver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public void checkExistedUserCanLogin() throws IOException {
        loginRegisterSteps.registerNewUser(user);
        loginPage
                .setUserName(user.getUsername())
                .setPassword(user.getPassword())
                .clickLogInButton();
        storePage
                .checkHeaderIsDisplayed();
    }

    @Test
    public void checkUnregisteredUserCanNOTLogin() {
        loginPage
                .setUserName(user.getUsername())
                .setPassword(user.getPassword())
                .clickLogInButton()
                .checkPleaseLoginIsDisplayed();
    }
}
