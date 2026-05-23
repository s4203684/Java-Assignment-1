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

    public static void stage2(Scanner sc){
    }

    public static void stage3(){
    }

    //You may call other stages there but with exception handling enabled
    public static void stage4(Scanner sc){ 
    }
}