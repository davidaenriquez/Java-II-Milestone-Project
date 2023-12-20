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
        SalableProduct product1 = new SalableProduct();
        product1.setName("Product 1");
        product1.setDescription("This is the first product.");
        product1.setPrice(10.99);
        product1.setQuantity(20);

        SalableProduct product2 = new SalableProduct();
        product2.setName("Product 2");
        product2.setDescription("This is the second product.");
        product2.setPrice(15.99);
        product2.setQuantity(15);

        SalableProduct product3 = new SalableProduct();
        product3.setName("Product 3");
        product3.setDescription("This is the third product.");
        product3.setPrice(19.99);
        product3.setQuantity(30);

        addToInventory(product1);
        addToInventory(product2);
        addToInventory(product3);
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
