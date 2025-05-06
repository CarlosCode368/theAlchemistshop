import java.util.*;


public class potionBags {
   private static List<PotionPrice>potions=new ArrayList<>();

   private static final Map<String,List<String>>potionRecipes=new HashMap<>();

   public static void addPotion(PotionPrice potion){
       potions.add(potion);
        System.out.println(potion.getColoredName()+" added to your potion bag.");
    }
    public static PotionPrice getPotionFromLetter(char letter){
       int index=letter-'A';
       if(index>=0&& index<potions.size()){
           return potions.get(index);
       }
       return null;
    }
    public static int getPotionCount(PotionPrice potion){
       int count=0;
       for(PotionPrice p:potions){
           if(p.getName().equalsIgnoreCase(potion.getName())){
               count++;
           }
       }
       return count;
    }
    public static void removePotion(PotionPrice potion,int quantity){
       for(int i=0; i<quantity;i++){
           potions.remove(potion);
       }
    }
    public static void openPotionBags(){
        System.out.println("******CURRENT CRAFTED POTIONS******");
        if(potions.isEmpty()) {
            System.out.println("You don't have any potions");
        }else{
            for(int i=0;i<potions.size();i++){
                PotionPrice potion=potions.get(i);
                char letter=(char)('A'+i);
                System.out.println(letter +", "+potion.getColoredName()+"  (Sell Price: "+potion.getSellPrice()+" gold)");
            }
        }
    }
}
