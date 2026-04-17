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

     public String getDate(){
        return currentDate;
    }
    
    public void setDate(String date){
        this.currentDate = date;  
    }

    public int getNumItemsInCart() {
        int totalItems = 0;
        for (int i = 0; i < itemCount; i++) {
            totalItems += cartItems[i].getQuantity();
        }
        return totalItems;
    }
    
    public int getCostOfCart() {
        int totalCost = 0;
        for (int i = 0; i < itemCount; i++) {
            totalCost += cartItems[i].getTotalPrice();
        }
        return totalCost;
    }
    
    public boolean addItem(ItemToPurchase item){
        if(itemCount == CAPACITY){
            System.out.println("SHOPPING CART IS FULL");
            return false;
        }
      
        for(int i = 0; i < itemCount; i++){
            if(cartItems[i].getName().equals(item.getName())){
                System.out.println("ITEM ALREADY EXISTS");
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
            int totalItem = getNumItemsInCart();
            int totalCost = getCostOfCart();

            System.out.println("Number of items: " + totalItem);
            for(int i = 0; i<itemCount; i++){
                System.out.println(cartItems[i]);
            }
            System.out.println("Total: $" + totalCost);
        }
    }

    public void modifyItem(String itemName, int newQuantity){
        for(int i = 0; i < itemCount; i++){
            if (cartItems[i].getName().equals(itemName)){
                cartItems[i].setQuantity(newQuantity);
                return;
            }
        }
        System.out.println("[" + itemName + "] not found in cart");
    }

    public void checkout(){
    
        if(itemCount == 0){
            System.out.println("SHOPPING CART IS EMPTY");
        }
        else{
            printTotal();
            System.out.println("Thank you for shopping.");
            this.itemCount = 0;
        }
    }
}
