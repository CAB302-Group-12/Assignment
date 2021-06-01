package com.computer.trading.client.ui.model;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.computer.trading.common.beans.Asset;

/**
 * This version uses an AssetInfoDataSource and its methods to retrieve data
 */
public class AssetInfoData {

    DefaultListModel listModel;

    DefaultTableModel tableModel;

    AssetInfoDataSource assetData;

    /**
     * Constructor initializes the list model that holds names as Strings and
     * attempts to read any data saved from previous invocations of the
     * application.
     *
     */
    public AssetInfoData(AssetInfoDataSource dataSource) {
        listModel = new DefaultListModel();
        assetData = dataSource;

        // add the retrieved data to the list model
        for (String name : assetData.nameSet()) {
            listModel.addElement(name);
        }

        String[] columnName = new String[]{
                "name", "category", "price", "quantity", "description"
        };

        tableModel = new DefaultTableModel(columnName,0){
            boolean[] canEdit = new boolean[]{
                    false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };

        for (String name : assetData.nameSet()) {
            Asset asset = assetData.getAsset(name);
            if (asset instanceof Asset){
                tableModel.addRow(new Object[]{
                        asset.getName(),
                        asset.getCategory(),
                        asset.getPrice(),
                        asset.getQuantity(),
                        asset.getDescription(),
                });
            }

        }
    }

    /**
     * Adds a person to the address book.
     *
     * @param a A Asset to add to the address book.
     */
    public void add(Asset a) {

        // check to see if the person is already in the book
        // if not add to the address book and the list model
        if (!listModel.contains(a.getName())) {
            listModel.addElement(a.getName());
            assetData.addAsset(a);

            tableModel.addRow(new Object[]{a.getName(),a.getCategory(),a.getPrice(),a.getQuantity(),a.getDescription()});
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
        assetData.deleteAsset((String) key);
    }

    /**
     * Saves the data in the address book using a persistence
     * mechanism.
     */
    public void persist() {
        assetData.close();
    }

    /**
     * Retrieves Person details from the model.
     *
     * @param key the name to retrieve.
     * @return the Person object related to the name.
     */
    public Asset get(Object key) {
        return assetData.getAsset((String) key);
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
        return assetData.getSize();
    }
}