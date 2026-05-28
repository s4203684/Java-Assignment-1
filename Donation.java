public class Donation extends ItemToPurchase {
    private static final int PRICE_PER_UNIT = 10;

    public Donation(double quantity) throws InvalidVariableException {
        super("Donation", PRICE_PER_UNIT, quantity);
    }

    @Override
    public String toString() {
        return "Donation " + (int) getQuantity() + " @ $10 = $" + (int) getTotalPrice();
    }
}
