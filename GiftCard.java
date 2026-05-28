public class GiftCard extends ItemToPurchase {
    // Number of reward points earned per dollar
    private static final int POINTS_PER_DOLLAR = 50;

    // Constructor for GiftCard class
    public GiftCard(double price) throws InvalidVariableException {
        // Calls parent constructor with:
        // item name = "gift card"
        // price rounded down using Math.floor()
        // quantity fixed at 1
        super("gift card", Math.floor(price), 1);
    }

    // Method to calculate reward points
    public int getPoints() {
        // Points are calculated based on price × points per dollar
        int point = (int) (getPrice() * POINTS_PER_DOLLAR);
        // Returns total points
        return point;
    }

    // Overrides the toString() method from parent class
    @Override
    public String toString() {
        // Returns formatted gift card details
        // Example:
        // A gift card @ $20 = $20 or 1000 points
        return "A " + getName() + " @ $" + (int) getPrice() + " = $" + (int) getPrice() + " or " + getPoints()
                + " points";
    }
}
