package pl.camp.it.jankruk.shop.database;

import org.springframework.stereotype.Component;
import pl.camp.it.jankruk.shop.model.products.Product;

import java.util.HashMap;


public interface ICandyDB {
    void showProductList();
    boolean checkIfExsistInCollection(String product);
    boolean checkQuantityOfProduct(String product, int quantity);
    void buyProduct(String product, int quantity);
    void restockProduct(String product, int quantity);
    HashMap<String, Product> getProducts();
}
