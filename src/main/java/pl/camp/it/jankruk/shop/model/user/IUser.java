package pl.camp.it.jankruk.shop.model.user;

public interface IUser {
    String getUsername();

    String getPassword();

   String getRole();
    boolean checkIfPasswordCorrect(String password);

   void setRole(String role);
    void changeAccess();

    String toString();
}
