import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class history {
    public static void main(String[] args) {
        /**
         * Create new JFrame "History"
         */
        JFrame jframe = new JFrame("History");

        /**
         * Create new JPanel to use
         */
        JPanel panel = new JPanel();

        /**
         * Create the button "Cancel", button "Remove" and button "Edit"
         * @param button
         */
        JButton button = new JButton("Back");
        button.setBounds(40, 250, 100, 40);
        panel.add(button);

        /**
         * Create a table to edit one or some assets
         * @param OrderNumber
         * @param Organization
         * @param Buyer
         * @param Category
         * @param Quantity
         * @param Price
         */
        String[] columnNames = {"OrderNum", "Organization", "Buyer", "Category", "Quantity", "Price"};

        String[][] data = {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
        };
        JTable table = new JTable(data, columnNames);

        /**
         * Create scroll pane of table and set it
         * @param scrollPane
         */
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 550, 210);
        scrollPane.setViewportView(table);
        panel.add(scrollPane);
        panel.setLayout(null);

        /**
         * Set the border for the jframe
         */
        panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        //Add panel to the jframe
        jframe.getContentPane().add(panel);
        //Set window size
        jframe.setPreferredSize(new Dimension(550, 370));
        //Close the window
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }
}
