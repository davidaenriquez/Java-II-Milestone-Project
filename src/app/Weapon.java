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
 *
 * @param <T> Type of the Weapon.
 */
public class Weapon<T extends Comparable<T>> extends SalableProduct<T> implements Comparable<Weapon<T>> {
    // Properties
    private int damage; // Represents the damage inflicted by the weapon

    /**
     * Constructor method for creating a Weapon
     * object with specified properties.
     *
     * @param name        The name of the weapon.
     * @param description The description of the weapon.
     * @param price       The price of the weapon.
     * @param quantity    The quantity of the weapon available.
     * @param damage      The damage value of the weapon.
     */
    public Weapon(T name, String description, double price, int quantity, int damage) {
        super();
        this.setName(name);
        this.setDescription(description);
        this.setPrice(price);
        this.setQuantity(quantity);
        this.damage = damage;
    }

    /**
     * Getter method which returns
     * the damage value.
     *
     * @return returns the damage value of the weapon.
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Setter method which sets the
     * damage value of the weapon.
     *
     * @param damage The damage value to set.
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
    public int compareTo(Weapon<T> other) {
        // Ensure that the type T has a compareTo method
        if (this.getName() instanceof Comparable && other.getName() instanceof Comparable) {
            return ((Comparable<T>) this.getName()).compareTo(other.getName());
        } else {
            throw new UnsupportedOperationException("compareTo not supported for type T");
        }
    }
}