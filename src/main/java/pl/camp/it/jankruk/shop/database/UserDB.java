package pl.camp.it.jankruk.shop.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.camp.it.jankruk.shop.authentication.IAuthentication;
import pl.camp.it.jankruk.shop.model.user.User;

import java.util.HashMap;


@Component
public class UserDB implements IUserDB{
    @Autowired
    IAuthentication authentication;
    private final HashMap<String, User> users = new HashMap<>();
    @Override
    public boolean checkIfUserExist(String user){
        return users.containsKey(user.toLowerCase());
    }
    @Override
    public void changeUserAccess(String user){
        users.get(user).changeAccess();
    }
    @Override
    public User login(String username, String password){
        if (users.get(username).checkIfPasswordCorrect(authentication.hexPassword(password))){
            return users.get(username);
        }else{
            return null;
        }
    }
    @Override
    public void createNewAccount(String username, String password){
        users.put(username.toLowerCase(),new User(username,authentication.hexPassword(password)));
    }
    @Override
    public void showUserList(){
        users.values().forEach(System.out::println);
    }

    @Override
    public HashMap<String, User> getUsers() {
        return users;
    }
}
