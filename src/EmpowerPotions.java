import java.util.Scanner;
public class EmpowerPotions {
    public static void empowerPotion(Scanner scanner) {
        //so what is better two greater potions to create a greatest, or only 3 potions of the same type to create greatest?
        System.out.println("Welcome to your Empowering Altar!");

        potionBags.openPotionBags();

        System.out.println("Combine two of the same to enhance its power! (Choose letter of the potion");
        String potionChoice = scanner.nextLine().trim().toUpperCase();

        if (potionChoice.length() != 1) {
            System.out.println("Invalid. Please enter a single rune.");
            return;
        }

        char choiceChar = potionChoice.charAt(0);
        PotionPrice potionToEmpower = potionBags.getPotionFromLetter(choiceChar);

        if (potionToEmpower == null) {
            System.out.println("Invalid rune.Try again.");
            return;
        }
        int potionCount = potionBags.getPotionCount(potionToEmpower);
        if (potionCount < 2) {
            System.out.println("You don't have two of the same potion...");
            return;
        }
        int baseCost = potionToEmpower.getCost();
        String newName;
        int newCost = 0;
        PotionPrice empoweredPotion=null;

        if (potionToEmpower.getName().startsWith("Greater")) {
            newName = "Greatest " + potionToEmpower.getName().replaceFirst("Greater ", "");
            newCost = baseCost * 2;
        } else if (potionToEmpower.getName().startsWith("Greatest")) {
            System.out.println("You can't empower this potion any further.");
            return;
        } else {
            newName = "Greater " + potionToEmpower.getName();
            newCost = baseCost * 2;
        }
        //START EMPOWERING
        System.out.print("\nWould you like to proceed with the empowering ritual? (Y/N): ");
        String confirm = scanner.nextLine().trim().toUpperCase();

        if (confirm.equals("N")) {
            System.out.println("Empowering cancelled. No potions were used.");
            return;
        } else if (!confirm.equals("Y")) {
            System.out.println("Invalid input. Empowering cancelled.");
            return;
        }

        potionBags.removePotion(potionToEmpower, 2);

        System.out.println("\nThe altar trembles as arcane energy empowers the potion...");
        try {
            for (int i = 3; i > 0; i--) {
                System.out.println(i + "...");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("The empowering ritual was interrupted.");
            return;
        }
        empoweredPotion = new PotionPrice(newName, potionToEmpower.getIngredients(), potionToEmpower.getSchool());
                potionBags.addPotion(empoweredPotion);
        System.out.println("You have successfully empowered the " + potionToEmpower + " into a " + empoweredPotion + "!");
    }
}


