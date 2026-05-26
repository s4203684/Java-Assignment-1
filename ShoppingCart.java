// Represents a shopping cart containing multiple items
import java.util.Scanner;
public class ShoppingCart {
   // Maximum number of items allowed in the cart
    private static final int CAPACITY = 10;
    private static int taxRate = 5;
    
     // Customer details
    protected String customerName;
    protected String currentDate;

    // Array to store items
    protected ItemToPurchase[] cartItems;
    protected int itemCount;
    
    protected Scanner scan = new Scanner (System.in);

    // Default constructor
    public ShoppingCart(){
        this.customerName = "Unknown";
        this.currentDate = "15 April 2026";
        this.cartItems = new ItemToPurchase [CAPACITY];
        this.itemCount = 0;
    }

    // Constructor with parameters
     public ShoppingCart(String name, String date){
        this.customerName = name;
        this.currentDate = date;
        this.cartItems = new ItemToPurchase [CAPACITY];
        this.itemCount = 0;
    }
    
     // Getter for customer name
    public String getCustomerName(){
        return customerName;
    }
    
    // Setter for customer name
    public void setCustomerName(String name){
    
        this.customerName = name;
    }

    // Getter for date
    public String getDate(){
        return currentDate;
    }
    
    // Setter for date
    public void setDate(String date){
        this.currentDate = date;  
    }

    // Returns total quantity of all items in cart
    public int getNumItemsInCart() {
        return itemCount;
    }



    public static int getTaxRate(){
        return taxRate;
    }

    public static void setTaxRate( int rate){
        taxRate = rate;
    }


    public double getTax(){
        return getCostOfCart() * taxRate / 100.0;
    }
    
    // Returns total cost of all items in cart
    public double getCostOfCart() {
        double totalCost = 0;
        for (int i = 0; i < itemCount; i++) {
            totalCost += cartItems[i].getTotalPrice();
        }
        return totalCost;
    }
    
    // Adds an item to the cart if there is space
    public boolean addItem(ItemToPurchase item){
        // Cheching if the cart has space
        if(itemCount == CAPACITY){
            System.out.println("SHOPPING CART IS FULL");
            return false;
        }

        if(containsItem(item.getName())){
            System.out.println("ITEM ALREADY EXIST.");
            return false;
        }

        // Updating the cart
        cartItems[itemCount] = item;
        itemCount++;
        return true;
    }

    // Checking if the item already exist
    public boolean containsItem(String itemName){
        for (int i = 0; i < itemCount; i++){
            if(cartItems[i].getName().equalsIgnoreCase(itemName)){
                return true;
            }
        }
        return false;
    }

    // Displays cart contents and total cost
    public void printTotal(){
        System.out.println(customerName + " - " + currentDate);
 
        if(itemCount == 0){
            System.out.println("SHOPPING CART IS EMPTY");
        }
        // getting information of cart
        else{
            int totalItem = getNumItemsInCart();
            double totalCost = getCostOfCart();

            System.out.println("Number of items: " + totalItem);
            for(int i = 0; i<itemCount; i++){
                System.out.println(cartItems[i]);
            }
            System.out.println("Total: $" + totalCost);
        }
    }

    // Modifies quantity of an existing item
    public void modifyItem(String itemName){
        boolean found = false;
        for(int i = 0; i < itemCount; i++){
            if (cartItems[i].getName().equals(itemName)){
                found = true;
                System.out.println("Please enter the new quantity:");
                double newQuantity = scan.nextDouble();
                scan.nextLine();
                cartItems[i].setQuantity(newQuantity);
                break;
            }
        }
        
        if (!found){
            System.out.println("[" + itemName + "] not found in cart.");
        }
       
    }
    
    // Prints summary and clears the cart
    public void checkout(){
    
        if(itemCount == 0){
            System.out.println("SHOPPING CART IS EMPTY");
        }
        else{
            printTotal();
            System.out.println("Thank you for shopping.");
            for(int i = 0; i < itemCount; i++){
                cartItems[i] = null;
            }
        
            this.itemCount = 0;
        }
    }
}
