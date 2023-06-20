package api.login;

import api.bin.User;
import api.steps.LoginRegisterSteps;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;

import static api.steps.LoginRegisterSteps.getInstance;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginAndRegisterTest {

    private final LoginRegisterSteps loginRegisterSteps = getInstance();
    private User user;

    @BeforeEach
    public void preparation() {
        user = new User(getRandomString(), getRandomString());
    }

    @Test
    public void checkRegisterUser() throws IOException {
        Response<String> response = loginRegisterSteps.registerNewUser(user);
        assertThat(response.code()).isEqualTo(200);
    }

    @Test
    public void checkLoginExitedUser() throws IOException {
        loginRegisterSteps.registerNewUser(user);

        Response<String> response = loginRegisterSteps.loginUser(user);
        assertThat(response.code()).isEqualTo(200);
    }

    // Failed test (Bug: user can send empty login form and get 200 response)
    @Test
    public void checkEmptyUserDataLogin() throws IOException {
        User emptyUser = new User("", "");
        Response<String> response = loginRegisterSteps.loginUser(emptyUser);
        assertThat(response.code()).isEqualTo(409);
    }

    @Test
    public void checkEmptyUserDataRegister() throws IOException {
        User emptyUser = new User("", "");
        Response<String> response = loginRegisterSteps.registerNewUser(emptyUser);
        assertThat(response.code()).isEqualTo(409);
    }

    @Test
    public void checkRegisterExistedUser() throws IOException {
        loginRegisterSteps.registerNewUser(user);
        Response<String> response = loginRegisterSteps.registerNewUser(user);
        assertThat(response.code()).isEqualTo(409);
    }

    // Failed test (Bug: Register form allows sending user's data without a password)
    @Test
    public void checkRegisterUserWithoutPassword() throws IOException {
        User incorrectUser = new User(getRandomString(), "");
        Response<String> response = loginRegisterSteps.registerNewUser(incorrectUser);
        assertThat(response.code()).isEqualTo(409);
    }

    @Test
    public void checkRegisterUserWithoutUserName() throws IOException {
        User incorrectUser = new User("", getRandomString());
        Response<String> response = loginRegisterSteps.registerNewUser(incorrectUser);
        assertThat(response.code()).isEqualTo(409);
    }

    private String getRandomString() {
        return RandomStringUtils.randomAlphanumeric(5);
    }
}
