package common;

import serialisationExercise.AssetFileDataSource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyAssetUI extends BaseFrame {

    private JLabel CategoryLabel;
    private JButton buyBtn;
    private JLabel categoryText;
    private JLabel descLabel;
    private JScrollPane descriptionPanel;
    private JTextPane jTextPane1;
    private JLabel priceLabel;
    private JLabel priceText;
    private JLabel quantityLabel;
    private JLabel quantityText;
    private JLabel titleText;
    private Asset asset;
    private OrgBalanceInfoData orgBalanceInfoData;
    private HistoryInfoData historyInfoData;
    private AssetInfoData assetInfoData;
    private TradeUI tradeUI;

    public BuyAssetUI(Asset asset,User loginUser,TradeUI tradeUI) {
        this.asset = asset;
        super.loginUser = loginUser;
        this.tradeUI = tradeUI;
        this.orgBalanceInfoData = new OrgBalanceInfoData(new OrgBalanceFileDataSource());
        this.historyInfoData = new HistoryInfoData(new HistoryFileDataSource(),loginUser);
        this.assetInfoData = new AssetInfoData(new AssetFileDataSource());
        initComponents();

        addButtonListeners(new ButtonListener());
        setTitle("Buy Asset");
        showCenter();
        setVisible(true);
    }

    private void initComponents() {

        titleText = new JLabel();
        descLabel = new JLabel();
        descriptionPanel = new JScrollPane();
        jTextPane1 = new JTextPane();
        CategoryLabel = new JLabel();
        categoryText = new JLabel();
        priceLabel = new JLabel();
        priceText = new JLabel();
        quantityLabel = new JLabel();
        quantityText = new JLabel();
        buyBtn = new JButton();


        titleText.setFont(new Font("Microsoft JhengHei", 1, 36));
        titleText.setText(asset.getName());

        descLabel.setFont(new Font("Microsoft JhengHei", 0, 18));
        descLabel.setText("Asset Description:");

        jTextPane1.setText(asset.getDescription());
        descriptionPanel.setViewportView(jTextPane1);

        CategoryLabel.setFont(new Font("Microsoft JhengHei", 0, 18));
        CategoryLabel.setText("Asset Category:");

        categoryText.setFont(new Font("Microsoft JhengHei", 0, 18));
        categoryText.setText(asset.getCategory());

        priceLabel.setFont(new Font("Microsoft JhengHei", 0, 18));
        priceLabel.setText("Asset Price:");

        priceText.setFont(new Font("Microsoft JhengHei", 0, 18));
        priceText.setText("$" + asset.getPrice());

        quantityLabel.setFont(new Font("Microsoft JhengHei", 0, 18));
        quantityLabel.setText("Asset Quantity:");

        quantityText.setFont(new Font("Microsoft JhengHei", 0, 18));
        quantityText.setText(asset.getQuantity());

        buyBtn.setBackground(new Color(153, 204, 255));
        buyBtn.setFont(new Font("Microsoft JhengHei", 1, 24));
        buyBtn.setText("Buy");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(descriptionPanel, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(descLabel)
                                        .addComponent(titleText)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(priceLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(CategoryLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(quantityLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(categoryText)
                                                        .addComponent(priceText)
                                                        .addComponent(quantityText))))
                                .addContainerGap(314, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buyBtn, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(titleText)
                                .addGap(18, 18, 18)
                                .addComponent(descLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(descriptionPanel, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(CategoryLabel)
                                        .addComponent(categoryText))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(priceLabel)
                                        .addComponent(priceText))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(quantityLabel)
                                        .addComponent(quantityText))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                .addComponent(buyBtn)
                                .addGap(40, 40, 40))
        );

        pack();
    }

    /**
     * Adds a listener to the login
     */
    private void addButtonListeners(ActionListener listener) {
        buyBtn.addActionListener(listener);
    }

    private class ButtonListener implements ActionListener {

        /**
         * @see ActionListener#actionPerformed(ActionEvent)
         */
        public void actionPerformed(ActionEvent e) {

            JButton source = (JButton) e.getSource();
            if (source == buyBtn) {
                buyAsset(source);
            }
        }

        private void buyAsset(Component component) {
            String num = JOptionPane.showInputDialog(component, "How many do you want to buy?");
            try {
                if (num != null) {
                    int numInt = Integer.parseInt(num);
                    if (numInt > Integer.parseInt(asset.getQuantity())) {
                        alertMsg(component, "Buy error! quantity not enough");
                    } else {
                        double needPrice = (numInt * (Double.valueOf(asset.getPrice())));
                        OrgBalance loginOrg = orgBalanceInfoData.get(loginUser.getOrganization());
                        double surplus = Double.valueOf(loginOrg.getCredit()) - needPrice;
                        if (surplus > 0){
                            OrgBalance orgBalance = orgBalanceInfoData.get(asset.getOrganization());
                            String credit = orgBalance.getCredit();
                            double newCredit = (Double.valueOf(credit))+ (numInt * (Double.valueOf(asset.getPrice())));
                            loginOrg.setCredit(String.valueOf(surplus));
                            orgBalance.setCredit(String.valueOf(newCredit));
                            orgBalanceInfoData.remove(loginOrg.getUnitname());
                            orgBalanceInfoData.add(loginOrg);

                            orgBalanceInfoData.remove(orgBalance.getUnitname());
                            orgBalanceInfoData.add(orgBalance);
                            orgBalanceInfoData.persist();

                            //buy success history
                            History history = new History();
                            history.setHistoryid(String.valueOf(System.currentTimeMillis())+"1");
                            history.setAssetname(asset.getName());
                            history.setAssetcategory(asset.getCategory());
                            history.setAssetquantity(num);
                            history.setOrganization(loginOrg.getUnitname());
                            history.setTradetype("buy");

                            History history1 = new History();
                            history1.setHistoryid(String.valueOf(System.currentTimeMillis()));
                            history1.setAssetname(asset.getName());
                            history1.setAssetcategory(asset.getCategory());
                            history1.setAssetquantity(num);
                            history1.setOrganization(orgBalance.getUnitname());
                            history1.setTradetype("sell");
                            historyInfoData.add(history);
                            historyInfoData.add(history1);
                            historyInfoData.persist();

                            int surplusQ = Integer.parseInt(asset.getQuantity()) - numInt;
                            if ( surplusQ > 0 ){
                                Asset asset = assetInfoData.get(BuyAssetUI.this.asset.getName());
                                asset.setQuantity(String.valueOf(surplusQ));
                                assetInfoData.remove(asset.getName());
                                assetInfoData.add(asset);
                                assetInfoData.persist();
                            }
                            if (surplusQ == 0){
                                assetInfoData.remove(asset.getName());
                                assetInfoData.persist();
                            }

                            alertMsg(component, "Buy success! You bought " + numInt);
                            tradeUI.refresh();
                        }else{
                            alertMsg(component, "Buy fail! The balance of your organization is insufficient! ");
                        }
                    }

                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(component, "please enter a number!", "info", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


}
