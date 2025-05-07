import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SummoningPortal {

    public static void summonMaterials(Scanner scanner, Inventory inventory) {
        try {
            File materialFile = new File("summonMaterials.txt");
            Scanner fileScanner = new Scanner(materialFile);

            ArrayList<String> items = new ArrayList<>();
            ArrayList<Integer> prices = new ArrayList<>();

            int index = 1;
            System.out.println("Welcome to The Portal, here you will summon and buy any materials you need.\nBe aware that you have to buy 1 Crystal Vial to brew a potion.");

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                if (!line.contains(",")) {
                    System.out.println(line);
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String itemName = parts[0].trim();
                    int itemCost = Integer.parseInt(parts[1].trim());

                    items.add(itemName);
                    prices.add(itemCost);

                    System.out.println(index + ". " + itemName + " - " + itemCost + " gold");
                    index++;
                }
            }
            fileScanner.close();

            System.out.println("X - Exit The Portal");

            boolean isBuying = true;

            while (isBuying) {
                System.out.println("\nChoose an item to summon and buy (1-" + (index - 1) + ") or type X to return to your main tasks.");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("X")) {
                    System.out.println("Leaving The Portal...");
                    break;
                }

                int choice;
                try {
                    choice = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("That rune is unknown...");
                    continue;
                }

                if (choice > 0 && choice <= items.size()) {
                    String selectedItem = items.get(choice - 1);
                    int itemCost = prices.get(choice - 1);

                    System.out.println("How many " + selectedItem + "(s) would you like to buy?");
                    int quantity;
                    try {
                        quantity = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("That's not a valid number.");
                        continue;
                    }

                    int totalCost = itemCost * quantity;
                    int currentGold = inventory.getGold();

                    if (currentGold >= totalCost) {
                        System.out.println("You acquired " + quantity + " " + selectedItem + "(s)!\nItems moved to your Raw Materials.");
                        inventory.setGold(currentGold - totalCost);

                        for (int i = 0; i < quantity; i++) {
                            inventory.addRawMaterial(selectedItem);
                        }

                        System.out.println("You now have " + inventory.getGold() + " gold left.");
                    } else {
                        System.out.println("Not enough gold!");
                        System.out.print("Continue buying or type X to leave The Portal: ");
                        String retry = scanner.nextLine();

                        if (retry.equalsIgnoreCase("X")) {
                            System.out.println("Leaving The Portal...");
                            isBuying = false;
                        }
                    }
                } else {
                    System.out.println("That rune does not exist");
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Summon materials not found");
        }
    }
}


