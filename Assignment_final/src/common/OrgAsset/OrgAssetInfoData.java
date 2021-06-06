package common.OrgAsset;

import javax.swing.*;

/**
 * This version uses an OrgAssetInfoDataSource and its methods to retrieve data
 */
public class OrgAssetInfoData {

    DefaultListModel listModel;

    public OrgAssetInfoDataSource organizationData;

    /**
     * Constructor initializes the list model that holds names as Strings and
     * attempts to read any data saved from previous invocations of the
     * application.
     *
     */
    public OrgAssetInfoData(OrgAssetInfoDataSource dataSource) {
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
     * @param o A OrgAsset to add to the address book.
     */
    public void add(OrgAsset o) {

        // check to see if the person is already in the book
        // if not add to the address book and the list model
        if (!listModel.contains(o.getAssetname())) {
            listModel.addElement(o.getAssetname());
            organizationData.addOrganization(o);
        }  else if (!listModel.contains(o.getUnitname())) {
            organizationData.addOrganization(o);
        }  else if (!listModel.contains(o.getAssetquantity())) {
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
    public OrgAsset get(Object key) {
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
