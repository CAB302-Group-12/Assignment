package common;

import javax.swing.*;
import java.awt.*;

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

    public BuyAssetUI(Asset asset) {
        this.asset = asset;
        initComponents();

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
        priceText.setText("$"+asset.getPrice());

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



}
