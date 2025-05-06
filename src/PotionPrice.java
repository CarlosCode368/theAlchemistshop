import java.util.List;
import java.util.Map;

public class PotionPrice {
    private String name;
    private List<String> ingredients;
    private MagicSchool school;

    private static final Map<String, Integer> INGREDIENT_PRICES = Map.of(
            "Blood Vein", 15,
            "Petrified Flower", 40,
            "Essence of Frost", 20,
            "Essence of Shadow", 20,
            "Essence of Fire", 20,
            "Essence of Light", 20,
            "Crystal Vial", 10,
            "Skull", 60,
            "Aloe Vera", 4,
            "Forest Mushroom", 8
    );

    public PotionPrice(String name, List<String> ingredients, MagicSchool school) {
        this.name = name;
        this.ingredients = ingredients;
        this.school=school;
    }
    public String getColoredName(){
        return school.getColorCode()+name+MagicSchool.RESET_CODE;
    }

    public String getName() {
        return name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }
    public MagicSchool getSchool(){
        return school;
    }

    public int getCost() {
        int total = 0;
        for (String ingredient : ingredients) {
            total += INGREDIENT_PRICES.getOrDefault(ingredient, 0);
        }
        return total;
    }

    public int getSellPrice() {

        int cost = getCost();
        if (name.startsWith("Greatest")) {
            return (int) (cost * 9.4);
        } else if (name.startsWith("Greater")) {
            return(int) (cost * 3.2);
        }else{
            return (int) (cost * 1.5);
        }
    }
    @Override
    public String toString(){
        return name+" (Sell Price: "+getSellPrice()+" gold)";
    }
}
