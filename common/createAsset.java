import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class createAsset extends JFrame {
    public static class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showConfirmDialog((Component) e.getSource(), "Are you sure to create?");

        }
    }
    public static void main(String[] args){
        //Create new JFrame "Create Asset"
        JFrame jframe = new JFrame("Create Asset");

        //Create new JPanel
        JPanel panel = new JPanel();

        //Create the button 1 "Create" and set it location
        JButton button1 = new JButton("Create");
        button1.setBounds(370,280,100,40);
        panel.add(button1);

        //Create button listener
        button1.addActionListener(new ButtonListener());

        //Create the button 2 "Cancel" and set it location
        JButton button2 = new JButton("Cancel");
        button2.setBounds(80,280,100,40);
        panel.add(button2);

        //Create the label and set it location
        JLabel label1 = new JLabel("Organization");
        label1.setBounds(0,0,200,50);
        panel.add(label1);

        JLabel label2 = new JLabel("Asset Name");
        label2.setBounds(1,40,200,50);
        panel.add(label2);

        JLabel label3 = new JLabel("Asset Category");
        label3.setBounds(1,80,200,50);
        panel.add(label3);

        JLabel label4 = new JLabel("Asset Price");
        label4.setBounds(1,120,200,50);
        panel.add(label4);

        JLabel label5 = new JLabel("Asset Quantity");
        label5.setBounds(1,160,200,50);
        panel.add(label5);

        JLabel label6 = new JLabel("Description");
        label6.setBounds(1,200,200,50);
        panel.add(label6);

        //Create text field to input the information
        JTextField text1 = new JTextField();
        text1.setBounds(110,15,140,20);
        panel.add(text1);

        JTextField text2 = new JTextField();
        text2.setBounds(110,55,140,20);
        panel.add(text2);

        JTextField text3 = new JTextField();
        text3.setBounds(110,95,140,20);
        panel.add(text3);

        JTextField text4 = new JTextField();
        text4.setBounds(110,135,140,20);
        panel.add(text4);

        JTextField text5 = new JTextField();
        text5.setBounds(110,175,140,20);
        panel.add(text5);

        JTextArea text6 = new JTextArea();
        text6.setBounds(110,215,250,40);
        panel.add(text6);

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
