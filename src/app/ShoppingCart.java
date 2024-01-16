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
 * This ShoppingCart class represents a shopping cart
 * object that manages SalableProduct items.
 */
public class ShoppingCart {
	// Here we declare a private field cartItems
	// of type List<SalableProduct> to hold the items in the shopping cart.
    private List<SalableProduct> cartItems;

    /**
     * Constructor for ShoppingCart initializing the cartItems as an ArrayList.
     */
    public ShoppingCart() {
        cartItems = new ArrayList<>();
    }
    
    /**
     * Adds a SalableProduct item to the cart.
     * @param product The SalableProduct to be added to the cart.
     */
    public void addProduct(SalableProduct product) {
    	// This method addProduct adds a SalableProduct item
    	// to the cartItems list and prints a message confirming the addition.
        cartItems.add(product);
        System.out.println(product.getName() + " added to cart.");
    }

    /**
     * Removes a SalableProduct item from the cart.
     * @param product The SalableProduct to be removed from the cart.
     */
    public void removeProduct(SalableProduct product) {
    	// This method removeProduct removes a SalableProduct item
    	// from the cartItems list if it exists, otherwise, it prints
    	// a message indicating the product was not found.
        if (cartItems.contains(product)) {
            cartItems.remove(product);
            System.out.println(product.getName() + " removed from cart.");
        } else {
            System.out.println("Product not found in cart.");
        }
    }

    /**
     * Displays the contents of the cart.
     * If the cart is empty, it prints a message indicating an empty cart.
     */
    public void viewCart() {
    	// This method viewCart method displays the items in the
    	// cart. It checks if the cart is empty and prints either
    	// a message indicating an empty cart or lists the products
    	// and their positions in the cart.
        if (cartItems.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Your current cart contains:");
            for (int i = 0; i < cartItems.size(); i++) {
                System.out.println((i + 1) + ". " + cartItems.get(i).getName());
            }
        }
    }

    /**
     * Retrieves a SalableProduct from the cart based on the provided index.
     * @param index The index of the product in the cart.
     * @return The SalableProduct at the specified index.
     */
    public SalableProduct getProduct(int index) {
    	// This method getProduct retrieves a SalableProduct
    	// from the cart based on the provided index. If the
    	// index is valid, it returns the product, otherwise, it returns null.
        if (index >= 0 && index < cartItems.size()) {
            return cartItems.get(index);
        }
        return null;
    }

    /**
     * Retrieves the number of items in the cart.
     * @return The number of items in the cart.
     */
    public int getCartSize() {
        return cartItems.size();
    }
    
    /**
     * Returns the contents of the shopping cart.
     * @return A list of SalableProduct objects representing the contents of the cart.
     */
    public List<SalableProduct> returnCartContents() {
        return cartItems;
    }
    
    /**
     * Empties the contents of the shopping cart.
     */
    public void emptyCart() {
        cartItems.clear();
    }
}