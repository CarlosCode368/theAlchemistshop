import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomerManager {
    private List<Customer> customers;
    private Random random;

    public CustomerManager(){
        customers=new ArrayList<>();
        random=new Random();

        customers.add(new Customer("Warrior"));
        customers.add(new Customer("Knight"));
        customers.add(new Customer("Princess"));
        customers.add(new Customer("Queen"));
        customers.add(new Customer("King"));
        customers.add(new Customer("Prince"));
        customers.add(new Customer("Witch"));
        customers.add(new Customer("Druid"));
        customers.add(new Customer("Priest"));
        customers.add(new Customer("Villager"));
        customers.add(new Customer("Maiden"));
        customers.add(new Customer("Barbarian"));
        customers.add(new Customer("Rogue"));
        customers.add(new Customer("Pirate"));
        customers.add(new Customer("Fisherman"));
        customers.add(new Customer("Bartender"));
        customers.add(new Customer("Sorceress"));
        customers.add(new Customer("Baker"));
        customers.add(new Customer("Old man"));
        customers.add(new Customer("Old lady"));
        customers.add(new Customer("Soldier"));
        customers.add(new Customer("Guard"));
        customers.add(new Customer("Hunter"));
        customers.add(new Customer("Miner"));
        customers.add(new Customer("Blacksmith"));
}
public Customer getRandomCustomer() {
    Customer customer = customers.get(random.nextInt(customers.size()));
    customer.generateRandomRequest();
    return customer;
}
}
