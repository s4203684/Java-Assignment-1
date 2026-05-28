public class Donation extends ItemToPurchase {
    // Constant value for each donation unit price
    private static final int PRICE_PER_UNIT = 10;

    // Constructor for Donation class
    public Donation(double quantity) throws InvalidVariableException {
        // Calls the parent constructor with:
        // item name = "Donation"
        // price per unit = 10
        // quantity entered by user
        super("Donation", PRICE_PER_UNIT, quantity);
    }

    // Overrides the toString() method from parent class
    @Override
    public String toString() {
        // Returns formatted donation details
        return "Donation " + (int) getQuantity() + " @ $10 = $" + (int) getTotalPrice();
    }
}
