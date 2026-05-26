public class SeniorShoppingCart extends ShoppingCart{

    private String seniorID;

    public SeniorShoppingCart(String name, String date, String id){
        super(name, date);
        if (id != null && id.length() == 6) {
             this.seniorID = id;
        }
        else {
            this.seniorID = "TEMP99";
        }
    }


    public String getSeniorID(){
        return seniorID;
    }

    public void setSeniorID(String id){
        if (id != null && id.length() == 6) {
            this.seniorID = id;
        }
    }


    @Override
    public double getTax() {
        return getCostOfCart() * getTaxRate() / 200.0;
    }
    
}
