package main;
import java.util.*;
import models.Product;
import models.Purchase;
import exceptions.MissingCustomerAddress;
import services.ProductService;

public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        ProductService productservice = new ProductService();
        List<Product> prodlist=new ArrayList<>();
        List<Purchase> userlist = new ArrayList<>();

        prodlist.add(new Product("Laptop",80000,10));
        prodlist.add(new Product("Waterbottle",30000,5));
        prodlist.add(new Product("shoes",2000,0));
        prodlist.add(new Product("Smartwatch",15000,3));
        prodlist.add(new Product("Umbrella",25000,8));

        boolean exit=true;
        List<Product> purchaselist = new ArrayList<>();
        while(exit){
        System.out.println("Choose your Option:\n1.Enter User Details\n2.Veiw Available Products\n3.Add Product to Cart\n4.View Cart\n5.Checkout\n6.Exit\n");
        int choice=s.nextInt();

        switch (choice) {
            case 2:
            System.out.println("Available Products:");
            for(Product prod:prodlist){
                System.out.println("Product ID: " + prod.getProductid());
                System.out.println("Product Name: " + prod.getProductname());
                System.out.println("Price: " + prod.getPrice());
                System.out.println("Stock: " + prod.getStock());
                System.out.println();
            }
            System.out.println("--------------------");
            System.out.println();
            break;

            case 3:

            System.out.println("Enter Product ID to add to cart:");
            int productId = s.nextInt();    
            Product selectedProduct = null;
            for (Product prod : prodlist) { 
                if (prod.getProductid() == productId) {
                    selectedProduct = prod;
                    break;
                }
            }
            if (selectedProduct != null) {
                System.out.println("Product " + selectedProduct.getProductname() + " added to cart.");
                purchaselist.add(selectedProduct);
            } else {
                System.out.println("Product not found.");
            }
            System.out.println("--------------------");
            System.out.println();
            break;

            case 4:
            System.out.println("Your Cart:");
            if (purchaselist.isEmpty()) {   
                System.out.println("Your cart is empty.");
            } else {
                for (Product purchase : purchaselist) {
                    purchase.displayproduct();
                }
                System.out.println("--------------------");
            }
            System.out.println();
                break;
            
                case 5:
                System.out.println("Checkout:");
                if (purchaselist.isEmpty()) {   
                    System.out.println("Your cart is empty. Cannot proceed to checkout.");
                } else {
                    for (Product purchase : purchaselist) {
                        try {
                            productservice.checkdetails(purchase);
                            purchase.stockupdate();
                            purchase.displaydetails();
                        } catch (MissingCustomerAddress e) {
                            System.out.println(e.getMessage());
                        }
                        totalcost(purchaselist);
                    }
                }
                System.out.println();
                break;

                case 6:
                System.out.println("Exiting the application.");
                exit = false;
                System.out.println("Thank you for using our service!");
                return;

                case 1:
                System.out.println("Enter your name:");
                String custname = s.next(); 
                System.out.println("Enter your email:");
                String custemail = s.next();
                System.out.println("Enter your address:");
                String address = s.next();
                userlist.add(new Purchase(custname, custemail, address));
                System.out.println("Name: "+custname+" Email: "+custemail+" Address: "+address+" User details added successfully.");
                break;
                
                default:
                System.out.println("Invalid choice. Please try again.");    
                break;

        }    
    } 
        s.close();  
    }
    public static void totalcost(List<Product> products) {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        System.out.println("Total cost of products: " + total);
    }
}
