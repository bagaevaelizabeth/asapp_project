package api;

import api.bin.Product;
import api.bin.Quantity;
import api.bin.User;
import api.steps.LoginRegisterSteps;
import api.steps.StoreSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;

import static api.Utils.getRandomString;
import static org.assertj.core.api.Assertions.assertThat;

public class StoreTest {
    private final String ASAPP_PENS = "ASAPP Pens";
    private final LoginRegisterSteps loginRegisterSteps = LoginRegisterSteps.getInstance();
    private final StoreSteps storeSteps = StoreSteps.getInstance();

    private Quantity quantity;
    private User user;

    @BeforeEach
    public void preparation() throws IOException {
        user = new User(getRandomString(), getRandomString());
        loginRegisterSteps.registerAndLoginUser(user);
        quantity = new Quantity(1);
    }

    @Test
    public void checkAddPensToCart() throws IOException {
        Response<String> response = storeSteps.addToCart(user, ASAPP_PENS, quantity);
        assertThat(response.code()).isEqualTo(200);
    }

    @Test
    public void checkUserCanNOTAddProductsToCartMoreThanInStock() throws IOException {
        Response<Product> getProductResponse = storeSteps.getProduct(user, ASAPP_PENS);
        Quantity quantity = new Quantity(getProductResponse.body().getProduct_qty() + 1);

        Response<String> addProductResponse = storeSteps.addToCart(user, ASAPP_PENS, quantity);
        assertThat(addProductResponse.code()).isEqualTo(400);
    }
}
