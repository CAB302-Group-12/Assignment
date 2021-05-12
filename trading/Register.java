package com.trading;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame {

    private JTextField organField;
    private JLabel organLabel;
    private JTextField pwdField;
    private JLabel pwdLabel;
    private JButton registerBtn;
    private JLabel titleJlabel;
    private JTextField usernameField;
    private JLabel usernameLabel;
    
    public Register() {
        initComponents();
    }

    private void initComponents() {

        titleJlabel = new JLabel();
        usernameLabel = new JLabel();
        usernameField = new JTextField();
        pwdLabel = new JLabel();
        pwdField = new JTextField();
        organLabel = new JLabel();
        organField = new JTextField();
        registerBtn = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(370, 400));

        titleJlabel.setFont(new Font("Microsoft JhengHei", 1, 18));
        titleJlabel.setText("Register");

        usernameLabel.setFont(new Font("Microsoft JhengHei", 0, 18));
        usernameLabel.setText("Username");

        usernameField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });

        pwdLabel.setFont(new Font("Microsoft JhengHei", 0, 18));
        pwdLabel.setText("Password");

        pwdField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                pwdFieldActionPerformed(evt);
            }
        });

        organLabel.setFont(new Font("Microsoft JhengHei", 0, 18));
        organLabel.setText("Organization");

        organField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                organFieldActionPerformed(evt);
            }
        });

        registerBtn.setBackground(new Color(153, 204, 255));
        registerBtn.setText("Register!");
        registerBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(usernameLabel)
                                                        .addComponent(pwdLabel)
                                                        .addComponent(organLabel)
                                                        .addComponent(usernameField, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                                        .addComponent(pwdField)
                                                        .addComponent(organField)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(152, 152, 152)
                                                .addComponent(titleJlabel))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(130, 130, 130)
                                                .addComponent(registerBtn, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titleJlabel)
                                .addGap(41, 41, 41)
                                .addComponent(usernameLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pwdLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pwdField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(organLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(organField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(registerBtn, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }

    private void usernameFieldActionPerformed(ActionEvent evt) {
        
    }

    private void pwdFieldActionPerformed(ActionEvent evt) {
        
    }

    private void organFieldActionPerformed(ActionEvent evt) {
       
    }

    private void registerBtnActionPerformed(ActionEvent evt) {
        
    }


    public static void main(String args[]) {
         new Register().setVisible(true);
    }

}
