package pl.camp.it.jankruk.shop.database;

import org.springframework.stereotype.Component;
import pl.camp.it.jankruk.shop.model.products.Product;

import java.util.HashMap;

@Component
public class CandyDB implements ICandyDB{
    private final HashMap<String, Product> products = new HashMap<>();
    @Override
    public void showProductList(){
        products.values().forEach(System.out::println);
    }
    @Override
    public boolean checkIfExsistInCollection(String product){
        return products.containsKey(product.toLowerCase());
    }
    @Override
    public boolean checkQuantityOfProduct(String product, int quantity){
        return quantity <= products.get(product).getQuantity();
    }

    @Override
    public void buyProduct(String product, int quantity){
        products.get(product.toLowerCase()).buyProduct(quantity);
    }
    @Override
    public void restockProduct(String product, int quantity){
        products.get(product.toLowerCase()).restockProduct(quantity);
    }

    @Override
    public HashMap<String, Product> getProducts() {
        return products;
    }

}
