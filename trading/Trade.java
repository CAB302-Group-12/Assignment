package com.trading;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Trade extends JFrame {

    private JButton createBtn;
    private JTable goodTable;
    private JButton jButton1;
    private JScrollPane jScrollPane1;
    private JButton logoutBtn;
    private JLabel oNameLabel;

    public Trade() {
        initComponents();
    }

    private void initComponents() {

        oNameLabel = new JLabel();
        logoutBtn = new JButton();
        jButton1 = new JButton();
        jScrollPane1 = new JScrollPane();
        goodTable = new JTable();
        createBtn = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        oNameLabel.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14));
        oNameLabel.setText("Name of Organization");

        logoutBtn.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14));
        logoutBtn.setText("Logout");

        jButton1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14));
        jButton1.setText("My account");

        goodTable.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14));
        goodTable.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                },
                new String[]{
                        "name", "type", "price", "quantity", "description"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(goodTable);

        createBtn.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14));
        createBtn.setText("Create Products");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(24)
                                .addComponent(oNameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(231)
                                .addComponent(jButton1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(logoutBtn)
                                .addGap(31))
                        .addComponent(jScrollPane1)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(createBtn)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(logoutBtn)
                                                        .addComponent(jButton1))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(oNameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18)
                                .addComponent(createBtn)
                                .addGap(14)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
    }


    public static void main(String args[]) {
        new Trade().setVisible(true);
    }
}
