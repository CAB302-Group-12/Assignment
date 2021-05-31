package History;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 * This version uses an HistoryInfoDataSource and its methods to retrieve data
 */
public class HistoryInfoData {

    DefaultListModel listModel;

    HistoryInfoDataSource historyData;

    /**
     * Constructor initializes the list model that holds names as Strings and
     * attempts to read any data saved from previous invocations of the
     * application.
     *
     */
    public HistoryInfoData(HistoryInfoDataSource dataSource) {
        listModel = new DefaultListModel();
        historyData = dataSource;

        // add the retrieved data to the list model
        for (String name : historyData.nameSet()) {
            listModel.addElement(name);
        }
    }

    /**
     * Adds a person to the address book.
     *
     * @param h A History to add to the address book.
     */
    public void add(History h) {

        // check to see if the person is already in the book
        // if not add to the address book and the list model
        if (!listModel.contains(h.getAssetname())) {
            listModel.addElement(h.getAssetname());
            historyData.addHistory(h);
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
        historyData.deleteHistory((String) key);
    }

    /**
     * Saves the data in the address book using a persistence
     * mechanism.
     */
    public void persist() {
        historyData.close();
    }

    /**
     * Retrieves Person details from the model.
     *
     * @param key the name to retrieve.
     * @return the Person object related to the name.
     */
    public History get(Object key) {
        return historyData.getHistory((String) key);
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
        return historyData.getSize();
    }
}
