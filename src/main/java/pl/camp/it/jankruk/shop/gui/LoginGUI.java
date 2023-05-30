package pl.camp.it.jankruk.shop.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.camp.it.jankruk.shop.database.IUserDB;
import pl.camp.it.jankruk.shop.model.user.User;

import java.util.Scanner;
@Component
public class LoginGUI implements ILoginGUI {
    private static final Scanner scanner = new Scanner(System.in);
    @Autowired
    private IUserDB userDB;
@Override
    public String showMenu(){
        System.out.println("1.Login");
        System.out.println("2.Register");
        System.out.println("3.Exit");
        return scanner.next();
    }
    @Override
    public User login(String username, String password){
        if (userDB.checkIfUserExist(username)){
            return userDB.login(username,password);
        }else{
            return null;
        }
    }
    public void register(){
        String username = inputUsername();
        while (userDB.checkIfUserExist(username)) {
            System.out.println("username taken, choose other");
            username =inputUsername();
        }
        userDB.createNewAccount(username,inputPassword());
    }
    @Override
    public String inputUsername(){
        System.out.println("Please enter username: ");
        return scanner.next();
    }
    @Override
    public String inputPassword(){
        System.out.println("Please enter password: ");
        return scanner.next();
    }
    public void showUserList(){
        userDB.showUserList();
    }
}
