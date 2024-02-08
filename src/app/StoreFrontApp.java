/**
 * David Enriquez
 * CST-239
 * Assignment: CST-239 MilestoneProject
 * December 20, 2023
 * Citations(s):
 * Grand Canyon University CST-239 Milestone Guide
 */
package app;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The StoreFrontApp class represents a console-based store front application
 * providing functionalities to view products, purchase items, and cancel purchases.
 */
public class StoreFrontApp {

	/**
     * The main method serves as the entry point of the application.
     * It displays a menu allowing users to interact with the store's functionalities.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Here we create an instance of the InventoryManager
        // class named inventoryManager using the default constructor.
        InventoryManager inventoryManager = new InventoryManager();

        // Here we invokes the initializeStore() method of the
        // inventoryManager object to set up the initial store state.
        inventoryManager.initializeStore();

        // Here we create an instance of the ShoppingCart class
        // named cart using its default constructor to handle
        // items a user purchases.
        ShoppingCart cart = new ShoppingCart();

        // We initialize a Scanner object named userInput to
        // handle user input via the console.
        Scanner userInput = new Scanner(System.in);
        
        // Here we declare a boolean variable exit and
        // initializes it to false to control the loop
        // for the menu options.
        boolean exit = false;

        // We initiate a loop that continues to display
        // the store menu options as long as exit is false.
        while (!exit) {
            // Here we print the welcome message and the
            // menu options for the user to choose from.
            System.out.println("Welcome to the store known across the lands as, The Legendary Armory!");
            System.out.println("Select an option:");
            System.out.println("1. View Products");
            System.out.println("2. Purchase a Product");
            System.out.println("3. Cancel a Purchase");
            System.out.println("4. View Cart");
            System.out.println("5. Empty Cart"); // Added option to view the cart
            System.out.println("6. Compare Weapons"); // Added option to compare weapons
            System.out.println("7. Exit");

            // Here we read the user's integer input
            // from the console to determine their choice.
            int choice = userInput.nextInt();

            // Here we execute different blocks of code based
            // on the user's selected option using a switch statement.
            // Each case inside the switch statement corresponds to
            // one of the menu options, invoking different methods
            // based on the user's selection.
            switch (choice) {
                case 1:
                    // Invokes the displayAvailableProducts() method from the InventoryManager.
                	displayAvailableProducts(inventoryManager, userInput);
                    break;
                case 2:
                    // Invokes the purchaseProduct() method with the inventoryManager, cart, and userInput.
                    purchaseProduct(inventoryManager, cart, userInput);
                    break;
                case 3:
                    // Invokes the cancelPurchase() method with the inventoryManager, cart, and userInput.
                    cancelPurchase(inventoryManager, cart, userInput);
                    break;
                case 4:
                    // View Cart option
                    viewCart(cart);
                    break;
                case 5:
                    // Empty Cart option
                    emptyCart(cart);
                    break;
                case 6:
                    compareWeapons(inventoryManager, userInput);
                    break;
                case 7:
                    // Prints an exit message and sets exit = true, which exits the loop.
                    System.out.println("Thank you for visiting! You are now exiting The Legendary Armory. Goodbye!");
                    exit = true;
                    break;
                default:
                    // This default case ensures that if the user enters an
                    // unexpected value, they receive this message and are
                    // prompted to make a valid choice.
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
        userInput.close();
    }
    
    /**
     * Displays the available products in the inventory.
     *
     * @param inventoryManager The InventoryManager to retrieve product information.
     * @see InventoryManager
     */
    public static void displayAvailableProducts(InventoryManager inventoryManager, Scanner userInput) {
        // Retrieve a list of SalableProduct objects by calling the getInventory() method.
        List<SalableProduct> products = inventoryManager.getInventory();

        // Prompt the user for sorting options.
        promptSortingOptions(inventoryManager, userInput);

        // Display the sorted products.
        System.out.println("Available Products:");

        for (SalableProduct product : products) {
            System.out.println("Product Name: " + product.getName());
            System.out.println("Description: " + product.getDescription());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Quantity Available: " + product.getQuantity());
            System.out.println("-----------------------------------");
        }

        // Prompt the user to return to the main menu.
        System.out.println("Press any key to return to the main menu.");
        new Scanner(System.in).nextLine();
    }

    /**
     * Prompts the user for sorting options and applies the chosen sorting.
     *
     * @param inventoryManager The InventoryManager to perform sorting.
     * @param userInput        The Scanner object used to receive user input.
     */
    private static void promptSortingOptions(InventoryManager inventoryManager, Scanner userInput) {
        System.out.println("Select sorting option:");
        System.out.println("1. Sort by Name");
        System.out.println("2. Sort by Name (Descending)");
        System.out.println("3. Sort by Price");
        System.out.println("4. Sort by Price (Descending)");
        System.out.println("5. Return to Main Menu");

        int sortingChoice = userInput.nextInt();

        switch (sortingChoice) {
            case 1:
                inventoryManager.sortByName();
                break;
            case 2:
                inventoryManager.sortByNameDescending();
                break;
            case 3:
                inventoryManager.sortByPrice();
                break;
            case 4:
                inventoryManager.sortByPriceDescending();
                break;
            default:
                // Do nothing for invalid choice or return to the main menu.
                break;
        }
    }
    
    /**
     * Handles the purchase of a product by adding it to the shopping cart.
     *
     * @param inventoryManager Represents the manager responsible for managing the inventory of products.
     * @param cart             Represents the shopping cart where purchased items are stored.
     * @param userInput        Represents the Scanner object used to receive user input.
     * @see InventoryManager
     * @see ShoppingCart
     */
    public static void purchaseProduct(InventoryManager inventoryManager, ShoppingCart cart, Scanner userInput) {

        // We retrieve a list of available SalableProduct objects
        // by calling the getInventory() method of the provided InventoryManager.
        List<SalableProduct> products = inventoryManager.getInventory();

        // We print out the list of available products with
        // their corresponding numbers for selection using a for loop.
        System.out.println("Available Products:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i).getName());
        }

        // We prompts the user to input the number of the desired product for purchase.
        System.out.println("Enter the number of the product to purchase:");
        int productChoice = userInput.nextInt();

        // Checks if the user's choice is valid. If valid, we retrieve
        // the selected product from the list, add it to both the
        // inventory and the shopping cart, and provides feedback
        // to the user on the successful purchase. If invalid, we display
        // a message indicating an invalid product choice.
        if (productChoice >= 1 && productChoice <= products.size()) {
            SalableProduct selectedProduct = products.get(productChoice - 1);

            // Add the selected product to the cart
            cart.addProduct(selectedProduct);

            // Update the server with the new inventory
            String updateCommand = "U";
            List<SalableProduct> updatedInventory = inventoryManager.getInventory();
            NetworkClient networkClient = new NetworkClient("localhost", 6666);  // Use the same port as the server
            networkClient.sendCommand(updateCommand, updatedInventory);

            // Display feedback to the user on the successful purchase
            System.out.println("Purchase completed: " + selectedProduct.getName() + " purchased.");

            // Remove the purchased product from the local inventory
            inventoryManager.removeFromInventory(selectedProduct, 1);
        } else {
            System.out.println("Invalid product choice.");
        }

        // Here we display a message prompting the user to return to
        // the main menu and waits for any key press to simulate
        // going back to the main menu after the purchase process.
        System.out.println("Press any key to return to the main menu.");
        new Scanner(System.in).nextLine();
    }

    /**
     * Cancels a purchase by removing the selected product from the shopping cart and adding it back to the inventory.
     *
     * @param inventoryManager The InventoryManager to manage product inventory.
     * @param cart             The ShoppingCart to manage purchased items.
     * @param userInput        The Scanner for user input.
     * @see InventoryManager
     * @see ShoppingCart
     */
    public static void cancelPurchase(InventoryManager inventoryManager, ShoppingCart cart, Scanner userInput) {
    	
    	 String retrieveCommand = "R";
         NetworkClient networkClientRetrieve = new NetworkClient("localhost", 6666);  // Use the same port as the server

         networkClientRetrieve.sendCommand(retrieveCommand, new ArrayList<>());
    	
    	// We display a message to show the user their current
    	// cart contents using the viewCart() method of the ShoppingCart class.
        System.out.println("Your current cart contains:");
        cart.viewCart();
        
        // We prompt the user to enter the number of
        // the product they want to cancel from their cart.
        // Checks if the user's cancellation choice is valid. If valid,
        // we retrieve the selected product to cancel, remove it from
        // the cart, add it back to the inventory, and provide the user
        // feedback on the canceled purchase. If invalid, we display a
        // message indicating an invalid product choice.
        System.out.println("Enter the number of the product to cancel:");
        int cancelChoice = userInput.nextInt();

        if (cancelChoice >= 1 && cancelChoice <= cart.getCartSize()) {
            SalableProduct cancelledProduct = cart.getProduct(cancelChoice - 1);
            cart.removeProduct(cancelledProduct);
            inventoryManager.addToInventory(cancelledProduct);
            System.out.println("Purchase of " + cancelledProduct.getName() + " canceled.");
        } else {
            System.out.println("Invalid product choice.");
        }
        
        // Here we display a message prompting the user to return to
        // the main menu and waits for any key press to simulate
        // going back to the main menu after the purchase process.
        System.out.println("Press any key to return to the main menu.");
        new Scanner(System.in).nextLine();
    }
    
    /**
     * Displays the contents of the shopping cart.
     *
     * @param cart The ShoppingCart to be displayed.
     * @see ShoppingCart
     */
    private static void viewCart(ShoppingCart cart) {
        System.out.println("Shopping Cart Contents:");
        cart.viewCart();
        System.out.println("Press any key to return to the main menu.");
        new Scanner(System.in).nextLine();
    }
    
    /**
     * Empties the contents of the shopping cart.
     *
     * @param cart The ShoppingCart to be emptied.
     * @see ShoppingCart
     */
    private static void emptyCart(ShoppingCart cart) {
        cart.emptyCart();
        System.out.println("Shopping Cart emptied. You have now returned to the main menu!");
        // No need to wait for user input here, as it will return to the main menu directly.
    }
    
    /**
     * Compares weapons based on their names and prints the results to the console.
     *
     * @param inventoryManager The InventoryManager containing the list of weapons.
     * @param userInput        The Scanner object used to receive user input.
     */
    public static void compareWeapons(InventoryManager inventoryManager, Scanner userInput) {
        // Retrieve the list of products from the inventory manager
        List<SalableProduct> products = inventoryManager.getInventory();
        
        // Filter the products to include only weapons
        List<Weapon> weapons = filterWeapons(products);

        System.out.println("Weapons for Comparison:");
        
        // Display the list of weapons for the user to choose from
        for (int i = 0; i < weapons.size(); i++) {
            System.out.println((i + 1) + ". " + weapons.get(i).getName());
        }

        System.out.println("Enter the first weapon number to compare:");
        int firstWeaponChoice = userInput.nextInt();
        System.out.println("Enter the second weapon number to compare:");
        int secondWeaponChoice = userInput.nextInt();

        // Check if the user's choices are valid
        if (isValidWeaponChoice(firstWeaponChoice, weapons) && isValidWeaponChoice(secondWeaponChoice, weapons)) {
            Weapon weapon1 = weapons.get(firstWeaponChoice - 1);
            Weapon weapon2 = weapons.get(secondWeaponChoice - 1);

            int comparisonResult = weapon1.compareTo(weapon2);

            // Display the comparison results
            if (comparisonResult < 0) {
                System.out.println(weapon1.getName() + " comes before " + weapon2.getName() + " in alphabetical order.");
            } else if (comparisonResult > 0) {
                System.out.println(weapon1.getName() + " comes after " + weapon2.getName() + " in alphabetical order.");
            } else {
                System.out.println(weapon1.getName() + " and " + weapon2.getName() + " have the same name.");
            }
        } else {
            System.out.println("Invalid weapon choice.");
        }

        // Wait for user input before returning to the main menu
        System.out.println("Press any key to return to the main menu.");
        new Scanner(System.in).nextLine();
    }

    /**
     * Filters the list of products to include only weapons.
     *
     * @param products The list of products to be filtered.
     * @return A list containing only weapons.
     */
    private static List<Weapon> filterWeapons(List<SalableProduct> products) {
        List<Weapon> weapons = new ArrayList<>();
        
        // Iterate through the products and add weapons to the filtered list
        for (SalableProduct product : products) {
            if (product instanceof Weapon) {
                weapons.add((Weapon) product);
            }
        }
        return weapons;
    }

    /**
     * Checks if the user's choice of weapon is valid.
     *
     * @param choice  The user's choice.
     * @param weapons The list of weapons to choose from.
     * @return True if the choice is valid, false otherwise.
     */
    private static boolean isValidWeaponChoice(int choice, List<Weapon> weapons) {
        return choice >= 1 && choice <= weapons.size();
    }
}