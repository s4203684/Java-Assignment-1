public class SeniorShoppingCart extends ShoppingCart {

    private String seniorID;

    public SeniorShoppingCart(String name, String date, String id) throws InvalidVariableException {
        super(name, date);
        if (id == null) {
            this.seniorID = "TEMP99";
        } else if (id.length() == 6) {
            this.seniorID = id;
        } else {
            throw new InvalidVariableException("seniorID must be exactly 6 characters");
        }
    }

    public String getSeniorID() {
        return seniorID;
    }

    public void setSeniorID(String id) throws InvalidVariableException {
        if (id == null || id.length() != 6) {
            throw new InvalidVariableException("seniorID must be exactly 6 characters");
        }
        this.seniorID = id;
    }

    @Override
    public double getTax() {
        return getCostOfCart() * getTaxRate() / 200.0;
    }

}
