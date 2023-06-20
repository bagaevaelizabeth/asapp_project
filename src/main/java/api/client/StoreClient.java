package api.client;

import api.bin.Product;
import api.bin.Quantity;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface StoreClient {

    @POST("{username}/products/{product}/add")
    Call<String> addToCart(
            @Path("username") String username,
            @Path("product") String product,
            @Body Quantity quantity);

    @GET("{username}/products/{product}")
    Call<Product> getProduct(
            @Path("username") String username,
            @Path("product") String product);
}
