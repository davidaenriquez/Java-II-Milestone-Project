/**
 * David Enriquez
 * CST-239
 * Assignment: CST-239 MilestoneProject
 * January 10, 2023
 * Citations(s):
 * Grand Canyon University CST-239 Milestone Guide
 */
package app;

/**
 * The Health class represents a health-related salable product that extends SalableProduct.
 * It contains properties and methods specific to health products.
 */
public class Health extends SalableProduct {
	// Properties
    private int healingPower; // Represents the healing power of the health product

    /**
     * Constructor for creating a Health object with specified attributes.
     * @param name The name of the health product.
     * @param description The description of the health product.
     * @param price The price of the health product.
     * @param quantity The quantity available of the health product.
     * @param healingPower The healing power of the health product.
     */
    public Health(String name, String description, double price, int quantity, int healingPower) {
        super(); // Calls the constructor of the superclass (SalableProduct)
        this.setName(name); // Sets the name of the health product
        this.setDescription(description); // Sets the description of the health product
        this.setPrice(price); // Sets the price of the health product
        this.setQuantity(quantity); // Sets the quantity available of the health product
        this.healingPower = healingPower; // Assigns the healing power of the health product
    }

    /**
     * Retrieves the healing power of the health product.
     * @return The healing power of the health product.
     */
    public int getHealingPower() {
        return healingPower; // Returns the healing power of the health product
    }

    /**
     * Sets the healing power of the health product.
     * @param healingPower The healing power to set for the health product.
     */
    public void setHealingPower(int healingPower) {
        this.healingPower = healingPower; // Updates the healing power of the health product
    }
}