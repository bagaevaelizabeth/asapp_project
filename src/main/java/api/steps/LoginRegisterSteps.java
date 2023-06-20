package api.steps;

import api.bin.User;
import api.client.LoginRegisterClient;
import retrofit2.Response;

import java.io.IOException;

public class LoginRegisterSteps {

    private final AsappService service = AsappService.getInstance();
    private final LoginRegisterClient loginClient = service.getLoginClient();
    private static LoginRegisterSteps loginRegisterStepsInstance;

    public static LoginRegisterSteps getInstance() {
        if (loginRegisterStepsInstance == null) {
            loginRegisterStepsInstance = new LoginRegisterSteps();
        }
        return loginRegisterStepsInstance;
    }

    public AsappService getService() {
        return service;
    }

    public Response<String> registerNewUser(User user) throws IOException {
         return loginClient.register(user).execute();
    }

    public Response<String> loginUser(User user) throws IOException {
        return loginClient.login(user).execute();
    }

    public void registerAndLoginUser(User user) throws IOException {
        registerNewUser(user);
        loginUser(user);
    }
}

