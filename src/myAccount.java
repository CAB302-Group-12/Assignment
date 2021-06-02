import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class myAccount extends JFrame{
    public myAccount(){
        initComponents();

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                closeFrame();
            }

        });

        setTitle("My Account");
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void closeFrame() {
        this.dispose();
    }

    private void initComponents(){

        /**
         *  Create a label 1 and a label 2 on panel
         */
        JLabel label1 = new JLabel("Account Name: ");
        JLabel label2 = new JLabel("Credit Balance: ");

        /**
         * Create the button and button 2 on panel
         */
        JButton button1 = new JButton("Manage Products");
        JButton button2 = new JButton("Change Password");
        JButton button3 = new JButton("History");


        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()

                                .addComponent(button1)
                                .addGap(10)
                                .addComponent(button2)
                                .addGap(10)
                                .addComponent(button3))

                        .addGroup(layout.createSequentialGroup()
                                .addGap(50)
                                .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(50)
                                .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

        ));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGap(50)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(label1).addComponent(label2))
                .addGap(50)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(button1).addComponent(button2).addComponent(button3))
                .addContainerGap());
        pack();
    }
    public static void main(String[] args) {
        new myAccount();
    }
}
