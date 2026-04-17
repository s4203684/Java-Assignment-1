// Represents a single item that can be purchased
public class ItemToPurchase {
    // Private fields for item details
    private int itemPrice;
    private String itemName;
    private int itemQuantity;
    
    // Default constructor (initializes to safe default values)
    public ItemToPurchase(){
        itemName = "none";
        itemPrice = 0;
        itemQuantity = 0;
    }
     
    // Parameterized constructor (only assigns values if all inputs are valid)
    public ItemToPurchase(String name, int price, int quantity){
        this.itemName = "none";
        this.itemPrice = 0;
        this.itemQuantity = 0;
         
        // check for valid inputs
        if (name != null && price >= 0 && quantity >= 1){
            this.itemName = name;
            this.itemPrice = price;
            this.itemQuantity = quantity;
        }
    }

    // Getter for item name
    public String getName(){
        return itemName;
    }

    // Getter for item price
    public int getPrice(){
        return itemPrice;
    }

    // Getter for item quantity
    public int getQuantity(){
        return itemQuantity;
    }

    // Setter for item name (only valid if not null)
    public void setName(String name) {
        if (name != null) {
            this.itemName = name;
        }
    }


    // Setter for item price (must be >= 0)
    public void setPrice(int price) {
    if (price >= 0) {
        this.itemPrice = price;
    }
    }

    

    // Setter for item quantity (must be >= 1)
    public void setQuantity(int quantity) {
    if (quantity >= 1) {
        this.itemQuantity = quantity;
    }
    }

    // Calculates total price for this item
    public int getTotalPrice(){
        return itemPrice*itemQuantity;
  
    }

    // Returns formatted string for item details
    public String toString(){
        return itemName + " " +itemQuantity + " @ $" + itemPrice + " = $" + getTotalPrice();
    }

}

