package common;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HistoryUI extends BaseFrame {


    private JTable goodTable;

    private JScrollPane jScrollPane1;

    private JLabel TitleLabel;


    HistoryInfoData data ;

    public HistoryUI(HistoryInfoData data,User loginUser) {
        this.data = data;
        super.loginUser = loginUser;
        initComponents();
        initTableData();
        showCenter();
        setTitle("View History");
        setVisible(true);
    }

    private void initComponents() {

        TitleLabel = new JLabel();


        jScrollPane1 = new JScrollPane();
        goodTable = new JTable();




        TitleLabel.setFont(new Font("Microsoft JhengHei", 1, 24));
        TitleLabel.setText(loginUser.getOrganization() + "'s"+ " " + "Trade History");



        goodTable.setFont(new Font("Microsoft JhengHei", 0, 14));







        jScrollPane1.setViewportView(goodTable);



        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(24)
                                .addComponent(TitleLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0)

                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

                                .addContainerGap())
        ));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)



                                        .addComponent(TitleLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18)

                                .addGap(14)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        )));

        pack();
    }

    private void initTableData(){
        goodTable.setModel(data.getTableModel());
    }




}
