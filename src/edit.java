import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class edit extends JFrame {
    public edit() {
        initComponents();

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                closeFrame();
            }

        });

        setTitle("Edit");
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void closeFrame() {
        this.dispose();
    }


    private void initComponents() {

        /**
         * Create the table
         */
        JTable table = new JTable();;

        /**
         * Create the button
         */
        JButton button1 = new JButton("Cancel");
        button1.setBounds(40, 250, 100, 40);
        JButton button2 = new JButton("Remove");
        button2.setBounds(80, 250, 100, 40);
        JButton button3 = new JButton("Update");
        button3.setBounds(120, 250, 100, 40);

        /**
         * Create a table to edit one or some assets
         *
         * @param name
         * @param type
         * @param price
         * @param quantity
         * @param organization
         * @param description
         */
        table.setFont(new Font("Microsoft JhengHei", 0, 14));
        table.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                },
                new String[]{
                        "name", "type", "price", "quantity", "organization", "description"
                }
        ){
            boolean[] canEdit = new boolean[]{
                    true,true,true,true,true,true
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        /**
         * Create scroll pane of table and set it
         */
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 550, 210);
        scrollPane.setViewportView(table);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(scrollPane, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(button1)
                        .addGap(90)
                        .addComponent(button2)
                        .addGap(90)
                        .addComponent(button3))
        );

        layout.setVerticalGroup(layout.createSequentialGroup().addComponent(scrollPane)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(button1).addComponent(button2).addComponent(button3))
                .addContainerGap());
        pack();
    }
    public static void main(String[] args) {
        new edit();
    }
}
