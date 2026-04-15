import java.util.Scanner;

public class ShoppingCart {
    private static final int CAPACITY = 10;
    private String customerName;
    private String currentDate;
    private ItemToPurchase[] cartItems;
    private int itemCount;
    
    public ShoppingCart(){
        this.customerName = "Unknown";
        this.currentDate = "15 April 2026";
        this.cartItems = new ItemToPurchase [CAPACITY];
        this.itemCount = 0;
    }

     public ShoppingCart(String name, String date){
        this.customerName = name;
        this.currentDate = date;
        this.cartItems = new ItemToPurchase [CAPACITY];
        this.itemCount = 0;
    }

    public String getCustomerName(){
        return customerName;
    }
    
    public void setCustomerName(String name){
    
        this.customerName = name;
    }

     public String getCurrentDate(){
        return currentDate;
    }
    
    public void setDate(String date){
        this.currentDate = date;  
    }

    public boolean addItem(ItemToPurchase item){
        if(itemCount == CAPACITY){
            System.out.print("SHOPPING CART IS FULL");
            return false;
        }
      
        for(int i = 0; i < itemCount; i++){
            if(cartItems[i].getName().equals(item.getName())){
                System.out.print("ITEM ALREADY EXIST");
                return false;
            }
        }
        cartItems[itemCount] = item;
        itemCount++;
        return true;
    }

    public void printTotal(){
        System.out.println(customerName + " - " + currentDate);

        if(itemCount == 0){
            System.out.println("SHOPPING CART IS EMPTY");
        }
        else{
            int totalItem = 0;
            int totalCost = 0;
            for(int i =0; i <itemCount; i++){
                totalItem += cartItems[i].getQuantity();
                totalCost += cartItems[i].getTotalPrice();
            }
            System.out.println("Number of Items: " + totalItem);
            for(int i = 0; i<itemCount; i++){
                System.out.println(cartItems[i]);
            }
            
            System.out.println("Total: $" + totalCost);
             

        }
    }
}