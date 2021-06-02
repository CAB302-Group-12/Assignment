package Asset;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

/**
 * Initiates asset interface for the AssetInfo application. All listeners for
 * the application are included as inner classes of this class.
 *
 * @author Malcolm Corney
 * @version $Id: Exp $
 *
 */
public class CreateAssetInfoUI extends JFrame {

    private JTextField name;

    private JTextField category;

    private JTextField price;

    private JTextField quantity;

    private JTextField organization;

    private JTextField description;

    private JButton newButton;

    private JButton saveButton;

    AssetInfoData data;

    /**
     * Constructor sets up asset interface, adds listeners and displays.
     *
     * @param data The underlying data/model class the UI needs.
     */
    public CreateAssetInfoUI(AssetInfoData data) {
        this.data = data;
        initUI();

        // add listeners to interactive components
        addButtonListeners(new ButtonListener());
        addClosingListener(new ClosingListener());

        // decorate the frame and make it visible
        setTitle("Asset");
        setMinimumSize(new Dimension(400, 300));
        pack();
        setVisible(true);
    }

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
        detailsPanel.add(Box.createHorizontalStrut(20));
        detailsPanel.add(makeAddressFieldsPanel());
        return detailsPanel;
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
        JLabel categoryLabel = new JLabel("Category");
        JLabel priceLabel = new JLabel("Price");
        JLabel quantityLabel = new JLabel("Quantity");
        JLabel organizationLabel = new JLabel("Organization");
        JLabel descriptionLabel = new JLabel("Description");

        name = new JTextField(20);
        category = new JTextField(20);
        price = new JTextField(20);
        quantity = new JTextField(20);
        organization = new JTextField(20);
        description = new JTextField(40);
        setFieldsEditable(false);

        // Create a sequential group for the horizontal axis.
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

        // The sequential group in turn contains two parallel groups.
        // One parallel group contains the labels, the other the text fields.
        hGroup.addGroup(layout.createParallelGroup().addComponent(nameLabel)
                .addComponent(categoryLabel).addComponent(priceLabel).addComponent(
                        quantityLabel).addComponent(descriptionLabel).addComponent(organizationLabel));
        hGroup.addGroup(layout.createParallelGroup().addComponent(name)
                .addComponent(category).addComponent(price).addComponent(quantity)
                .addComponent(organization).addComponent(description));
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
                .addComponent(organizationLabel).addComponent(organization));
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE)
                .addComponent(descriptionLabel).addComponent(description));
        layout.setVerticalGroup(vGroup);

        return addressPanel;
    }

    /**
     * Adds the New and Save buttons to a panel
     */
    private JPanel makeButtonsPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        newButton = new JButton("New");
        saveButton = new JButton("Save");
        saveButton.setEnabled(false);
        buttonPanel.add(Box.createHorizontalStrut(50));
        buttonPanel.add(newButton);
        buttonPanel.add(Box.createHorizontalStrut(50));
        buttonPanel.add(saveButton);
        //buttonPanel.add(Box.createHorizontalStrut(50));
        return buttonPanel;
    }

    /**
     * Adds a listener to the new, save and delete buttons
     */
    private void addButtonListeners(ActionListener listener) {
        newButton.addActionListener(listener);
        saveButton.addActionListener(listener);
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
        organization.setText("");
        description.setText("");
    }

    /**
     * Sets whether or not the address fields are editable.
     */
    private void setFieldsEditable(boolean editable) {
        name.setEditable(editable);
        category.setEditable(editable);
        price.setEditable(editable);
        quantity.setEditable(editable);
        organization.setEditable(editable);
        description.setEditable(editable);
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
            organization.setText(asset.getOrganization());
            description.setText(asset.getDescription());
        }
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
            if (source == newButton) {
                newPressed();
            } else if (source == saveButton) {
                savePressed();
            }
        }
    }

    /**
     * When the new button is pressed, clear the field display, make them
     * editable and enable the save button.
     */
    private void newPressed() {
        clearFields();
        setFieldsEditable(true);
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
            Asset a = new Asset(name.getText(), category.getText(), price.getText(), quantity.getText(),  organization.getText(), description.getText());
            data.add(a);
        }
        setFieldsEditable(false);
        saveButton.setEnabled(false);
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
            System.exit(0);
        }
    }
}
