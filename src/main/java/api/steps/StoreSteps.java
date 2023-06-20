package api.steps;

import api.bin.Product;
import api.bin.Quantity;
import api.bin.User;
import api.client.StoreClient;
import retrofit2.Response;

import java.io.IOException;

public class StoreSteps {

    private final AsappService service = AsappService.getInstance();
    private final StoreClient storeClient = service.getStoreClient();

    private static StoreSteps storeStepsInstance;

    public static StoreSteps getInstance() {
        if (storeStepsInstance == null) {
            storeStepsInstance = new StoreSteps();
        }
        return storeStepsInstance;
    }

    public Response<String> addToCart(User user, String product, Quantity quantity) throws IOException {
        return storeClient.addToCart(user.getUsername(), product, quantity).execute();
    }

    public Response<Product> getProduct(User user, String product) throws IOException {
        return storeClient.getProduct(user.getUsername(), product).execute();
    }

}
