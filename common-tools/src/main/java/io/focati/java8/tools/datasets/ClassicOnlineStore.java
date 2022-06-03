package io.focati.java8.tools.datasets;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.focati.java8.tools.entity.OnlineShoppingCart;
import lombok.experimental.UtilityClass;

import java.io.IOException;

@UtilityClass
public class ClassicOnlineStore {

    public static OnlineShoppingCart getData() {

        OnlineShoppingCart shoppingCart;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            shoppingCart = objectMapper.readValue(classloader.getResourceAsStream("data-cart.json"), OnlineShoppingCart.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return shoppingCart;
    }

}
