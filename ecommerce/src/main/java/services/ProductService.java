package services;
import models.*;
import exceptions.*;
public class ProductService {
    public void checkdetails(Product product) throws MissingCustomerAddress {
        if (product.getStock() == 0 ) {
            throw new MissingCustomerAddress( "Product " + product.getProductname() + " is out of stock.");
        }
        System.out.println("Product available: " + product.getProductname());
    }
}
