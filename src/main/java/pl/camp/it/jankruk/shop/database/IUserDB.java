package pl.camp.it.jankruk.shop.database;

import pl.camp.it.jankruk.shop.model.user.User;

import java.util.HashMap;

public interface IUserDB {
   boolean checkIfUserExist(String user);
   void changeUserAccess(String user);
   User login(String username, String password);
   void createNewAccount(String username, String password);
   void showUserList();
   HashMap<String, User> getUsers();
}
