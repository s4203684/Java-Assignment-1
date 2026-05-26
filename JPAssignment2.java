import java.util.Scanner;

public class JPAssignment2{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("*************** Stage 1 ***************");
        stage1(sc);
        
        
        System.out.println("*************** Stage 2***************");
        stage2(sc);
        
        System.out.println("*************** Stage 3***************");
        stage3();
        
        System.out.println("*************** Stage 4***************");
        stage4(sc);
    }

    public static void stage1(Scanner sc){
        System.out.println("Enter name of the item:");

        String itemName;
        itemName = sc.nextLine();

        String normalized;
        normalized = itemName.toLowerCase().replace(" ", "");

        if (normalized.equals("giftcard")){
            System.out.println("One gift card, pls enter the price:");
            double price = sc.nextDouble();

            sc.nextLine();
            System.out.println("Total: " + new GiftCard(price));

        }

        else if(normalized.equals("donation")){
            System.out.println("A donation, enter the quantity of units ($10 per unit):");
            double quantity = sc.nextDouble();

            sc.nextLine();
            System.out.println("Total: " + new Donation(quantity));

        }

        else{
            System.out.println("Enter price of " + itemName + ":");
            double price = sc.nextDouble();
            sc.nextLine();
            
            System.out.println("Enter quantity:");
            double quantity = sc.nextDouble();
            sc.nextLine();

            System.out.println("Total: " + new ItemToPurchase(itemName, price, quantity));

        }

    }

    public static void stage2(Scanner sc) {
      System.out.println("Enter name of the customer:");
      String customerName = sc.nextLine();

      System.out.println("Enter the current date:");
      String currentDate = sc.nextLine();

      System.out.println("Enter the available points:");
      int availablePoints = sc.nextInt();
      sc.nextLine();


      VIPShoppingCart cart = new VIPShoppingCart(customerName, currentDate, availablePoints);

      String choice = "Y";
      while(choice.equals("Y")){
        System.out.println("Enter name of the item:");
        String itemName = sc.nextLine();

        if (cart.containsItem(itemName)) {
            System.out.println("ITEM ALREADY EXIST.");
        }
        else{
            System.out.println("Enter price of " + itemName + ":");
            double price = sc.nextDouble();

            System.out.println("Enter quantity:");
            double quantity = sc.nextDouble();

            sc.nextLine();
            ItemToPurchase item = new ItemToPurchase(itemName, price, quantity);
            cart.addItem(item);
        }

        System.out.println("Add more? (Y/N)");
        choice = sc.nextLine();
      }
      cart.checkout();
   }

    public static void stage3(){
        ShoppingCart cart1 = new ShoppingCart("Aminur", "1 Jun 2026");
        cart1.addItem(new ItemToPurchase("apple", 5, 3));
        cart1.addItem(new ItemToPurchase("bread", 4.5, 2));
        cart1.addItem(new ItemToPurchase("milk", 3, 1));
        cart1.addItem(new GiftCard(25));



        ShoppingCart cart2 = new ShoppingCart("Shiv", "1 Jun 2026");
        cart2.addItem(new ItemToPurchase("rice", 10, 2));
        cart2.addItem(new ItemToPurchase("eggs", 6, 1));
        cart2.addItem(new ItemToPurchase("sugar", 3, 1));
        cart2.addItem(new Donation(2));


        VIPShoppingCart cart3 = new VIPShoppingCart("Samanta", "1 Jun 2026", 500);
        cart3.addItem(new ItemToPurchase("oil", 89.99, 2));
        cart3.addItem(new ItemToPurchase("cold-drinks", 25, 1));
        cart3.addItem(new ItemToPurchase("brush", 40, 1));
        cart3.addItem(new GiftCard(50));


        SeniorShoppingCart cart4 = new SeniorShoppingCart("Mani", "1 Jun 2026", "VC2503");
        cart4.addItem(new ItemToPurchase("tea", 4, 2));
        cart4.addItem(new ItemToPurchase("biscuits", 5, 1));
        cart4.addItem(new ItemToPurchase("oats", 8, 1));
        cart4.addItem(new Donation(1));


        ShoppingCart[] allCarts = { cart1, cart2, cart3, cart4 };
        double totalTax = 0;
        for (int i =0; i < allCarts.length; i++){
            allCarts[i].printTotal();
            System.out.println("Tax: $" + allCarts[i].getTax());
            totalTax = totalTax + allCarts[i].getTax();
            System.out.println();
        }

        System.out.println("Total tax on all shopping carts: $" + totalTax);
    }

    //You may call other stages there but with exception handling enabled
    public static void stage4(Scanner sc){ 
    }
}