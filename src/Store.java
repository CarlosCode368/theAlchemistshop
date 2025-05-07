
import java.util.Scanner;

public class Store {
    private final CustomerManager customerManager;
    private Customer currentCustomer;
    private final Scanner scanner = new Scanner(System.in);
    private final Inventory inventory;

    public Store(Inventory inventory) {
        this.inventory=inventory;
        this.customerManager = new CustomerManager();

    }

    public void serveCustomers() {
        while (true) {
            currentCustomer = customerManager.getRandomCustomer();
            System.out.println(currentCustomer.getName() + " enters your shop.");
            System.out.println(currentCustomer.getName() + " wants a potion from the " + currentCustomer.getRequestedSchool().getColorCode() + currentCustomer.getRequestedSchool().name() + MagicSchool.RESET_CODE + " school.");

            PotionBags.openPotionBags();


            System.out.println("Type the letter of the potion to offer(or skip to ignore customer, or 'X' to return to your main tasks):");
            String input = scanner.nextLine().toUpperCase();

            if(input.equals("X")){
                System.out.println("Returning to main menu...");
                return;
            }

            if (input.equalsIgnoreCase("skip")) {
                System.out.println(currentCustomer.getName() + " leaves disappointed.");
            } else if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                PotionPrice selectedPotion = PotionBags.getPotionFromLetter(input.charAt(0));
                if (selectedPotion != null && selectedPotion.getSchool() == currentCustomer.getRequestedSchool()) {

                    System.out.println("Handing over the potion");
                    for(int i=0; i<3;i++){
                        try{
                            Thread.sleep(1000);
                        }catch(InterruptedException e){
                            Thread.currentThread().interrupt();
                        }
                        System.out.println(".");
                    }
                    System.out.println();

                    PotionBags.removePotion(selectedPotion, 1);
                    int sellPrice=selectedPotion.getSellPrice();
                    inventory.addGold(sellPrice);

                    System.out.println(currentCustomer.getName() + " :Thanks! Here's your gold.\"");
                    System.out.println("You earned"+sellPrice+"gold. Total gold: "+inventory.getGold());

                } else {
                    System.out.println(currentCustomer.getName() + ":\"I don't want that potion!\"");
                }
            } else {
                System.out.println("Invalid input.");
            }
            System.out.println("\n---A new customer enters...---\n");
        }
    }
}





