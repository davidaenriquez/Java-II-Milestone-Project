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
 */
public class Armor extends SalableProduct {
	// Properties
    private int defense; // Represents the defense value of the armor.
    
    /**
     * Constructor method for creating a Armor
     * object with specified properties. 
     * @param name, The name of the armor.
     * @param description, The description of the armor.
     * @param price, The price of the armor.
     * @param quantity, The quantity of the armor available.
     * @param defense, The defense value of the armor.
     */
    public Armor(String name, String description, double price, int quantity, int defense) {
        super(); // We call the constructor method of the superclass (SalableProduct)
        this.setName(name); // Set the name of the armor.
        this.setDescription(description); // Set the description of the armor.
        this.setPrice(price); // Set the price of the armor.
        this.setQuantity(quantity); // Set the quantity of the armor.
        this.defense = defense; // Set the defense value of the armor.
    }
    
    /**
     * Getter method which returns
     * the defense value.
     * @return returns the defense the armor.
     */
    public int getDefense() {
        return defense;
    }
    
    /**
     * Setter method which sets the
     * defense value of the armor.
     * @param defense, The defense value to set.
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }
}