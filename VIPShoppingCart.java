import java.util.Scanner;

public class VIPShoppingCart extends ShoppingCart{
    private int availablePoints;


    public VIPShoppingCart(String name, String date, int points){
        super(name, date);
        this.availablePoints = points;
    }



    public int getAvailablePoints(){
        return availablePoints;
    }


    public void setAvailablePoints(int points){
        this.availablePoints = points;
    }


    @Override
    public void printTotal(){
        System.out.println(getCustomerName() + " - " + getDate());
        
        if (itemCount == 0) {
            System.out.println("SHOPPING CART IS EMPTY");
            return;
        }
        
        
        System.out.println("Number of items: " + getNumItemsInCart());
        for(int i= 0; i < itemCount; i++){
            System.out.println(cartItems[i]);
        }
        System.out.println("Total: $" + getCostOfCart());

    }
    @Override
    public void checkout(){
        if (itemCount == 0){
            System.out.println("SHOPPING CART IS EMPTY");
            return;
        }
        System.out.println(getCustomerName() + " - " + getDate());
        System.out.println("Number of items: " + getNumItemsInCart());
        for (int i = 0; i < itemCount; i++) {
            System.out.println(cartItems[i]);
        }

        double originalCost = getCostOfCart();
        double totalAfterDiscount;

        if(originalCost >= 100){
            totalAfterDiscount = Math.round(originalCost * 0.95);
            System.out.println("Total: $" + (int)totalAfterDiscount + " (after 5% discount)");
        }
        else{
            totalAfterDiscount = originalCost;
            System.out.println("No discount for a total less than 100.");
        }



        System.out.println("Redeem points? (Y/N)");
        String redeemChoice = scan.nextLine();

        if (redeemChoice.equals("Y")){
            System.out.println("Enter points to be redeemed, -1 to quit:");


            while (true) {
                int pointsEntered = scan.nextInt();
                scan.nextLine();

                if(pointsEntered == -1){
                    break;
                }
                else if(pointsEntered < 50){
                    System.out.println("Less than 50! Please retry. Enter -1 to quit:");
                }
                else if(pointsEntered > availablePoints){
                    System.out.println("Not enough points. Please retry. Enter -1 to quit:");
                }
                else{
                    int snapped = (pointsEntered / 50) * 50;
                    System.out.println("Redeeming " + snapped + " points.");
                    availablePoints = availablePoints - snapped;
                    totalAfterDiscount = totalAfterDiscount - (snapped / 50);
                    break;
                }
            }
        }

        System.out.println("Total to pay: $" + (int)totalAfterDiscount);
        int pointsEarned = (int)totalAfterDiscount;
        availablePoints = availablePoints + pointsEarned;
        System.out.println("Thank you for shopping with us. " + pointsEarned + " points added!");


        for(int i = 0; i < itemCount; i++){
            cartItems[i] = null;
        }
        this.itemCount = 0;

    }




    
}
