package pl.camp.it.jankruk.shop.gui;

import pl.camp.it.jankruk.shop.model.user.User;

public interface IShopGUI {
    String showMenu(User user);
    void showProductList();
    void buyProduct(String product);
    String inputProductName();
    int inputProductQuantityToBuy();
    void restockItems(String product, int quantity);
    int inputProductQuantityToRestock();
    void changeUserAccess(String user);
    String inputUserName();
}