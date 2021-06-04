package common;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class CreateInfoData {

    DefaultListModel listModel;

    DefaultTableModel tableModel;

    CreateInfoDataSource createData;

    /**
     * Constructor initializes the list model that holds names as Strings and
     * attempts to read any data saved from previous invocations of the
     * application.
     */
    public CreateInfoData(CreateInfoDataSource dataSource) {
        listModel = new DefaultListModel();
        createData = dataSource;

        // add the retrieved data to the list model
        for (String name : createData.nameSet()) {
            listModel.addElement(name);
        }

        String[] columnName = new String[]{
                "name", "category", "price", "quantity", "organization", "description"
        };

        tableModel = new DefaultTableModel(columnName, 0) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };

        for (String name : createData.nameSet()) {
            Create create = createData.getCreate(name);
            if (create instanceof Create) {
                tableModel.addRow(new Object[]{
                        create.getName(),
                        create.getCategory(),
                        create.getPrice(),
                        create.getQuantity(),
                        create.getOrganization(),
                        create.getDescription(),
                });
            }
        }
    }

    /**
     * Adds a person to the address book.
     *
     * @param c A Create to add to the address book.
     */

    public void add(Create c) {
        // check to see if the person is already in the book
        // if not add to the address book and the list model
        if (!listModel.contains(c.getName())) {
            listModel.addElement(c.getName());
            createData.addCreate(c);

            tableModel.addRow(new Object[]{c.getName(), c.getCategory(), c.getPrice(), c.getQuantity(), c.getOrganization(), c.getDescription()});
        }
    }

    /**
     * Saves the data in the address book using a persistence
     * mechanism.
     */
    public void persist() {
        createData.close();
    }

    /**
     * Retrieves Person details from the model.
     *
     * @param key the name to retrieve.
     * @return the Person object related to the name.
     */
    public Create get(Object key) {
        return createData.getCreate((String) key);
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
        return createData.getSize();
    }
}