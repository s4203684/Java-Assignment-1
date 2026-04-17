public class ShoppingCart {
    // private field and arry
    private static final int CAPACITY = 10;
    private String customerName;
    private String currentDate;
    private ItemToPurchase[] cartItems;
    private int itemCount;
    
    // constract without perameters
    public ShoppingCart(){
        this.customerName = "Unknown";
        this.currentDate = "15 April 2026";
        this.cartItems = new ItemToPurchase [CAPACITY];
        this.itemCount = 0;
    }

    // constract with perameters
     public ShoppingCart(String name, String date){
        this.customerName = name;
        this.currentDate = date;
        this.cartItems = new ItemToPurchase [CAPACITY];
        this.itemCount = 0;
    }
    
    // getters
    public String getCustomerName(){
        return customerName;
    }
    
    // setters
    public void setCustomerName(String name){
    
        this.customerName = name;
    }

    // getters
    public String getDate(){
        return currentDate;
    }
    
    // setters
    public void setDate(String date){
        this.currentDate = date;  
    }

    // Getting totall number of item in cart
    public int getNumItemsInCart() {
        int totalItems = 0;
        for (int i = 0; i < itemCount; i++) {
            totalItems += cartItems[i].getQuantity();
        }
        return totalItems;
    }
    
    // Getteing totall price of thr items in cart
    public int getCostOfCart() {
        int totalCost = 0;
        for (int i = 0; i < itemCount; i++) {
            totalCost += cartItems[i].getTotalPrice();
        }
        return totalCost;
    }
    
    // Adding items to cart
    public boolean addItem(ItemToPurchase item){
        // Cheching if the cart has space
        if(itemCount == CAPACITY){
            System.out.println("SHOPPING CART IS FULL");
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
            if(cartItems[i].getName().equals(itemName)){
                return true;
            }
        }
        return false;
    }

    // Printing Customer name and Date
    public void printTotal(){
        System.out.println(customerName + " - " + currentDate);
 
        if(itemCount == 0){
            System.out.println("SHOPPING CART IS EMPTY");
        }
        // getting information of cart
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

    public void modifyItem(String itemName){
        for(int i = 0; i < itemCount; i++){
            if (cartItems[i].getName().equals(itemName)){
                System.out.println("Please enter the new quantity:");
                int newQuantity = ShoppingCartManager.scan.nextInt();
                ShoppingCartManager.scan.nextLine();
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
            for(int i = 0; i < itemCount; i++){
                cartItems[i] = null;
            }
        
            this.itemCount = 0;
        }
    }
}
