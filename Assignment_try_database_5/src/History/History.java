package History;

import java.io.Serializable;

/**
 * Stores details for an History.
 *
 * @author Malcolm Corney
 * @version $Id: Exp $
 */
public class History implements Comparable<History>, Serializable {

    private static final long serialVersionUID = 332082608397623483L;

    private String assetname;

    private String assetcategory;

    private String assetquantity;

    private String tradetype;

    
    
    



    /**
     * No args constructor.
     */
    public History() {
    }

    /**
     * Constructor to set values for the Person's details.
     * @param assetname
     * @param assetcategory
     * @param assetquantity
     * @param tradetype
     

     */
    public History(String assetname, String assetcategory, String assetquantity, String tradetype) {
        this.assetname = assetname;
        this.assetcategory= assetcategory;
        this.assetquantity = assetquantity;
        this.tradetype = tradetype;
        


    }



    /**
     * @return the assetname
     */
    public String getAssetname() {
        return assetname;
    }

    /**
     * @param assetname the assetname to set
     */
    public void setAssetname(String assetname) {
        this.assetname = assetname;
    }


    /**
     * @return the assetcategory
     */
    public String getAssetcategory() {
        return assetcategory;
    }


    /**
     * @param assetcategory the assetcategory to set
     */
    public void setAssetcategory(String assetcategory) {
        this.assetcategory = assetcategory;
    }


    /**
     * @return the assetquantity
     */
    public String getAssetquantity() {
        return assetquantity;
    }

    /**
     * @param assetquantity the assetquantity to set
     */
    public void setAssetquantity(String assetquantity) {
        this.assetquantity = assetquantity;
    }


    /**
     * @return the tradetype
     */
    public String getTradetype() { return tradetype; }

    /**
     * @param tradetype the tradetype to set
     */
    public void setTradetype(String tradetype) {
        this.tradetype = tradetype;
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
    public int compareTo(History other) {
        return this.assetname.compareTo(other.assetname);
    }

    /**
     * @see Object#toString()
     */
    public String toString() {
        return assetname + " " + assetcategory + ", " + assetquantity + " " + tradetype ;
    }

}
