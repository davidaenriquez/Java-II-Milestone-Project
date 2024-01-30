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
 * The Armor class represents a type of SalableProduct
 * which includes specific properties related to armor.
 * This Armor class extends the SalableProduct class.
 *
 * @param <T> Type of the Armor.
 */
public class Armor<T extends Comparable<T>> extends SalableProduct<T> {
    // Properties
    private int defense; // Represents the defense value of the armor.

    /**
     * Constructor method for creating an Armor
     * object with specified properties.
     *
     * @param name        The name of the armor.
     * @param description The description of the armor.
     * @param price       The price of the armor.
     * @param quantity    The quantity of the armor available.
     * @param defense     The defense value of the armor.
     */
    public Armor(T name, String description, double price, int quantity, int defense) {
        super();
        this.setName(name);
        this.setDescription(description);
        this.setPrice(price);
        this.setQuantity(quantity);
        this.defense = defense;
    }

    /**
     * Getter method which returns
     * the defense value.
     *
     * @return returns the defense value of the armor.
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Setter method which sets the
     * defense value of the armor.
     *
     * @param defense The defense value to set.
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }
}