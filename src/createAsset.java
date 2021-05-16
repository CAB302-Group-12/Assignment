import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class createAsset extends JFrame {
    public static void main(String[] args){
        //Create new JFrame "Create Asset"
        JFrame jframe = new JFrame("Create Asset");

        //Create new JPanel
        JPanel panel = new JPanel();

        //Create the button 1 "Create" and set it location
        JButton button1 = new JButton("Create");
        button1.setBounds(370,280,100,40);
        panel.add(button1);

        //Create the button 2 "Cancel" and set it location
        JButton button2 = new JButton("Cancel");
        button2.setBounds(80,280,100,40);
        panel.add(button2);

        //Create the label and set it location
        JLabel label = new JLabel("Create your asset:");
        label.setBounds(1,0,200,50);
        panel.add(label);

        //Create a table to create one or some assets
        String[]columnNames = {"Name", "Category", "Price", "Quantity", "Description"};
        //data of "Name", "Category", "Price", "Quantity" and "Description"
        String[][] data = {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
        };
        JTable table = new JTable(data, columnNames);
        //Set enable to select one item of table
        table.setCellSelectionEnabled(true);
        ListSelectionModel select= table.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Set enable to edit the data of table
        table.setEditingRow(10);

        //Create scroll pane of table and set it
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,40,550,210);
        scrollPane.setViewportView(table);
        panel.add(scrollPane);
        panel.setLayout(null);

        //Set a border to the page
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
