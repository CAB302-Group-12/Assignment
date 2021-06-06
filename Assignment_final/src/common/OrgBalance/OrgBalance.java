package common.OrgBalance;

import java.io.Serializable;

/**
 * Stores details for an OrgBalance.
 *
 * @author Malcolm Corney
 * @version $Id: Exp $
 */
public class OrgBalance implements Comparable<OrgBalance>, Serializable {

    private static final long serialVersionUID = 332082608397623483L;

    private String unitname;

    private String credit;

 
    /**
     * No args constructor.
     */
    public OrgBalance() {}

    /**
     * Constructor to set values for the Person's details.
     * @param unitname
     * @param credit
     */
    public OrgBalance(String unitname, String credit) {
        this.unitname = unitname;
        this.credit= credit;
    }

    /**
     * @return the unitname
     */
    public String getUnitname() {return unitname;}

    /**
     * @param unitname the unitname to set
     */
    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    /**
     * @return the credit
     */
    public String getCredit() {return credit;}

    /**
     * @param credit the credit to set
     */
    public void setCredit(String credit) {this.credit = credit;}

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
    public int compareTo(OrgBalance other) {
        return this.unitname.compareTo(other.unitname);
    }

    /**
     * @see Object#toString()
     */
    public String toString() {
        return unitname + " " + credit ;
    }

}
