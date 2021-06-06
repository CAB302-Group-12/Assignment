package common.OrgAsset;

import java.io.Serializable;

/**
 * Stores details for an OrgAsset.
 *
 * @author Malcolm Corney
 * @version $Id: Exp $
 */
public class OrgAsset implements Comparable<OrgAsset>, Serializable {

    private static final long serialVersionUID = 332082608397623483L;

    private String unitname;

    private String assetname;

    private String assetquantity;

    

    /**
     * No args constructor.
     */
    public OrgAsset() {
    }

    /**
     * Constructor to set values for the Person's details.
     * @param unitname
     * @param assetname
     * * @param assetquantity
     
     */
    public OrgAsset(String unitname, String assetname, String assetquantity) {
        this.unitname = unitname;
        this.assetname = assetname;
        this.assetquantity = assetquantity;


    }



    /**
     * @return the unitname
     */
    public String getUnitname() {
        return unitname;
    }

    /**
     * @param unitname the unitname to set
     */
    public void setUnitname(String unitname) {
        this.unitname = unitname;
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
     * @return the assetquantity
     */
    public String getAssetquantity() { return assetquantity; }

    /**
     * @param assetquantity the assetquantity to set
     */
    public void setAssetquantity(String assetquantity) {
        this.assetquantity = assetquantity;
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
    public int compareTo(OrgAsset other) {
        return this.unitname.compareTo(other.unitname);
    }

    /**
     * @see Object#toString()
     */
    public String toString() {
        return unitname + " "  + assetname + " " + assetquantity;
    }

}
