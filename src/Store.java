import java.util.Scanner;

public class Store {
    private CustomerManager customerManager;
    private Customer currentCustomer;

    public Store() {
        customerManager = new CustomerManager();
    }

    // Customer rotation method in a background thread
    public void startCustomerRotation() {
        while (true) {
            try {
                // Sleep for 30 seconds before the next customer
                Thread.sleep(30000);  // 30 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Get a random customer after every 30 seconds
            currentCustomer = customerManager.getRandomCustomer();
        }
    }

    // Method for interacting with a customer (only when the player chooses to sell potions)
    public void interactWithCustomer(Scanner scanner, PotionBags potionBags) {
        if (currentCustomer == null) {
            System.out.println("No customers right now.");
            return;
        }

        // Display the current customer info
        System.out.println("New customer: " + currentCustomer.getName() + " requests a potion from the " + currentCustomer.getRequestedSchool() + " school.");
        System.out.println("Do you want to sell a potion to " + currentCustomer.getName() + "? (Y/N)");

        // Wait for player input to interact with the customer
        String input = scanner.nextLine().toUpperCase();

        if (input.equals("Y")) {
            // You can add the logic to check potions based on the magic school requested
            System.out.println("You can sell potions to " + currentCustomer.getName());
        } else {
            System.out.println("Customer " + currentCustomer.getName() + " leaves.");
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        Store store = new Store();
        Scanner scanner = new Scanner(System.in);
        PotionBags potionBags = new PotionBags();  // Create an instance of PotionBags

        // Start the customer rotation in a background thread
        new Thread(store::startCustomerRotation).start();

        // Main loop for interacting with the user
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Interact with customer");
            System.out.println("2. Exit");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    store.interactWithCustomer(scanner, potionBags);  // Interact with customer when selected
                    break;
                case "2":
                    isRunning = false;
                    System.out.println("Exiting the shop...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again!");
            }
        }

        scanner.close();
    }
}
