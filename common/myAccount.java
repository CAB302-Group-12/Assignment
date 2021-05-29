import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class myAccount extends JFrame{

    public static void main(String[] args){
        //Create new JFrame "My Account"
        JFrame jframe = new JFrame("My Account");

        //Create new JPanel
        JPanel panel = new JPanel();

        //Create a label 1 and a label 2
        JLabel label1 = new JLabel("Account Name: User1");
        JLabel label2 = new JLabel("Credit Balance: 12345");


        //Set label 1 and 2 location and size
        label1.setLocation(130,40);
        label1.setSize(150,80);
        panel.add(label1);
        label2.setLocation(130,80);
        label2.setSize(150,80);
        panel.add(label2);

        //Create the button 1 and button 2
        JButton button1 = new JButton("Manage Products");
        JButton button2 = new JButton("Change Password");
        JButton button3 = new JButton("Return");

        //Set the button 1 and 2 of location and size
        button1.setBounds(150,50,150,50);
        button1.setLocation(30,180);
        button2.setBounds(150,50,150,50);
        button2.setLocation(220,180);
        button3.setBounds(0,0, 70, 30);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.setLayout(null);

        //Set a border to the page
        panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

        //Add panel to the jframe
        jframe.getContentPane().add(panel);

        //Set window size
        jframe.setPreferredSize(new Dimension(400, 300));
        //Close the window
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.pack();
        //Set centre to the screen
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);

    }
}
