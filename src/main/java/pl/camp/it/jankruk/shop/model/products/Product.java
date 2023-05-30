package pl.camp.it.jankruk.shop.model.products;

import pl.camp.it.jankruk.shop.model.Writeable;

public class Product implements IProduct, Writeable {
    private String name;
    private int price;
    private int quantity;

    public Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product name: " + this.name + " | price: " + this.price + "zł | quantity: "
                +this.quantity;
    }

    @Override
    public String saveToFile() {
        return "Product"+";"+name+";"+price+";"+quantity;
    }
    @Override
    public void buyProduct( int quantity){
       this.quantity-= quantity;
    }
    public void restockProduct(int quantity){
        this.quantity += quantity;
    }
    @Override
    public int getQuantity() {
        return quantity;
    }
    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public int getPrice() {
        return price;
    }
}
