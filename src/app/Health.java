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
 *
 * @param <T> Type of the Health product.
 */
public class Health<T extends Comparable<T>> extends SalableProduct<T> {
    // Properties
    private int healingPower; // Represents the healing power of the health product

    /**
     * Constructor for creating a Health object with specified attributes.
     *
     * @param name          The name of the health product.
     * @param description   The description of the health product.
     * @param price         The price of the health product.
     * @param quantity      The quantity available of the health product.
     * @param healingPower  The healing power of the health product.
     */
    public Health(T name, String description, double price, int quantity, int healingPower) {
        super();
        this.setName(name);
        this.setDescription(description);
        this.setPrice(price);
        this.setQuantity(quantity);
        this.healingPower = healingPower;
    }

    /**
     * Retrieves the healing power of the health product.
     *
     * @return The healing power of the health product.
     */
    public int getHealingPower() {
        return healingPower;
    }

    /**
     * Sets the healing power of the health product.
     *
     * @param healingPower The healing power to set for the health product.
     */
    public void setHealingPower(int healingPower) {
        this.healingPower = healingPower;
    }
}