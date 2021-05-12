package com.trading;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    private JTextField emailField;
    private JLabel emaliText;
    private JButton loginBtn;
    private JTextField pwdField;
    private JLabel pwdText;
    private JLabel signInLabel;
    private JLabel signText;
    private JLabel subTitleLabel;

    public Login() {
        initComponents();
    }

    private void initComponents() {

        signInLabel = new JLabel();
        subTitleLabel = new JLabel();
        emaliText = new JLabel();
        emailField = new JTextField();
        pwdText = new JLabel();
        pwdField = new JTextField();
        loginBtn = new JButton();
        signText = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(550, 400));

        signInLabel.setFont(new java.awt.Font("Microsoft JhengHei", 1, 24)); // NOI18N
        signInLabel.setText("Sign in");

        subTitleLabel.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        subTitleLabel.setText("Welcome to the trading platform");

        emaliText.setFont(new java.awt.Font("Microsoft JhengHei", 0, 24)); // NOI18N
        emaliText.setText("Email:");

        emailField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });

        pwdText.setFont(new java.awt.Font("Microsoft JhengHei", 0, 24)); // NOI18N
        pwdText.setText("Password:");

        pwdField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                pwdFieldActionPerformed(evt);
            }
        });

        loginBtn.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        loginBtn.setText("Login in");
        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        signText.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        signText.setText("Creat an new account");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(signInLabel, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                .addGap(223, 223, 223))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(156, 156, 156)
                                                .addComponent(subTitleLabel, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(53, 53, 53)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(emaliText, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(44, 44, 44)
                                                                .addComponent(emailField, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(pwdText, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(pwdField, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(loginBtn, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(signText))))))
                                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(signInLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(subTitleLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(emaliText)
                                        .addComponent(emailField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(pwdText)
                                        .addComponent(pwdField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addComponent(loginBtn)
                                .addGap(32, 32, 32)
                                .addComponent(signText)
                                .addContainerGap(109, Short.MAX_VALUE))
        );

        pack();
    }

    private void emailFieldActionPerformed(ActionEvent evt) {

    }

    private void pwdFieldActionPerformed(ActionEvent evt) {

    }

    private void loginBtnActionPerformed(ActionEvent evt) {

    }

    public static void main(String args[]) {
        new Login().setVisible(true);
    }

}
