public class GiftCard extends ItemToPurchase{
    public GiftCard(double price) throws InvalidVariableException {
    super("gift card", Math.floor(price), 1);
    }

    public int getPoints(){
        int point = (int)(getPrice() * 50) ;
        return point;
    }
    
    @Override
    public String toString(){
        return "A " + getName() + " @ $" + (int)getPrice() + " = $" + (int)getPrice() + " or " + getPoints() + " points";
    }
}
