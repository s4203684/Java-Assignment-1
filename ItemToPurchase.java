// Represents a single item that can be purchased
public class ItemToPurchase {
    // Private fields for item details
    private double itemPrice;
    private String itemName;
    private double itemQuantity;
    private static int objectCount = 0;
    
    // Default constructor (initializes to safe default values)
    public ItemToPurchase(){
        itemName = "none";
        itemPrice = 0;
        itemQuantity = 0;
        objectCount++;
    }
     
    // Parameterized constructor (only assigns values if all inputs are valid)
    public ItemToPurchase(String name, double price, double quantity) throws InvalidVariableException{ 
        // check for valid inputs
        if (name == null) throw new InvalidVariableException("Name cannot be null");
        if (price < 0) throw new InvalidVariableException("Price cannot be negative");
        if (quantity <= 0) throw new InvalidVariableException("Quantity must be greater than zero");
        this.itemName = name;
        this.itemPrice = price;
        this.itemQuantity = quantity;
        objectCount++;
    }

    // Getter for item name
    public String getName(){
        return itemName;
    }

    // Getter for item price
    public double getPrice(){
        return itemPrice;
    }

    // Getter for item quantity
    public double getQuantity(){
        return itemQuantity;
    }

    // Setter for item name (only valid if not null)
    public void setName(String name) throws InvalidVariableException {
        if (name == null) throw new InvalidVariableException("Name cannot be null");
            this.itemName = name;
    }


    // Setter for item price (must be >= 0)
    public void setPrice(double price) throws InvalidVariableException {
        if (price < 0) throw new InvalidVariableException("Price cannot be negative");
        this.itemPrice = price;
    }

    

    // Setter for item quantity (must be >= 1)
    public void setQuantity(double quantity) throws InvalidVariableException {
        if (quantity <= 0) throw new InvalidVariableException("Quantity must be greater than zero");
        this.itemQuantity = quantity;
    }

    // Calculates total price for this item
    public double getTotalPrice(){
        return itemPrice*itemQuantity;
  
    }

    // Returns formatted string for item details
    public String toString(){
        return itemName + " " +itemQuantity + " @ $" + itemPrice + " = $" + getTotalPrice();
    }

    public static int getObjectCount(){
        return objectCount;
    }
}

