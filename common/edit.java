import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class edit extends JFrame {
    public static class ButtonListener1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showConfirmDialog((Component) e.getSource(), "Are you sure to remove?");
        }
    }
    public static class ButtonListener2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog((Component) e.getSource(), "Edit Successful");
        }
    }
        public static void main(String[] args) {
            //Create new JFrame "Edit Asset"
            JFrame jframe = new JFrame("Edit Asset");

            //Create new JPanel
            JPanel panel = new JPanel();

            //Create the button 1, button 2 and button 3
            JButton button1 = new JButton("Cancel");
            button1.setBounds(40, 250, 100, 40);
            panel.add(button1);
            JButton button2 = new JButton("Remove");
            button2.setBounds(225, 250, 100, 40);
            panel.add(button2);
            JButton button3 = new JButton("Edit");
            button3.setBounds(400, 250, 100, 40);
            panel.add(button3);

            //Create button listener
            button2.addActionListener(new ButtonListener1());
            button3.addActionListener(new ButtonListener2());

            //Create a table to edit one or some assets
            String[] columnNames = {"Name", "Category", "Price", "Quantity", "Description"};
            //data of "Name", "Category", "Price", "Quantity" and "Description"
            String[][] data = {
                    {"Name1", "Asset1", "$123", "5", "null"},
                    {"Name2", "Asset2", "$123", "10", "null"},
                    {"Name3", "Asset3", "$123", "15", "null"},
                    {"Name4", "Asset4", "$123", "20", "null"},
                    {"Name5", "Asset5", "$123", "25", "null"}
            };
            JTable table = new JTable(data, columnNames);

            //Create scroll pane of table and set it
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(0, 0, 550, 210);
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

