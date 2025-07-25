package models;

public class Product extends Stocks {
    public static int counter =100;
    private int productid;
    private String productname;
    private double price;
    private int stock;
    public Product(String productname, double price, int stock) {
        this.productid = counter++;
        this.productname = productname;
        this.price = price;
        this.stock = stock;
    }
    public int getProductid() {
        return productid;
    }
    public String getProductname() {
        return productname;
    }
    public double getPrice() {
        return price;
    }
    public int getStock() {
        return stock;
    }

    public void displayproduct() {
        System.out.println("Product ID: " + getProductid());
        System.out.println("Product Name: " + getProductname());
        System.out.println("Price: " + getPrice());
        System.out.println("Stock: " + getStock());
    }
    @Override
    public void stockupdate() {
        System.out.println("Stock updated for product: " + getProductname());
        this.stock -= 1; 
    }
    @Override
    public void displaydetails() {
        System.out.println("Product ID: " + getProductid());
        System.out.println("Product Name: " + getProductname());
        System.out.println("Price: " + getPrice());
        System.out.println("Stock: " + getStock());
    }
}
