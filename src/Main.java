
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String alchemistName = "";
        int gold = 2000; //I'll change this later, user should start with 100 gold
        Inventory inventory = new Inventory();
        Crafting crafting = new Crafting();
        Store store=new Store();
        PotionBags potionBags =new PotionBags();
        new Thread(store::startCustomerRotation).start();


        while (alchemistName.trim().isEmpty()) {
            System.out.println("Please enter your alchemist name");
            alchemistName = scanner.nextLine();

            if (alchemistName.trim().isEmpty()) {
                System.out.println("All good alchemists need to have a name.");
            }
        }

        System.out.println("Welcome to your shop Alchemist " + alchemistName + "!");

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nWhat would you like to do today?\n You have " + gold + " gold coins.");

            try {
                File taskFile = new File("alchemyshopList.txt");
                // M Summon Materials
                // C Craft Potions
                // P Empower Potions
                // S Sell Potions
                // R Raw Materials
                // B Potion Bags
                // X Exit shop (End game)
                Scanner fileScanner = new Scanner(taskFile);

                while (fileScanner.hasNextLine()) {
                    String task = fileScanner.nextLine();
                    if (!task.trim().startsWith("//")) {
                        System.out.println(task);
                    }
                }

                fileScanner.close();

            } catch (FileNotFoundException e) {
                System.out.println("That rune is unknown...");
                return;
            }
            System.out.println("Enter a rune to chose an action: ");
            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "M":
                    gold = SummoningPortal.summonMaterials(scanner, gold, inventory);
                    break;
                case "C":
                    crafting.openCraftingMenu(scanner, inventory);
                    break;

                case "P":
                    EmpowerPotions.empowerPotion(scanner);
                    break;

                case "S":
                    store.interactWithCustomer(scanner,potionBags);
                    break;

                case "R":
                    inventory.displayRawMaterialsWithLetters();

                    String exitInput = "";
                    while (!exitInput.equalsIgnoreCase("x")) {
                        System.out.println("\nType X to return to your main tasks");
                        exitInput = scanner.nextLine();

                    }
                    break;
                case "B":
                    PotionBags.openPotionBags();
                    String exitInputB = "";
                    while (!exitInputB.equalsIgnoreCase("x")) {
                        System.out.println("\nType X to return to your main tasks");
                        exitInputB = scanner.nextLine();
                    }
                    break;

                case "X":
                    isRunning = false;
                    System.out.println("Until next time, " + alchemistName + ".");
                    break;
                default:
                    System.out.println("Incorrect rune, do you want to blow us up?...");
            }
            System.out.println("Current gold: " + gold);
        }
    }
}