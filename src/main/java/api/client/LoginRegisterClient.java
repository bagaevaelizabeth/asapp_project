package api.client;

import api.bin.User;
import retrofit2.Call;
import retrofit2.http.*;

public interface LoginRegisterClient {

    @POST("users/login")
    Call<String> login(
            @Body User user);

    @POST("users/register")
    Call<String> register(
            @Body User user);
}
