public class Donation extends ItemToPurchase{
    public Donation(double quantity) throws InvalidVariableException {
    super("Donation", 10, quantity);
    }


    @Override
    public String toString(){
        return "Donation " + (int)getQuantity() + " @ $10 = $" + (int)getTotalPrice();
    }
}

