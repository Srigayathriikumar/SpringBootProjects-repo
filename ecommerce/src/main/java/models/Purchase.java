package models;
import interfaces.ReportIssue;
public class Purchase extends Product implements ReportIssue{
    public static int purchasecounter=200;
    private int purchaseid;
    private String custname;
    private String custemail;
    private int quantity;
    private String address;
   
    public Purchase(String custname, String custemail, String address) {
        super("", 0.0, 0); 
        this.custname = custname;
        this.custemail = custemail;
        this.address = address;
    }
    public Purchase(String productname, double price, int stock, String custname, String custemail, int quantity, String address) {
        super(productname, price, stock);
        this.purchaseid = purchasecounter++;
        this.custname = custname;
        this.custemail = custemail;
        this.quantity = quantity;
        this.address = address;
    }
    
    public int getPurchaseid() {
        return purchaseid;
    }
    public String getCustname() {
        return custname;
    }
    public String getCustemail() {
        return custemail;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getAddress() {
        return address;
    }
    public void getProduct() {
        System.out.println("Product Name: " + getProductname());
        System.out.println("Price: " + getPrice());
    }
    @Override
    public void stockupdate(){
        int newStock = getStock() - quantity;
        System.out.println("Purchase updated successfully.The new stock is: " + newStock);
    }
    @Override
    public void reportIssue(String message) {
        System.out.println("Reporting issue for purchase ID " + getPurchaseid() + ": " + message);
    }
    @Override
    public void displaydetails() {
        System.out.println("Purchase ID: " + purchaseid);
        System.out.println("Customer Name: " + custname);
        System.out.println("Customer Email: " + custemail);
        System.out.println("Quantity: " + quantity);
        System.out.println("Address: " + address);
        System.out.println("Product Details:");
        getProduct();
    }

    public int getPurchasecounter() {
        return purchasecounter;
    }
}
