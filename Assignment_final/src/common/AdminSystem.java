package common;

import common.Asset.AssetFileDataSource;
import common.Asset.AssetInfoData;
import common.Asset.AssetInfoUI;
import common.History.HistoryFileDataSource;
import common.History.HistoryInfoData;
import common.History.HistoryInfoUI;
import common.OrgAsset.OrgAssetFileDataSource;
import common.OrgAsset.OrgAssetInfoData;
import common.OrgAsset.OrgAssetInfoUI;
import common.OrgBalance.OrgBalanceFileDataSource;
import common.OrgBalance.OrgBalanceInfoData;
import common.OrgBalance.OrgBalanceInfoUI;
import common.User.UserFileDataSource;
import common.User.UserInfoData;
import common.User.UserInfoUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminSystem extends BaseFrame {

    JButton user;
    JButton assets;
    JButton balance;
    JButton orgAsset;
    JButton history;
    public AdminSystem(){
        initComponents();

        setTitle("AdminSystem");
        setLocationRelativeTo(null);
        showCenter();
        setVisible(true);
    }

    private void closeFrame() {
        this.dispose();
    }

    private void initComponents(){

        /**
         *  Create a label on panel
         */
        JLabel label = new JLabel("Administrator system: ");

        /**
         * Create the five button on panel
         */
        user = new JButton("User");
        assets = new JButton("Assets transaction");
        balance = new JButton("Balance");
        orgAsset = new JButton("Organization assets");
        history = new JButton("History");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        user.addActionListener(new ButtonListener());
        assets.addActionListener(new ButtonListener());
        balance.addActionListener(new ButtonListener());
        orgAsset.addActionListener(new ButtonListener());
        history.addActionListener(new ButtonListener());

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                        .addGap(50)
                                        .addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

                        .addGroup(layout.createSequentialGroup()
                                .addComponent(user)
                                .addGap(10)
                                .addComponent(assets)
                                .addGap(10)
                                .addComponent(balance)
                                .addGap(10)
                                .addComponent(orgAsset)
                                .addGap(10)
                                .addComponent(history))
                        ));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGap(50)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(label))
                .addGap(50)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(user).addComponent(assets).addComponent(balance).addComponent(orgAsset).addComponent(history))
                .addContainerGap());



        pack();

    }

    private class ButtonListener implements ActionListener {

        /**
         * @see ActionListener#actionPerformed(ActionEvent)
         */
        public void actionPerformed(ActionEvent e) {

            JButton source = (JButton) e.getSource();
            if (source == user) {
                new UserInfoUI(new UserInfoData(new UserFileDataSource()));
            }else if(source == assets){
                new AssetInfoUI(new AssetInfoData(new AssetFileDataSource()));
            }else if(source == balance){
                new OrgBalanceInfoUI(new OrgBalanceInfoData(new OrgBalanceFileDataSource()));
            }else if(source == orgAsset){
                new OrgAssetInfoUI(new OrgAssetInfoData(new OrgAssetFileDataSource()));
            }else if(source == history){
                new HistoryInfoUI(new HistoryInfoData(new HistoryFileDataSource(),null));
            }

        }
    }



    public static void main(String[] args){new AdminSystem();}
}
