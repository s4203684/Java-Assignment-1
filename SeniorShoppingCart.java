public class SeniorShoppingCart extends ShoppingCart {

    // Unique identification for the senior customer
    private String seniorID;

    public SeniorShoppingCart(String name, String date, String id) throws InvalidVariableException {
        // Constructor to initialize the cart with senior-specific details.
        // param name Name of the customer.
        // param date Transaction date.
        // param id The 6-character senior ID.
        // throws InvalidVariableException if the ID format is incorrect.
        // Initialize the base ShoppingCart fields (name and date)
        super(name, date);
        // Validation logic for the senior ID
        if (id == null) {
            this.seniorID = "TEMP99"; // Assign a default temporary ID if null
        } else if (id.length() == 6) {
            this.seniorID = id; // Accept ID if it meets the 6-character requirement
        } else {
            // Reject any ID that is not exactly 6 characters long
            throw new InvalidVariableException("seniorID must be exactly 6 characters");
        }
    }

    // return The current senior ID string.
    public String getSeniorID() {
        return seniorID;
    }

    // Updates the senior ID with strict validation
    // param id The new ID to set
    // throws InvalidVariableException if the ID is null or not 6 characters
    public void setSeniorID(String id) throws InvalidVariableException {
        if (id == null || id.length() != 6) {
            throw new InvalidVariableException("seniorID must be exactly 6 characters");
        }
        this.seniorID = id;
    }

    // Overrides the tax calculation logic
    @Override
    public double getTax() {
        return getCostOfCart() * getTaxRate() / 200.0;
    }

}
