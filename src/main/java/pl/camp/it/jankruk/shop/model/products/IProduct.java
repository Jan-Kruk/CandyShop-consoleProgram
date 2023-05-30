package pl.camp.it.jankruk.shop.model.products;

public interface IProduct {
    String toString();
    int getQuantity();
    void setQuantity(int quantity);
    void buyProduct( int quantity);

   int getPrice();
}
