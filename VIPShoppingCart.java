import java.util.Scanner;

public class VIPShoppingCart extends ShoppingCart {
    // Points balance for the VIP customer
    private int availablePoints;

    // Constant rules for discounts and points
    private static final int DISCOUNT_THRESHOLD = 100;
    private static final double DISCOUNT_RATE = 0.95;
    private static final int POINTS_PER_DOLLAR = 50;

    // Constructor to create a VIP cart with an initial points balance
    public VIPShoppingCart(String name, String date, int points) {
        super(name, date); // Inherit name and date from ShoppingCart
        this.availablePoints = points;
    }

    // Accessors for loyalty points
    public int getAvailablePoints() {
        return availablePoints;
    }

    public void setAvailablePoints(int points) {
        this.availablePoints = points;
    }

    // Overrides printTotal to display VIP-specific header and item details

    @Override
    public void printTotal() {
        System.out.println(getCustomerName() + " - " + getDate());

        if (itemCount == 0) {
            System.out.println("SHOPPING CART IS EMPTY");
            return;
        }

        System.out.println("Number of items: " + getNumItemsInCart());
        for (int i = 0; i < itemCount; i++) {
            System.out.println(cartItems[i]);
        }
        System.out.println("Total: $" + getCostOfCart());

    }

    // Overrides checkout to apply discounts and handle point redemption
    @Override
    public void checkout() {
        if (itemCount == 0) {
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

        // Apply 5% discount if the total meets the $100 threshold
        if (originalCost >= DISCOUNT_THRESHOLD) {
            totalAfterDiscount = Math.round(originalCost * DISCOUNT_RATE);
            System.out.println("Total: $" + (int) totalAfterDiscount + " (after 5% discount)");
        } else {
            totalAfterDiscount = originalCost;
            System.out.println("No discount for a total less than 100.");
        }

        // Point Redemption Logic
        System.out.println("Redeem points? (Y/N)");
        String redeemChoice = scan.nextLine();

        if (redeemChoice.equals("Y")) {
            System.out.println("Enter points to be redeemed, -1 to quit:");

            while (true) {
                int pointsEntered = scan.nextInt();
                scan.nextLine();

                if (pointsEntered == -1) {
                    break;
                } else if (pointsEntered < POINTS_PER_DOLLAR) {
                    System.out.println("Less than 50! Please retry. Enter -1 to quit:");
                } else if (pointsEntered > availablePoints) {
                    System.out.println("Not enough points. Please retry. Enter -1 to quit:");
                } else {
                    // "Snap" points to the nearest 50 to ensure whole dollar discounts
                    int snapped = (pointsEntered / POINTS_PER_DOLLAR) * POINTS_PER_DOLLAR;
                    System.out.println("Redeeming " + snapped + " points.");
                    availablePoints = availablePoints - snapped;
                    totalAfterDiscount = totalAfterDiscount - (snapped / POINTS_PER_DOLLAR);
                    break;
                }
            }
        }

        // Finalize Payment and award new points
        System.out.println("Total to pay: $" + (int) totalAfterDiscount);

        // Award 1 point for every $1 spent on the final total
        int pointsEarned = (int) totalAfterDiscount;
        availablePoints = availablePoints + pointsEarned;
        System.out.println("Thank you for shopping with us. " + pointsEarned + " points added!");

        // Clear cart items and reset counter
        for (int i = 0; i < itemCount; i++) {
            cartItems[i] = null;
        }
        this.itemCount = 0;

    }

}
