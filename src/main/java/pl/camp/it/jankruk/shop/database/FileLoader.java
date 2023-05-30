package pl.camp.it.jankruk.shop.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.camp.it.jankruk.shop.model.Writeable;
import pl.camp.it.jankruk.shop.model.products.Product;
import pl.camp.it.jankruk.shop.model.user.User;

import java.io.*;
import java.util.ArrayList;
@Component
public class FileLoader implements IFileLoader{
    @Autowired
    private IUserDB userDB;
    @Autowired
    private ICandyDB candyDB;
    private final ArrayList<Writeable> data = new ArrayList<>();

    public void readDataFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
        String line;
        while((line =reader.readLine()) != null){
            String[] arr = line.split(";");
            if (arr[0].equalsIgnoreCase("product")){
                this.candyDB.getProducts().put(arr[1].toLowerCase(),new Product(arr[1],Integer.parseInt(arr[2]),Integer.parseInt(arr[3])));
            }else if (arr[0].equalsIgnoreCase("user")){
                userDB.getUsers().put(arr[1].toLowerCase(),new User(arr[1],arr[2],arr[3]));
            }
        }
        reader.close();
    }

    public void saveDataToFile() throws IOException {
        data.addAll(candyDB.getProducts().values());
        data.addAll(userDB.getUsers().values());
        BufferedWriter writer = new BufferedWriter(new FileWriter("test.txt"));
        for (Writeable element : data) {
            writer.write(element.saveToFile());
            writer.newLine();
        }
        writer.close();
    }
}
