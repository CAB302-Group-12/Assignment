import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class history extends JFrame{

    public history(){
        initComponents();

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                closeFrame();
            }

        });
        setTitle("Create History");
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void closeFrame() {
        this.dispose();
    }

    private void initComponents() {

        /**
         * Create the button "Back"
         */
        JButton button = new JButton("Back");
        button.setBounds(40, 250, 100, 40);

        /**
         * Create a table to edit one or some assets
         *
         * @param OrderNumber
         * @param Organization
         * @param Buyer
         * @param Category
         * @param Quantity
         * @param Price
         */
        String[] columnNames = { "OrderNum", "Organization", "Buyer", "Category", "Quantity", "Price" };

        String[][] data = {
                { null, null, null, null, null, null },
                { null, null, null, null, null, null },
                { null, null, null, null, null, null },
                { null, null, null, null, null, null },
                { null, null, null, null, null, null }
        };
        JTable table = new JTable(data, columnNames);

        /**
         * Create scroll pane of table and set it
         */
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 550, 210);
        scrollPane.setViewportView(table);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(scrollPane, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(button))

        );

        layout.setVerticalGroup(layout.createSequentialGroup().addComponent(scrollPane)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(button))
                .addContainerGap());
        pack();
    }

    public static void main(String[] args) {
        new history();
    }
}
