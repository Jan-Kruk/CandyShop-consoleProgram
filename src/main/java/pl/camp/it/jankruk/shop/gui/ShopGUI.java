package pl.camp.it.jankruk.shop.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.camp.it.jankruk.shop.database.ICandyDB;
import pl.camp.it.jankruk.shop.database.IUserDB;
import pl.camp.it.jankruk.shop.model.user.User;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class ShopGUI implements IShopGUI {
    private final Scanner scanner = new Scanner(System.in);
    @Autowired
    private ICandyDB candyDB;
    @Autowired
    private IUserDB userDB;
    @Override
    public String showMenu(User user){
        System.out.println("1.Show product list");
        System.out.println("2.Buy product");
        System.out.println("3.Logout");
        if(user.checkAdmin()){
            System.out.println("4.Restock items");
            System.out.println("5.Change user access");
        }
        return scanner.next();
    }
    @Override
    public void showProductList(){
        candyDB.showProductList();
    }
    @Override
    public void buyProduct(String product){
        int scanned = inputProductQuantityToBuy();
        while (!candyDB.checkQuantityOfProduct(product,scanned)){
            System.out.println("Please input quantity below stock limit");
            scanned = inputProductQuantityToBuy();
        }
        candyDB.buyProduct(product,scanned);
        System.out.println("You succesfully bought " + scanned + " of " + product);
    }
    @Override
    public String inputProductName() {
        System.out.println("PLease enter exactly product name for example: Chips-Maczugi: ");
        String scanned = scanner.next();
        if (!candyDB.checkIfExsistInCollection(scanned)) {
            scanned = inputProductName();
        }
        return scanned.toLowerCase();
    }
    @Override
    public int inputProductQuantityToBuy(){
        System.out.println("Please enter quantity you want to buy: ");
        int scanned;
        try{
        scanned = scanner.nextInt();

        } catch (InputMismatchException e){
            scanner.nextLine();
            System.out.println("Enter number");
            scanned = inputProductQuantityToBuy();
        }
        if (scanned <=0){
            scanner.nextLine();
            System.out.println("Enter number greater than 0");
            scanned = inputProductQuantityToBuy();
        }
        return scanned;

    }
    @Override
    public void restockItems(String product, int quantity){
        candyDB.restockProduct(product,quantity);
        System.out.println("You succesfully restock " + quantity + " of " + product);
    }
    @Override
    public int inputProductQuantityToRestock(){
        System.out.println("Please enter quantity you want to restock: ");
        int scanned;
        try{
            scanned = scanner.nextInt();
        } catch (InputMismatchException e){
            scanner.nextLine();
            System.out.println("Enter number");
            scanned = inputProductQuantityToRestock();
        }
        if (scanned <=0){
            scanner.nextLine();
            System.out.println("Enter number greater than 0");
            scanned = inputProductQuantityToRestock();
        }
        return scanned;
    }
    @Override
    public void changeUserAccess(String user){
        userDB.changeUserAccess(user);
    }
    @Override
    public String inputUserName(){
        scanner.nextLine();
        System.out.println("Please input username:");
        String scanned = scanner.nextLine();
        if (!userDB.checkIfUserExist(scanned)){
            System.out.println("username doesn't exist, try again");
            scanned = inputUserName();
        }
        return scanned.toLowerCase();
    }
}
