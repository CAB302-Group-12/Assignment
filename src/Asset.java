package Asset;

import java.io.Serializable;

/**
 * Stores details for an asset.
 *
 * @author Malcolm Corney
 * @version $Id: Exp $
 */
public class Asset implements Comparable<Asset>, Serializable {

    private static final long serialVersionUID = 332082608397623483L;

    private String name;

    private String category;

    private String price;

    private String quantity;

    private String description;

    private String organization;

    /**
     * No args constructor.
     */
    public Asset() {
    }

    /**
     * Constructor to set values for the Person's details.
     * @param name
     * @param category
     * @param price
     * @param quantity
     * @param description
     * @param organization
     */
    public Asset(String name, String category, String price, String quantity, String description, String organization) {
        this.name = name;
        this.category= category;
        this.price = price;
        this.quantity = quantity;
        this.description= description;
        this.organization = organization;

    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the quantity
     */
    public String getQuantity() { return quantity; }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the organization
     */
    public String getOrganization() { return organization; }

    /**
     * @param organization the quantity to set
     */
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    /**
     * Compares this object with the specified object for order. Returns a
     * negative integer, zero, or a positive integer as this object is less than,
     * equal to, or greater than the specified object.
     *
     * @param other The other Person object to compare against.
     * @return a negative integer, zero, or a positive integer as this object is
     *         less than, equal to, or greater than the specified object.
     * @throws ClassCastException if the specified object's type prevents it from
     *            being compared to this object.
     */
    public int compareTo(Asset other) {
        return this.name.compareTo(other.name);
    }

    /**
     * @see Object#toString()
     */
    public String toString() {
        return name + " " + category + ", " + price + " " + quantity + " " + description + " " + organization;
    }

}
