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

    // access to private fields
    public String getName(){
        return itemName;
    }

    // setters
    public void setName(String name) {
    if (name != null) {
        this.itemName = name;
    }
    }
    
    // getters
    public int getPrice(){
        return itemPrice;
    }

    // setters
    public void setPrice(int price) {
    if (price >= 0) {
        this.itemPrice = price;
    }
    }

    // getters
    public int getQuantity(){
        return itemQuantity;
    }

    // setters
    public void setQuantity(int quantity) {
    if (quantity >= 1) {
        this.itemQuantity = quantity;
    }
    }

    // calculating total price
    public int getTotalPrice(){
        return itemPrice*itemQuantity;
  
    }

    // Totall output as String
    public String toString(){
        return itemName + " " +itemQuantity + " @ $" + itemPrice + " = $" + getTotalPrice();
    }

}

