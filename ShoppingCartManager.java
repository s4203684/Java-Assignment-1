import java.util.Scanner;

public class ShoppingCartManager {
    static Scanner scan = new Scanner(System.in);
    public static void stage1(ItemToPurchase item){

        System.out.println("Enter name of the item: ");
        String itemName =scan.nextLine();

        System.out.println("Enter price of " + itemName + ": ");
        int itemPrice =scan.nextInt();
        scan.nextLine();

        System.out.println("Enter quantity: ");
        int itemQuantity =scan.nextInt();
        scan.nextLine();

        item.setName(itemName);
        item.setPrice(itemPrice);
        item.setQuantity(itemQuantity);

        System.out.println("Total: " + item);

    }
    public static void stage2(ShoppingCart cart){

        System.out.println("Enter name of the customer: ");
        String customerName =scan.nextLine();
        cart.setCustomerName(customerName);

        System.out.println("Enter the current date: ");
        String currentDate =scan.nextLine();
        cart.setDate(currentDate);

        cart.printTotal();

        String choice = "Y";
        while (choice.equals("Y")) {
            System.out.println("Enter name of the item: ");
            String itemName =scan.nextLine();

            System.out.println("Enter price of " + itemName + ": ");
            int itemPrice =scan.nextInt();
            scan.nextLine();

            System.out.println("Enter quantity: ");
            int itemQuantity =scan.nextInt();
            scan.nextLine();

            ItemToPurchase item = new ItemToPurchase(itemName, itemPrice, itemQuantity);
            cart.addItem(item);
            System.out.println("Add more? (Y/N)");
            choice = scan.nextLine();

        }
        cart.printTotal();
    }

    public static void stage3(ShoppingCart cart){
        String choice;
        System.out.println("Do you want to modify an item from the cart? Y/N");
        choice = scan.nextLine();

        while (choice.equals("Y")) {
            System.out.println("Enter name of the item: ");
            String itemName =scan.nextLine();
            cart.modifyItem(itemName);

            System.out.println("Do you want to modify an other item from the cart? Y/N");
            choice = scan.nextLine();
        }
        cart.printTotal();


        
            String checkout;
            System.out.println("Do you want to checkout? Y/N");
            checkout = scan.nextLine();
            if(checkout.equals("Y")){
                cart.checkout();
            }
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
