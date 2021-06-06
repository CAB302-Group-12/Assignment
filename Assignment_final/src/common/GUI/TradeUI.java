package common.GUI;



import common.*;
import common.Asset.Asset;
import common.Asset.AssetFileDataSource;
import common.Asset.AssetInfoData;
import common.User.User;
import common.User.UserFileDataSource;
import common.User.UserInfoData;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TradeUI extends BaseFrame {

    private JButton createBtn;
    private JTable goodTable;
    private JButton accountBtn;
    private JScrollPane jScrollPane1;
    private JButton refreshBtn;
    private JButton adminBtn;
    private JButton logoutBtn;
    private JLabel oNameLabel;

    private TradeUI tradeUI;
    AssetInfoData data ;


    public TradeUI(AssetInfoData data, User loginUser) {
        this.data = data;
        super.loginUser = loginUser;

        initComponents();
        initTableData();
        addButtonListeners();
        addButtonListeners_myaccount();

        showCenter();
        setTitle("Trade Main Page");
        setVisible(true);
        tradeUI = this;
    }

    private void initComponents() {

        oNameLabel = new JLabel();
        logoutBtn = new JButton();
        refreshBtn = new JButton();
        adminBtn = new JButton();
        accountBtn = new JButton();
        jScrollPane1 = new JScrollPane();
        goodTable = new JTable();

        createBtn = new JButton();


        oNameLabel.setFont(new Font("Microsoft JhengHei", 0, 14));
        oNameLabel.setText(loginUser == null ? " " : loginUser.getOrganization());

        logoutBtn.setFont(new Font("Microsoft JhengHei", 0, 14));
        logoutBtn.setText("Logout");

        refreshBtn.setFont(new Font("Microsoft JhengHei", 0, 14));
        refreshBtn.setText("Refresh");

        adminBtn.setFont(new Font("Microsoft JhengHei", 0, 14));
        adminBtn.setText("Administrator");

        accountBtn.setFont(new Font("Microsoft JhengHei", 0, 14));
        accountBtn.setText("My account");

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
                                .addGap(121)
                                .addComponent(adminBtn)
                                .addGap(50)
                                .addComponent(refreshBtn)
                                .addGap(50)
                                .addComponent(accountBtn)
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
                                                        .addComponent(adminBtn)
                                                        .addComponent(refreshBtn)
                                                        .addComponent(logoutBtn)
                                                        .addComponent(accountBtn))
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
        logoutBtn.addActionListener(new ButtonListener());
        createBtn.addActionListener(new ButtonListener());
        refreshBtn.addActionListener(new ButtonListener());
        adminBtn.addActionListener(new ButtonListener());
        goodTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2){
                    Point p = e.getPoint();
                    int row = goodTable.rowAtPoint(p);
                    Asset asset = data.get(goodTable.getValueAt(row, 0));
                    new BuyAssetUI(asset,loginUser,tradeUI);
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


    private class ButtonListener implements ActionListener {

        /**
         * @see ActionListener#actionPerformed(ActionEvent)
         */
        public void actionPerformed(ActionEvent e) {

            JButton source = (JButton) e.getSource();
            if (source == logoutBtn) {
                logout(source);
            }else if (source == createBtn){
                create();
            }else if (source == refreshBtn){
                refresh();
            }else if (source == adminBtn){
                admin(source);
            }

        }

        private void admin(Component component) {
            if (loginUser.getUsertype() != null && loginUser.getUsertype().equals("Administrator")){
                new AdminSystem();
            }else{
                alertMsg(component,"Insufficient authority!");
            }
        }



        private void create(){
            new CreateUI(new AssetInfoData(new AssetFileDataSource()),loginUser).setVisible(true);
        }

        private void logout(Component component) {
            int i = JOptionPane.showConfirmDialog(component, "Are you sure?","info",JOptionPane.YES_NO_OPTION);
            if (i == 0){
                setVisible(false);
                new LoginUI(new UserInfoData(new UserFileDataSource()));
            }
        }
    }

    public void refresh() {
        goodTable.setModel(new AssetInfoData(new AssetFileDataSource()).getTableModel());
    }

/** Connect to My Account GUI **/
    private void addButtonListeners_myaccount() {
        accountBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                new myAccount(new UserInfoData(new UserFileDataSource()), loginUser);

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
