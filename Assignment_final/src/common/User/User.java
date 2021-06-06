package common.User;

import java.io.Serializable;

/**
 * Stores details for a user.
 * 
 * @author Malcolm Corney
 * @version $Id: Exp $
 */
public class User implements Comparable<User>, Serializable {

   private static final long serialVersionUID = 332082608397623483L;

   private String name;

   private String email;

   private String password;

   private String usertype;

   private String organization;



   /**
    * No args constructor.
    */
   public User() {
   }

   /**
    * Constructor to set values for the Person's details. 
    * @param name
    * @param email
    * @param password
    * * @param usertype
    * @param organization
    */
   public User(String name, String email, String password, String usertype , String organization ) {
      this.name = name; 
      this.email= email;
      this.password = password;
      this.usertype = usertype;
      this.organization= organization;

   }

   /**
    * @return the email
    */
   public String getEmail() {
      return email;
   }

   /**
    * @param email the email to set
    */
   public void setEmail(String email) {
      this.email = email;
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
    * @return the password
    */
   public String getPassword() {
      return password;
   }

   /**
    * @param password the password to set
    */
   public void setPassword(String password) {
      this.password = password;
   }

   /**
    * @return the organization
    */

   /**
    * @return the usertype
    */
   public String getUsertype() { return usertype; }

   /**
    * @param usertype the usertype to set
    */
   public void setUsertype(String usertype) {
      this.usertype = usertype;
   }


   public String getOrganization() {
      return organization;
   }

   /**
    * @param organization the organization to set
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
   public int compareTo(User other) {
      return this.name.compareTo(other.name);
   }
   
   /**
    * @see Object#toString()
    */
   public String toString() {
      return name + " " + email + ", " + password + " " + usertype + " " + organization;
   }

}
