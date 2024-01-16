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
 * The Weapon class represents a type of SalableProduct
 * which includes specific properties related to weapons.
 * This Weapon class extends the SalableProduct class.
 */
public class Weapon extends SalableProduct implements Comparable<Weapon> {
	// Properties
    private int damage; // Represents the damage inflicted by the weapon
    
    /**
     * Constructor method for creating a Weapon
     * object with specified properties. 
     * @param name, The name of the weapon.
     * @param description, The description of the weapon.
     * @param price, The price of the weapon.
     * @param quantity, The quantity of the weapon available.
     * @param damage, The damage value of the weapon.
     */
    public Weapon(String name, String description, double price, int quantity, int damage) {
        super(); // We call the constructor method of the superclass
        this.setName(name); // Set the name of the weapon.
        this.setDescription(description); // Set the description of the weapon.
        this.setPrice(price); // Set the price of the weapon.
        this.setQuantity(quantity); // Set the quantity of the weapon.
        this.damage = damage; // Set the damage value of the weapon.
    }

    /**
     * Getter method which returns
     * the damage value.
     * @return returns the damage value of the weapon.
     */
    public int getDamage() {
        return damage;
    }
    
    /**
     * Setter method which sets the
     * damage value of the weapon.
     * @param damage, The damage value to set.
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    /**
     * We are implementing the compareTo method from the
     * Comparable interface for the Weapon class. The
     * Comparable interface in Java is used to define a
     * natural order for a class, allowing instances of
     * that class to be compared and sorted.
     *
     * @param other The Weapon object to compare to.
     * @return returns the result of the comparison based on weapon names.
     */
    @Override
    public int compareTo(Weapon other) {
        return this.getName().compareToIgnoreCase(other.getName());
    }
}