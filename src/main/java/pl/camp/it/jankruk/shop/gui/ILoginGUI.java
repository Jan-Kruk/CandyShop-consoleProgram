package pl.camp.it.jankruk.shop.gui;

import pl.camp.it.jankruk.shop.model.user.User;

public interface ILoginGUI {
    String showMenu();
    User login(String username, String password);
    String inputUsername();
    String inputPassword();
    void showUserList();
    void register();
}
