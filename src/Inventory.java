import java.util.Map;
import java.util.HashMap;

public class Inventory {
    private Map<String, Integer> rawMaterials;
    private Map<Character, String> itemLetters;  // Add a map for letter-to-item association
    private Map<String,Integer>potions; //might change this somewhere else

    public Inventory() {
        potions=new HashMap<>();
        rawMaterials = new HashMap<>();
        itemLetters = new HashMap<>();
        updateItemLetters();  // Initialize the letters for items
    }

    // Initialize item letters based on inventory items
    private void updateItemLetters(){
        itemLetters.clear();
        char letter='A';

        for (Map.Entry<String, Integer> entry: rawMaterials.entrySet()){
            if(entry.getValue()>0){
                itemLetters.put(letter,entry.getKey());
                letter++;
            }
        }

    }

    // Method to get an item from the letter input
    public String getItemFromLetter(char letter) {
        return itemLetters.get(letter);
    }

    // Method to add a raw material to the inventory
    public void addRawMaterial(String itemName) {
        rawMaterials.put(itemName, rawMaterials.getOrDefault(itemName, 0) + 1);
    }
    public void addPotion(String potionName){
        potions.put(potionName,potions.getOrDefault(potionName,0)+1);
        System.out.println(potionName + " added to your potion inventory"); //might change location
    }
    public boolean hasRawMaterial(String itemName) {
        return rawMaterials.containsKey(itemName) && rawMaterials.get(itemName) > 0;
    }
    public void removeRawMaterial(String itemName, int quantity) {
        if (rawMaterials.containsKey(itemName)) {
            int currentQuantity = rawMaterials.get(itemName);
            if(currentQuantity<=quantity) {
                rawMaterials.remove(itemName);
            }else{
                rawMaterials.put(itemName,currentQuantity-quantity);
            }
        }
    }

    // Method to display raw materials with associated letters
    public void displayRawMaterialsWithLetters() {
        updateItemLetters();
        if (rawMaterials.isEmpty()) {
            System.out.println("You have no raw materials.");
        } else {
            System.out.println("Your Raw Materials (use letters to select):");
            for(Map.Entry<Character,String>entry:itemLetters.entrySet()){
            String item=entry.getValue();
            int quantity=rawMaterials.get(item);
            System.out.println(entry.getKey()+". "+item+" x"+quantity);
            }
        }
    }
}



