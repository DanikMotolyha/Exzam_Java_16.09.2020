import java.sql.*;
import java.util.ArrayList;

public class Product{
    public Product(){}
    private String  name;
    private int     price;
    public Product(String name, int price){
        this.name = name;
        this.price = price;
    }
    @Override
    public String toString() {
        return this.getName() + " " + this.getPrice();
    }
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
