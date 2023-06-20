package api.steps;

import api.client.LoginRegisterClient;
import api.client.StoreClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import utils.ConfProperties;

public class AsappService {
    private static AsappService mInstance;
    private Retrofit retrofit;
    private Gson gson;

    private AsappService() {
        gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder()
                .baseUrl(ConfProperties.getProperty("baseurl"))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static AsappService getInstance() {
        if (mInstance == null) {
            mInstance = new AsappService();
        }
        return mInstance;

    }

    public LoginRegisterClient getLoginClient() {
        return retrofit.create(LoginRegisterClient.class);
    }

    public StoreClient getStoreClient() {
        return retrofit.create(StoreClient.class);
    }
}
