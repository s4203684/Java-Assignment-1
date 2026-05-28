public class GiftCard extends ItemToPurchase {
    private static final int POINTS_PER_DOLLAR = 50;

    public GiftCard(double price) throws InvalidVariableException {
        super("gift card", Math.floor(price), 1);
    }

    public int getPoints() {
        int point = (int) (getPrice() * POINTS_PER_DOLLAR);
        return point;
    }

    @Override
    public String toString() {
        return "A " + getName() + " @ $" + (int) getPrice() + " = $" + (int) getPrice() + " or " + getPoints()
                + " points";
    }
}
