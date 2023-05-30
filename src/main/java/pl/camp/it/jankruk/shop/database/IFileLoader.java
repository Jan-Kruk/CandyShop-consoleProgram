package pl.camp.it.jankruk.shop.database;

import pl.camp.it.jankruk.shop.model.Writeable;
import pl.camp.it.jankruk.shop.model.products.Product;
import pl.camp.it.jankruk.shop.model.user.User;

import java.io.*;

public interface IFileLoader {
    void readDataFromFile() throws IOException;


    void saveDataToFile() throws IOException;
}
