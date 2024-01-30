/**
 * David Enriquez
 * CST-239
 * Assignment: CST-239 MilestoneProject
 * December 20, 2023
 * Citations(s):
 * Grand Canyon University CST-239 Milestone Guide
 */
package app;

/**
 * The class SalableProduct contains instance variables
 * (name, description, price, quantity) representing
 * the properties of a product that can be sold. This
 * class includes getter methods (getName(), getDescription(),
 * getPrice(), getQuantity()) to access the values of these properties.
 * This class also includes setter methods (setName(), setDescription(),
 * setPrice(), setQuantity()) which are included to modify the values of
 * these properties.
 *
 * @param <T> Type of the SalableProduct.
 */
public class SalableProduct<T extends Comparable<T>> {
    // Properties
    private T name;
    private String description;
    private double price;
    private int quantity;

    /**
     * Getter method which returns
     * the name of the product
     * @return returns the name of the product
     */
    public T getName() {
        return name;
    }

    /**
     * Getter method which returns
     * the description of the product
     * @return returns the description of the product
     */
    public String getDescription() {
        return description;
    }

    /**
     * Getter method which returns
     * the price of the product
     * @return returns the price of the product
     */
    public double getPrice() {
        return price;
    }

    /**
     * Getter method which returns
     * the quantity of the product
     * @return returns the quantity of the product
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter method which sets a new
     * name for the product
     * @param newName as parameter
     */
    public void setName(T newName) {
        this.name = newName;
    }

    /**
     * Setter method which sets a new
     * description for the product
     * @param newDescription as parameter
     */
    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    /**
     * Setter method which sets a new
     * price for the product
     * @param newPrice as parameter
     */
    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    /**
     * Setter method which sets a new
     * quantity for the product
     * @param newQuantity as parameter
     */
    public void setQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }
}