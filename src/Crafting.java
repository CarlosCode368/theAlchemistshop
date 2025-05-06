import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Crafting {

    private static Map<String, List<String>> potionRecipes = new HashMap<>();
    private static final Map<String,MagicSchool>potionSchools=new HashMap<>();


    static {
        potionRecipes.put("Potion of Healing", Arrays.asList("Aloe Vera", "Aloe Vera", "Crystal Vial"));
        potionSchools.put("Potion of Healing", MagicSchool.NATURE);
        potionRecipes.put("Potion of Extinction", Arrays.asList("Aloe Vera", "Petrified Flower", "Crystal Vial"));
        potionSchools.put("Potion of Extinction", MagicSchool.NATURE);
        potionRecipes.put("Potion of Longevity", Arrays.asList("Aloe Vera", "Essence of Light", "Crystal Vial"));
        potionSchools.put("Potion of Longevity",MagicSchool.WITCHCRAFT);
        potionRecipes.put("Potion of Disaster", Arrays.asList("Aloe Vera", "Essence of Fire", "Crystal Vial"));
        potionSchools.put("Potion of Disaster", MagicSchool.NATURE);
        potionRecipes.put("Potion of Ruin", Arrays.asList("Aloe Vera", "Essence of Shadow", "Crystal Vial"));
        potionSchools.put("Potion of Ruin" ,MagicSchool.WITCHCRAFT);
        potionRecipes.put("Potion of Seasons", Arrays.asList("Aloe Vera", "Essence of Frost", "Crystal Vial"));
        potionSchools.put("Potion of Seasons",MagicSchool.ORDER);
        potionRecipes.put("Potion of Fertility", Arrays.asList("Aloe Vera", "Forest Mushroom", "Crystal Vial"));
        potionSchools.put("Potion of Fertility",MagicSchool.NATURE);
        potionRecipes.put("Potion of Life", Arrays.asList("Aloe Vera", "Skull", "Crystal Vial"));
        potionSchools.put("Potion of Life", MagicSchool.NATURE);
        potionRecipes.put("Potion of Infection", Arrays.asList("Aloe Vera", "Blood Vein", "Crystal Vial"));
        potionSchools.put("Potion of Infection",MagicSchool.WITCHCRAFT);
        potionRecipes.put("Potion of Petrification", Arrays.asList("Petrified Flower", "Petrified Flower", "Crystal Vial"));
        potionSchools.put("Potion of Petrification",MagicSchool.ORDER);
        potionRecipes.put("Potion of Transformation", Arrays.asList("Petrified Flower", "Essence of Light", "Crystal Vial"));
        potionSchools.put("Potion of Transformation",MagicSchool.NATURE);
        potionRecipes.put("Potion of Rebirth", Arrays.asList("Petrified Flower", "Essence of Fire", "Crystal Vial"));
        potionSchools.put("Potion of Rebirth",MagicSchool.NATURE);
        potionRecipes.put("Potion of Crows", Arrays.asList("Petrified Flower", "Essence of Shadow", "Crystal Vial"));
        potionSchools.put("Potion of Crows",MagicSchool.WITCHCRAFT);
        potionRecipes.put("Potion of Strength", Arrays.asList("Petrified Flower", "Essence of Frost", "Crystal Vial"));
        potionSchools.put("Potion of Strength",MagicSchool.NATURE);
        potionRecipes.put("Potion of Deception", Arrays.asList("Petrified Flower", "Forest Mushroom", "Crystal Vial"));
        potionSchools.put("Potion of Deception" ,MagicSchool.ORDER);
        potionRecipes.put("Potion of Grief", Arrays.asList("Petrified Flower", "Skull", "Crystal Vial"));
        potionSchools.put("Potion of Grief",MagicSchool.ORDER);
        potionRecipes.put("Potion of Love", Arrays.asList("Petrified Flower", "Blood Vein", "Crystal Vial"));
        potionSchools.put("Potion of Love",MagicSchool.ORDER);
        potionRecipes.put("Potion of Divinity", Arrays.asList("Essence of Light", "Essence of Light", "Crystal Vial"));
        potionSchools.put("Potion of Divinity",MagicSchool.ORDER);
        potionRecipes.put("Potion of Agility", Arrays.asList("Essence of Light", "Essence of Fire", "Crystal Vial"));
        potionSchools.put("Potion of Agility",MagicSchool.NATURE);
        potionRecipes.put("Potion of Wisdom", Arrays.asList("Essence of Light", "Essence of Shadow", "Crystal Vial"));
        potionSchools.put("Potion of Wisdom",MagicSchool.ORDER);
        potionRecipes.put("Potion of Stars", Arrays.asList("Essence of Light", "Essence of Frost", "Crystal Vial"));
        potionSchools.put("Potion of Stars",MagicSchool.ORDER);
        potionRecipes.put("Potion of Purification", Arrays.asList("Essence of Light", "Forest Mushroom", "Crystal Vial"));
        potionSchools.put("Potion of Purification",MagicSchool.NATURE);
        potionRecipes.put("Potion of Godhood", Arrays.asList("Essence of Light", "Skull", "Crystal Vial"));
        potionSchools.put("Potion of Godhood",MagicSchool.ORDER);
        potionRecipes.put("Potion of Justice", Arrays.asList("Essence of Light", "Blood Vein", "Crystal Vial"));
        potionSchools.put("Potion of Justice",MagicSchool.ORDER);
        potionRecipes.put("Potion of Destruction", Arrays.asList("Essence of Fire", "Essence of Fire", "Crystal Vial"));
        potionSchools.put("Potion of Destruction",MagicSchool.NATURE);
        potionRecipes.put("Potion of Demons", Arrays.asList("Essence of Fire", "Essence of Shadow", "Crystal Vial"));
        potionSchools.put("Potion of Demons",MagicSchool.WITCHCRAFT);
        potionRecipes.put("Potion of Chaos", Arrays.asList("Essence of Fire", "Essence of Frost", "Crystal Vial"));
        potionSchools.put("Potion of Chaos",MagicSchool.ORDER);
        potionRecipes.put("Potion of Sickness", Arrays.asList("Essence of Fire", "Forest Mushroom", "Crystal Vial"));
        potionSchools.put("Potion of Sickness",MagicSchool.NATURE);
        potionRecipes.put("Potion of Disintegration", Arrays.asList("Essence of Fire", "Skull", "Crystal Vial"));
        potionSchools.put("Potion of Disintegration",MagicSchool.WITCHCRAFT);
        potionRecipes.put("Potion of Passion", Arrays.asList("Essence of Fire", "Blood Vein", "Crystal Vial"));
        potionSchools.put("Potion of Passion",MagicSchool.ORDER);
        potionRecipes.put("Potion of Darkness", Arrays.asList("Essence of Shadow", "Essence of Shadow", "Crystal Vial"));
        potionSchools.put("Potion of Darkness",MagicSchool.WITCHCRAFT);
        potionRecipes.put("Potion of Uncertainty", Arrays.asList("Essence of Shadow", "Essence of Frost", "Crystal Vial"));
        potionSchools.put("Potion of Uncertainty",MagicSchool.ORDER);
        potionRecipes.put("Potion of Decay", Arrays.asList("Essence of Shadow", "Forest Mushroom", "Crystal Vial"));
        potionSchools.put("Potion of Decay",MagicSchool.NATURE);
        potionRecipes.put("Potion of Zombie", Arrays.asList("Essence of Shadow", "Skull", "Crystal Vial"));
        potionSchools.put("Potion of Zombie",MagicSchool.WITCHCRAFT);
        potionRecipes.put("Potion of Specters", Arrays.asList("Essence of Shadow", "Blood Vein", "Crystal Vial"));
        potionSchools.put("Potion of Specters",MagicSchool.WITCHCRAFT);
        potionRecipes.put("Potion of Mana", Arrays.asList("Essence of Frost", "Essence of Frost", "Crystal Vial"));
        potionSchools.put("Potion of Mana",MagicSchool.NATURE);
        potionRecipes.put("Potion of Coldness", Arrays.asList("Essence of Frost", "Skull", "Crystal Vial"));
        potionSchools.put("Potion of Coldness",MagicSchool.WITCHCRAFT);
        potionRecipes.put("Potion of Winter", Arrays.asList("Essence of Frost", "Forest Mushroom", "Crystal Vial"));
        potionSchools.put("Potion of Winter",MagicSchool.NATURE);
        potionRecipes.put("Potion of Frostbite", Arrays.asList("Essence of Frost", "Blood Vein", "Crystal Vial"));
        potionSchools.put("Potion of Frostbite",MagicSchool.NATURE);
        potionRecipes.put("Potion of Bone Dust", Arrays.asList("Skull", "Skull", "Crystal Vial"));
        potionSchools.put("Potion of Bone Dust",MagicSchool.WITCHCRAFT);
        potionRecipes.put("Potion of Putrefaction", Arrays.asList("Skull", "Forest Mushroom", "Crystal Vial"));
        potionSchools.put("Potion of Putrefaction",MagicSchool.WITCHCRAFT);
        potionRecipes.put("Potion of Corruption", Arrays.asList("Skull", "Blood Vein", "Crystal Vial"));
        potionSchools.put("Potion of Corruption",MagicSchool.WITCHCRAFT);
        potionRecipes.put("Potion of Hallucination", Arrays.asList("Forest Mushroom", "Forest Mushroom", "Crystal Vial"));
        potionSchools.put("Potion of Hallucination",MagicSchool.NATURE);
        potionRecipes.put("Potion of Mutation", Arrays.asList("Forest Mushroom", "Blood Vein", "Crystal Vial"));
        potionSchools.put("Potion of Mutation",MagicSchool.NATURE);
        potionRecipes.put("Potion of Curse", Arrays.asList("Blood Vein", "Blood Vein", "Crystal Vial"));
        potionSchools.put("Potion of Curse",MagicSchool.WITCHCRAFT);

    }

    //STAGE 1 : Place crystal Vial in the station
    public static void openCraftingMenu(Scanner scanner, Inventory inventory) {
        System.out.println("You entered your Alchemy Station.");// Step 1: Require Crystal Vial
        System.out.println("\nCurrent inventory:\n");

        System.out.print("Place the Crystal Vial in the table to begin crafting(Type the letter): ");
        inventory.displayRawMaterialsWithLetters();

        String vialInput = scanner.nextLine().trim().toUpperCase();
        if (vialInput.length()!=1){
            System.out.println("Invalid rune. Please select only one letter.");
            return;
        }
        char vialChar=vialInput.charAt(0);
        String selectedVial=inventory.getItemFromLetter(vialChar);

        if(selectedVial==null||!selectedVial.equalsIgnoreCase("Crystal Vial")||!inventory.hasRawMaterial("Crystal Vial")){
            System.out.println("You need to place a Crystal Vial first to begin crafting.");
            return;
        }

        inventory.removeRawMaterial("Crystal Vial", 1);
        System.out.println("Crystal Vial placed in the table.");

        //STAGE 2: Add two ingredients from the inventory
        List<String> placedIngredients = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            System.out.println("Place ingredient " + (i + 1) + " (Type the letter): ");
            inventory.displayRawMaterialsWithLetters();  // Display available materials

            String letterInput = scanner.nextLine().trim().toUpperCase();
            if (letterInput.length() != 1) {
                System.out.println("Invalid input. Please select only one letter.");
                i--; // Retry same ingredient
                continue;
            }
            char letter = letterInput.charAt(0);

            String selectedItem = inventory.getItemFromLetter(letter);

            if (selectedItem == null || !inventory.hasRawMaterial(selectedItem)) {
                System.out.println("Invalid ingredient or not enough quantity.");
                i--; // Retry same ingredient
                continue;
            }
            if(selectedItem.equalsIgnoreCase("Crystal Vial")){
                System.out.println("You can't put crystal vials into the cauldron.");
                i--;
                continue;
            }

            inventory.removeRawMaterial(selectedItem, 1);
            placedIngredients.add(selectedItem);
            System.out.println(selectedItem + " placed into the cauldron.");
        }

        // Step 3: Confirm brewing
        System.out.println("\nYou placed:");
        for (String item : placedIngredients) {
            System.out.println("- " + item);
        }

        System.out.print("\nWould you like to proceed with brewing? (Y/N): ");
        String confirm = scanner.nextLine().trim().toUpperCase();

        if (confirm.equals("N")) {
            for (String item : placedIngredients) {
                inventory.addRawMaterial(item);
            }
            inventory.addRawMaterial("Crystal Vial");
            System.out.println("Your ingredients and Crystal Vial returned to your inventory.");
            return;
        } else if (!confirm.equals("Y")) {
            System.out.println("Invalid input. Cancelling crafting.");
            for (String item : placedIngredients) {
                inventory.addRawMaterial(item);
            }
            inventory.addRawMaterial("Crystal Vial");
            return;
        }

        // Step 4: Brewing
        System.out.println("\nBrewing...");
        try {
            for (int i = 3; i > 0; i--) {
                System.out.println(i + "...");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Brewing interrupted.");
            return;
        }

        // Step 5: Success
        PotionPrice brewedPotion=null;
       List<String>sortedPlaced=new ArrayList<>(placedIngredients);
       sortedPlaced.add("Crystal Vial");
       Collections.sort(sortedPlaced);

       for(Map.Entry<String,List<String>>entry:potionRecipes.entrySet()){
           List<String>recipe=new ArrayList<>(entry.getValue());
           Collections.sort(recipe);
           if(sortedPlaced.equals(recipe)){
               MagicSchool school=potionSchools.get(entry.getKey());
               brewedPotion=new PotionPrice(entry.getKey(),sortedPlaced,school);
               break;
           }
       }
        if (brewedPotion != null) {
            System.out.println("\n" + brewedPotion.getColoredName()+ " crafted successfully!");
            PotionBags.addPotion(brewedPotion);
        } else {
            System.out.println("\nNo known potion was crafted.");
        }
    }
}