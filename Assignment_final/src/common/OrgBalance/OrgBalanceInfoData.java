package common.OrgBalance;

import javax.swing.*;

/**
 * This version uses an OrgBalanceInfoDataSource and its methods to retrieve data
 */
public class OrgBalanceInfoData {

    DefaultListModel listModel;

    public OrgBalanceInfoDataSource organizationData;

    /**
     * Constructor initializes the list model that holds names as Strings and
     * attempts to read any data saved from previous invocations of the
     * application.
     *
     */
    public OrgBalanceInfoData(OrgBalanceInfoDataSource dataSource) {
        listModel = new DefaultListModel();
        organizationData = dataSource;

        // add the retrieved data to the list model
        for (String name : organizationData.nameSet()) {
            listModel.addElement(name);
        }
    }

    /**
     * Adds a person to the address book.
     *
     * @param o A OrgBalance to add to the address book.
     */
    public void add(OrgBalance o) {

        // check to see if the person is already in the book
        // if not add to the address book and the list model
        if (!listModel.contains(o.getUnitname())) {
            listModel.addElement(o.getUnitname());
            organizationData.addOrganization(o);
        }  else if (!listModel.contains(o.getCredit())) {
            organizationData.addOrganization(o);
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
        organizationData.deleteOrganization((String) key);
    }

    /**
     * Saves the data in the address book using a persistence
     * mechanism.
     */
    public void persist() {
        organizationData.close();
    }

    /**
     * Retrieves Person details from the model.
     *
     * @param key the name to retrieve.
     * @return the Person object related to the name.
     */
    public OrgBalance get(Object key) {
        return organizationData.getOrganization((String) key);
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
        return organizationData.getSize();
    }
}
