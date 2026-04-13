import java.util.Scanner;

public class ShoppingCartManager {
    public static void stage1(ItemToPurchase item){
        Scanner scan = new Scanner(System.in);

        
        System.out.println("Enter name of the item: ");
        String itemName =scan.nextLine();

        System.out.println("Enter price of " + itemName + ": ");
        int itemPrice =scan.nextInt();

        System.out.println("Enter quantity: ");
        int itemQuantity =scan.nextInt();

        item.setName(itemName);
        item.setPrice(itemPrice);
        item.setQuantity(itemQuantity);

        System.out.println("Total: " + item);

    }
    public static void stage2(ShoppingCart cart){

    }

    public static void stage3(ShoppingCart cart){

    }


    public static void main(String[] args) {
        ItemToPurchase item = new ItemToPurchase();
        ShoppingCart cart = new ShoppingCart();
        
        System.out.println("***************Stage 1***************");
        stage1(item);
        
        System.out.println("***************Stage 2***************");
        stage2(cart);
        
        System.out.println("***************Stage 3***************");
        stage3(cart);

    }
}
