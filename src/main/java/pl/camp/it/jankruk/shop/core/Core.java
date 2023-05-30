package pl.camp.it.jankruk.shop.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.camp.it.jankruk.shop.database.IFileLoader;
import pl.camp.it.jankruk.shop.gui.ILoginGUI;
import pl.camp.it.jankruk.shop.gui.IShopGUI;
import pl.camp.it.jankruk.shop.model.user.User;

import java.io.IOException;

@Component
public class Core {
    @Autowired
    private IShopGUI shopGui;
    @Autowired
    private IFileLoader fileLoader;
    @Autowired
    private ILoginGUI loginGUI;
    public void start(){
        try {
            fileLoader.readDataFromFile();
        }catch (IOException e){
            System.out.println("DB corrupted");
        }
        boolean run = true;
        while(run){
            switch (loginGUI.showMenu()){
                case "1":
                    User user = loginGUI.login(loginGUI.inputUsername(), loginGUI.inputPassword());
                    if (user !=null){
                        shop(user);
                    }else{
                        System.out.println("Wrong username or password");
                    }
                    break;
                case "2":
                    loginGUI.register();
                    break;
                case "3":
                    run=false;
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        }

        try {
            fileLoader.saveDataToFile();
        }catch (IOException e){
            System.out.println("DB corrupted");
        }
    }
    public void shop(User user){
        boolean run = true;
        while (run){
            switch (shopGui.showMenu(user)){
                case "1":
                    shopGui.showProductList();
                    break;
                case "2":
                    shopGui.showProductList();
                    shopGui.buyProduct(shopGui.inputProductName());
                    break;
                case "3":
                    run =false;
                    break;
                case "4":
                    if (user.checkAdmin()){
                        shopGui.showProductList();
                        shopGui.restockItems(shopGui.inputProductName(), shopGui.inputProductQuantityToRestock());
                    }else{
                        System.out.println("Wrong input");
                    }
                    break;
                case "5":
                    if(user.checkAdmin()){
                        loginGUI.showUserList();
                        shopGui.changeUserAccess(shopGui.inputUserName());
                    }else{
                    System.out.println("Wrong input");
                    }
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        }
    }

}
