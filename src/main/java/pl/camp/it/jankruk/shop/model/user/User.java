package pl.camp.it.jankruk.shop.model.user;

import org.springframework.beans.factory.annotation.Autowired;
import pl.camp.it.jankruk.shop.authentication.Authentication;
import pl.camp.it.jankruk.shop.authentication.IAuthentication;
import pl.camp.it.jankruk.shop.model.Writeable;

public class User implements Writeable, IUser {
    private String username;
    private String password;
    private String role;
    private static String adminRole = "admin";
    private static String userRole = "user";


    public User(String userName, String password, String role) {
        this.username = userName;
        this.password = password;
        this.role = role;
    }
    public User(String userName, String password) {
        this.username = userName;
        this.password = password;
        this.role = userRole;
    }
    @Override
    public void changeAccess(){
        if (this.role.equals(adminRole)){
            this.role = userRole;
            System.out.println("successful change to " + userRole);
        }else{
            this.role = adminRole;
            System.out.println("successful change to " + adminRole);
        }
    }
    @Override
    public boolean checkIfPasswordCorrect(String password){
        return this.password.equals(password);
    }
    public boolean checkAdmin(){
        return this.role.equals(adminRole);
    }

    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getRole() {
        return role;
    }
    @Override
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "username= " + username  +", role:" + role;
    }
    @Override
    public String saveToFile(){
        return "User" +";"+username+";"+password+";"+role;
    }

}
