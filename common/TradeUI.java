package common;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TradeUI extends BaseFrame {

    private JButton createBtn;
    private JTable goodTable;
    private JButton jButton1;
    private JScrollPane jScrollPane1;
    private JButton logoutBtn;
    private JLabel oNameLabel;

    AssetInfoData data ;

    public TradeUI(AssetInfoData data,User loginUser) {
        this.data = data;
        super.loginUser = loginUser;
        initComponents();
        initTableData();
        addButtonListeners();
        showCenter();
        setTitle("Trade");
        setVisible(true);
    }

    private void initComponents() {

        oNameLabel = new JLabel();
        logoutBtn = new JButton();
        jButton1 = new JButton();
        jScrollPane1 = new JScrollPane();
        goodTable = new JTable();
        createBtn = new JButton();


        oNameLabel.setFont(new Font("Microsoft JhengHei", 0, 14));
        oNameLabel.setText(loginUser == null ? " " : loginUser.getOrganization());

        logoutBtn.setFont(new Font("Microsoft JhengHei", 0, 14));
        logoutBtn.setText("Logout");

        jButton1.setFont(new Font("Microsoft JhengHei", 0, 14));
        jButton1.setText("My account");

        goodTable.setFont(new Font("Microsoft JhengHei", 0, 14));


        jScrollPane1.setViewportView(goodTable);

        createBtn.setFont(new Font("Microsoft JhengHei", 0, 14));
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

    private void initTableData(){
        goodTable.setModel(data.getTableModel());
    }

    private void addButtonListeners(){
        goodTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2){
                    Point p = e.getPoint();
                    int row = goodTable.rowAtPoint(p);
                    Asset asset = data.get(goodTable.getValueAt(row, 0));
                    new BuyAssetUI(asset);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }


}
