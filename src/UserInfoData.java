package common;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 * This version uses an UserInfoDataSource and its methods to retrieve data
 */
public class UserInfoData {

   DefaultListModel listModel;

   UserInfoDataSource userData;

   /**
    * Constructor initializes the list model that holds names as Strings and
    * attempts to read any data saved from previous invocations of the
    * application.
    *
    */
   public UserInfoData(UserInfoDataSource dataSource) {
      listModel = new DefaultListModel();
      userData = dataSource;

      // add the retrieved data to the list model
      for (String name : userData.nameSet()) {
         listModel.addElement(name);
      }
   }

   /**
    * Adds a person to the address book.
    *
    * @param u A User to add to the address book.
    */
   public void add(User u) {

      // check to see if the person is already in the book
      // if not add to the address book and the list model
      if (!listModel.contains(u.getName())) {
         listModel.addElement(u.getName());
         userData.addUser(u);
      }
   }

   /**
    * Based on the name of the person in the address book, delete the person.
    *
    * @param key
    */
   public void remove(Object key) {

      // remove from both list and map
      listModel.removeElement(key);
      userData.deleteUser((String) key);
   }

   /**
    * Saves the data in the address book using a persistence
    * mechanism.
    */
   public void persist() {
      userData.close();
   }

   /**
    * Retrieves Person details from the model.
    *
    * @param key the name to retrieve.
    * @return the Person object related to the name.
    */
   public User get(Object key) {
      return userData.getUser((String) key);
   }

   /**
    * Accessor for the list model.
    *
    * @return the listModel to display.
    */
   public ListModel getModel() {
      return listModel;
   }

   /**
    * @return the number of names in the Address Book.
    */
   public int getSize() {
      return userData.getSize();
   }
}
