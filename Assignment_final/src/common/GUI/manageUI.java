package common.GUI;

import common.*;
import common.Asset.Asset;
import common.Asset.AssetInfoData;
import common.OrgAsset.OrgAsset;
import common.OrgAsset.OrgAssetFileDataSource;
import common.OrgAsset.OrgAssetInfoData;
import common.User.User;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Initiates asset interface for the AssetInfo application. All listeners for
 * the application are included as inner classes of this class.
 *
 * @author Malcolm Corney
 * @version $Id: Exp $
 *
 */
public class manageUI extends BaseFrame {

    private static final long serialVersionUID = -5050538890770582361L;

    private JList nameList;

    private JTextField name;

    private JTextField category;

    private JTextField price;

    private JTextField quantity;

    private JTextField description;

    private JTextField organization;

    /**private JButton newButton;*/

    private JButton editButton;

    private JButton saveButton;

    private JButton deleteButton;

    AssetInfoData data;
    OrgAssetInfoData orgAssetInfoData;

    /**
     * Constructor sets up asset interface, adds listeners and displays.
     *
     * @param data The underlying data/model class the UI needs.
     */
    public manageUI(AssetInfoData data, User user) {
        this.data = data;
        super.loginUser = user;
        orgAssetInfoData = new OrgAssetInfoData(new OrgAssetFileDataSource());
        initUI();
        checkListSize();

        // add listeners to interactive components
        addButtonListeners(new ButtonListener());
        addNameListListener(new NameListListener());
        addClosingListener(new ClosingListener());

        // decorate the frame and make it visible
        setTitle("Manage Asset");
        setMinimumSize(new Dimension(700, 700));
        showCenter();
        pack();
        setVisible(true);

    }

    /**
     * Places the detail panel and the button panel in a box layout with vertical
     * alignment and puts a 20 pixel gap between the components and the top and
     * bottom edges of the frame.
     */
    private void initUI() {



        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));


        contentPane.add(Box.createVerticalStrut(20));
        contentPane.add(makeDetailsPanel());
        contentPane.add(Box.createVerticalStrut(20));
        contentPane.add(makeButtonsPanel());
        contentPane.add(Box.createVerticalStrut(20));
    }

    /**
     * Makes a JPanel consisiting of (1) the list of names and (2) the address
     * fields in a box layout with horizontal alignment and puts a 20 pixel gap
     * between the components and the left and right edges of the panel.
     *
     * @return the detail panel.
     */
    private JPanel makeDetailsPanel() {
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.X_AXIS));
        detailsPanel.add(Box.createHorizontalStrut(20));
        detailsPanel.add(makeNameListPane());
        detailsPanel.add(Box.createHorizontalStrut(20));
        detailsPanel.add(makeAddressFieldsPanel());
        detailsPanel.add(Box.createHorizontalStrut(20));
        return detailsPanel;
    }

    /**
     * Makes a JScrollPane that holds a JList for the list of names in the
     * address book.
     *
     * @return the scrolling name list panel
     */
    private JScrollPane makeNameListPane() {
        DefaultListModel listModel = new DefaultListModel();
        for (String name : data.assetData.nameSet()) {
            if (data.get(name).getOrganization()!= null && data.get(name).getOrganization().equals(loginUser.getOrganization())){
                listModel.addElement(name);
            }
        }
        nameList = new JList(listModel);
        nameList.setFixedCellWidth(500);

        JScrollPane scroller = new JScrollPane(nameList);
        scroller.setViewportView(nameList);
        scroller
                .setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroller
                .setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setMinimumSize(new Dimension(500, 500));
        scroller.setPreferredSize(new Dimension(500, 500));
        scroller.setMaximumSize(new Dimension(500, 500));

        return scroller;
    }

    /**
     * Makes a JPanel containing labels and textfields for each of the pieces of
     * data that are to be recorded for each address. The labels and fields are
     * layed out using a GroupLayout, with the labels vertically grouped, the
     * fields vertically grouped and each label/group pair horizontally grouped.
     *
     * @return a panel containing the address fields
     */
    private JPanel makeAddressFieldsPanel() {
        JPanel addressPanel = new JPanel();
        GroupLayout layout = new GroupLayout(addressPanel);
        addressPanel.setLayout(layout);

        // Turn on automatically adding gaps between components
        layout.setAutoCreateGaps(true);

        // Turn on automatically creating gaps between components that touch
        // the edge of the container and the container.
        layout.setAutoCreateContainerGaps(true);

        JLabel nameLabel = new JLabel("Name");
        JLabel categoryLabel = new JLabel("category");
        JLabel priceLabel = new JLabel("price");
        JLabel quantityLabel = new JLabel("quantity");
        JLabel descriptionLabel = new JLabel("description");
        JLabel organizationLabel = new JLabel("organization");

        name = new JTextField(20);
        category = new JTextField(20);
        price = new JTextField(20);
        quantity = new JTextField(20);
        description = new JTextField(40);
        organization = new JTextField(40);
        setFieldsEditable(false);

        // Create a sequential group for the horizontal axis.
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

        // The sequential group in turn contains two parallel groups.
        // One parallel group contains the labels, the other the text fields.
        hGroup.addGroup(layout.createParallelGroup().addComponent(nameLabel)
                .addComponent(categoryLabel).addComponent(priceLabel).addComponent(
                        quantityLabel).addComponent(descriptionLabel));
        hGroup.addGroup(layout.createParallelGroup().addComponent(name)
                .addComponent(category).addComponent(price).addComponent(quantity)
                .addComponent(description));
        layout.setHorizontalGroup(hGroup);

        // Create a sequential group for the vertical axis.
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

        // The sequential group contains five parallel groups that align
        // the contents along the baseline. The first parallel group contains
        // the first label and text field, and the second parallel group contains
        // the second label and text field etc. By using a sequential group
        // the labels and text fields are positioned vertically after one another.
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
                .addComponent(nameLabel).addComponent(name));

        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
                .addComponent(categoryLabel).addComponent(category));
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
                .addComponent(priceLabel).addComponent(price));
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
                .addComponent(quantityLabel).addComponent(quantity));
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
                .addComponent(descriptionLabel).addComponent(description));
        layout.setVerticalGroup(vGroup);

        return addressPanel;
    }

    /**
     * Adds the New, Save and Delete buttons to a panel
     */
    private JPanel makeButtonsPanel() {

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        /**newButton = new JButton("New");*/
        editButton = new JButton("Edit");
        saveButton = new JButton("Save");
        saveButton.setEnabled(false);
        deleteButton = new JButton("Delete");
        /**buttonPanel.add(Box.createHorizontalStrut(50));
        buttonPanel.add(newButton);*/
        buttonPanel.add(Box.createHorizontalStrut(50));
        buttonPanel.add(editButton);
        buttonPanel.add(Box.createHorizontalStrut(50));
        buttonPanel.add(saveButton);
        buttonPanel.add(Box.createHorizontalStrut(50));
        buttonPanel.add(deleteButton);
        buttonPanel.add(Box.createHorizontalStrut(50));
        return buttonPanel;
    }

    /**
     * Adds a listener to the new, save and delete buttons
     */
    private void addButtonListeners(ActionListener listener) {
        /**newButton.addActionListener(listener);*/
        editButton.addActionListener(listener);
        saveButton.addActionListener(listener);
        deleteButton.addActionListener(listener);
    }

    /**
     * Adds a listener to the name list
     */
    private void addNameListListener(ListSelectionListener listener) {
        nameList.addListSelectionListener(listener);
    }

    /**
     * Adds a listener to the JFrame
     */
    private void addClosingListener(WindowListener listener) {
        addWindowListener(listener);
    }

    /**
     * Sets the text in the address text fields to the empty string.
     */
    private void clearFields() {
        name.setText("");
        category.setText("");
        price.setText("");
        quantity.setText("");
        description.setText("");
        organization.setText("");
    }

    /**
     * Sets whether or not the address fields are editable.
     */
    private void setFieldsEditable(boolean editable) {
        name.setEditable(editable);
        category.setEditable(editable);
        price.setEditable(editable);
        quantity.setEditable(editable);
        description.setEditable(editable);
        organization.setEditable(editable);
    }

    /**
     * Displays the details of a Person in the address fields.
     * @param asset teh Person to display.
     */
    private void display(Asset asset) {
        if (asset != null) {
            name.setText(asset.getName());
            category.setText(asset.getCategory());
            price.setText(asset.getPrice());
            quantity.setText(asset.getQuantity());
            description.setText(asset.getDescription());
        }
    }

    /**
     * Checks size of data/model and enables/disables the delete button
     *
     */
    private void checkListSize() {
        deleteButton.setEnabled(data.getSize() != 0);
    }

    /**
     * Handles events for the three buttons on the UI.
     *
     * @author Malcolm Corney
     * @version $Id: Exp $
     *
     */
    private class ButtonListener implements ActionListener {

        /**
         * @see ActionListener#actionPerformed(ActionEvent)
         */
        public void actionPerformed(ActionEvent e) {
            int size = data.getSize();

            JButton source = (JButton) e.getSource();
            if (source == editButton) {
                editPressed();
            }  else if (source == saveButton) {
                savePressed();
            } else if (source == deleteButton) {
                deletePressed();
            }
        }

        /**
         * When the new button is pressed, clear the field display, make them
         * editable and enable the save button.
         */
        /**private void newPressed() {
            clearFields();
            setFieldsEditable(true);
            saveButton.setEnabled(true);
        }*/

        /**
         * When the edit button is pressed,
         */

        private void editPressed() {

            setFieldsEditable(true);
            if (name.getText() != null && !name.getText().equals("")) {
                Asset a = new Asset(name.getText(), category.getText(), price
                        .getText(), quantity.getText(), description.getText(),loginUser.getOrganization());
                data.add(a);
            }

            saveButton.setEnabled(true);
        }
        /**
         * When the save button is pressed, check that the name field contains
         * something. If it does, create a new Person object and attempt to add it
         * to the data model. Change the fields back to not editable and make the
         * save button inactive.
         *
         * Check the list size to see if the delete button should be enabled.
         */
        private void savePressed() {
            if (name.getText() != null && !name.getText().equals("")) {
                Asset a = new Asset(name.getText(), category.getText(), price
                        .getText(), quantity.getText(), description.getText(), loginUser.getOrganization());
                data.add(a);
            }
            setFieldsEditable(false);
            saveButton.setEnabled(false);
            checkListSize();
        }

        /**
         * When the delete button is pressed remove the selected name from the
         * data model.
         *
         * Clear the fields that were displayed and check to see if the delete
         * button should be displayed.
         *
         * The index here handles cases where the first element of the list is
         * deleted.
         */
        private void deletePressed() {
            int index = nameList.getSelectedIndex();
            Asset asset = data.get(nameList.getSelectedValue());
            String quantity = asset.getQuantity();
            OrgAsset orgAsset = orgAssetInfoData.get(nameList.getSelectedValue());
            int newQ = Integer.parseInt(orgAsset.getAssetquantity()) + Integer.parseInt(quantity);
            orgAsset.setAssetquantity(String.valueOf(newQ));
            orgAssetInfoData.remove(nameList.getSelectedValue());
            orgAssetInfoData.add(orgAsset);
            orgAssetInfoData.persist();

            data.remove(nameList.getSelectedValue());
            clearFields();
            index--;
            if (index == -1) {
                if (data.getSize() != 0) {
                    index = 0;
                }
            }
            nameList.setSelectedIndex(index);
            checkListSize();
        }
    }

    /**
     * Implements a ListSelectionListener for making the UI respond when a
     * different name is selected from the list.
     */
    private class NameListListener implements ListSelectionListener {

        /**
         * @see ListSelectionListener#valueChanged(ListSelectionEvent)
         */
        public void valueChanged(ListSelectionEvent e) {
            if (nameList.getSelectedValue() != null
                    && !nameList.getSelectedValue().equals("")) {
                display(data.get(nameList.getSelectedValue()));
            }
        }
    }

    /**
     * Implements the windowClosing method from WindowAdapter/WindowListener to
     * persist the contents of the data/model.
     */
    private class ClosingListener extends WindowAdapter {

        /**
         * @see WindowAdapter#windowClosing(WindowEvent)
         */
        public void windowClosing(WindowEvent e) {
            data.persist();
        }
    }




}
