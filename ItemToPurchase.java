public class ItemToPurchase {
    private int itemPrice;
    private String itemName;
    private int itemQuantity;
    
    public ItemToPurchase(){
        itemName = "none";
        itemPrice = 0;
        itemQuantity = 0;
    }

    public ItemToPurchase(String name, int price, int quantity){
        this.itemName = "none";
        this.itemPrice = 0;
        this.itemQuantity = 0;
        
        if (name != null && price >= 0 && quantity >= 1){
            this.itemName = name;
            this.itemPrice = price;
            this.itemQuantity = quantity;
        }
    }
    public String getName(){
        return itemName;
    }
    public void setName(String name) {
    if (name != null) {
        this.itemName = name;
    }
    }

     public int getPrice(){
        return itemPrice;
    }
    public void setPrice(int price) {
    if (price >= 0) {
        this.itemPrice = price;
    }
    }

     public int getQuantity(){
        return itemQuantity;
    }
    public void setQuantity(int quantity) {
    if (quantity >= 1) {
        this.itemQuantity = quantity;
    }
    }

    public int getTotalPrice(){
        return itemPrice*itemQuantity;
  
    }

    public String toString(){
        return itemName + " " +itemQuantity + " @ $" + itemPrice + " = $" + getTotalPrice();
    }

}

