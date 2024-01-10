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

/**
 * The InventoryManager class represents a object
 * responsible for managing the inventory of salable
 * products in the store. It provides methods to
 * initialize the store with products and access
 * the current inventory.
 */
public class InventoryManager {
    private List<SalableProduct> inventory;

    /**
     * Constructs an InventoryManager, initializing an empty inventory list.
     */
    public InventoryManager() {
        this.inventory = new ArrayList<>();
    }
    
    /**
     * Initializes the store with predefined products by adding them to the inventory.
     */
    public void initializeStore() {
    	// Create instances of Weapon, Armor, and Health
        Weapon weapon1 = new Weapon("Sword", "A sharp sword", 49.99, 10, 20);
        Weapon weapon2 = new Weapon("Axe", "A powerful axe", 59.99, 8, 25);
        
        Armor armor1 = new Armor("Steel Armor", "Durable steel armor", 99.99, 5, 30);
        Armor armor2 = new Armor("Leather Armor", "Light leather armor", 39.99, 15, 15);
        
        Health health1 = new Health("Health Potion", "Restores health", 9.99, 30, 50);
        Health health2 = new Health("Elixir", "Powerful healing elixir", 19.99, 20, 100);
        
        // Adding the instances to the inventory
        addToInventory(weapon1);
        addToInventory(weapon2);
        addToInventory(armor1);
        addToInventory(armor2);
        addToInventory(health1);
        addToInventory(health2);
    }

    /**
     * This method retrieves the current inventory of salable products.
     * @return A list of SalableProduct objects representing the current inventory.
     */
    public List<SalableProduct> getInventory() {
        return inventory;
    }

    /**
     * This method adds a SalableProduct to the inventory.     *
     * @param product The SalableProduct to be added to the inventory.
     */
    public void addToInventory(SalableProduct product) {
        inventory.add(product);
    }
}
