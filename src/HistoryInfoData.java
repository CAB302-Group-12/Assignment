package common;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 * This version uses an HistoryInfoDataSource and its methods to retrieve data
 */
public class HistoryInfoData {

    DefaultListModel listModel;

    DefaultTableModel tableModel;

    HistoryInfoDataSource historyData;

    User user;

    /**
     * Constructor initializes the list model that holds names as Strings and
     * attempts to read any data saved from previous invocations of the
     * application.
     *
     */
    public HistoryInfoData(HistoryInfoDataSource dataSource,User loginUser) {
        listModel = new DefaultListModel();
        historyData = dataSource;

        // add the retrieved data to the list model
        for (String name : historyData.nameSet()) {
            listModel.addElement(name);
        }


    String[] columnName = new String[]{
            "assetname", "assetcategory", "assetquantity", "tradetype", "organization"
    };

    tableModel = new DefaultTableModel(columnName,0){
        boolean[] canEdit = new boolean[]{
                false, false, false, true, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit[columnIndex];
        }
    };

        for (String name : historyData.nameSet()) {
        History history = historyData.getHistory(name);
        if (history instanceof History){
            if (loginUser != null){
                if (loginUser.getOrganization() != null && loginUser.getOrganization().equals(history.getOrganization())){
                    tableModel.addRow(new Object[]{
                            history.getAssetname(),
                            history.getAssetcategory(),
                            history.getAssetquantity(),
                            history.getTradetype(),
                            history.getOrganization(),

                    });
                }
            }else{
                tableModel.addRow(new Object[]{
                        history.getAssetname(),
                        history.getAssetcategory(),
                        history.getAssetquantity(),
                        history.getTradetype(),
                        history.getOrganization(),

                });
            }
        }

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
        listModel.addElement(h.getAssetname());
        historyData.addHistory(h);
        tableModel.addRow(new Object[]{h.getAssetname(),h.getAssetcategory(),h.getAssetquantity(),h.getTradetype(),h.getOrganization()});
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

    public TableModel getTableModel() {
        return tableModel;
    }

    /**
     * @return the number of names in the Address Book.
     */
    public int getSize() {
        return historyData.getSize();
    }
}
