package com.computer.trading.client.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.apache.commons.lang3.StringUtils;

import com.computer.trading.client.controller.AssetController;
import com.computer.trading.client.ui.model.AssetInfoData;
import com.computer.trading.common.beans.Asset;
import com.computer.trading.common.beans.User;

public class CreateAssetUI extends BaseFrame{
	AssetInfoData data;
	
	public CreateAssetUI(AssetInfoData data, User loginUser) {
		this.data = data;
		super.loginUser = loginUser;
		initComponents();
		
		showCenter();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				closeFrame();
			}
		});
		setTitle("Create Asset");
		setVisible(true);
	}
	
	private void initComponents() {
		JLabel assetsLabel = new JLabel("Assets");
		
		JLabel nameLabel = new JLabel("Asset Name:");
		JTextField nameInput = new JTextField(30);
		
		JLabel catagoryLabel = new JLabel("Catogory:");
		JTextField catagoryInput = new JTextField(30);
		
		JLabel priceLabel = new JLabel("Price:");
		JTextField priceInput = new JTextField(30);
		
		JLabel quantityLabel = new JLabel("Quantity:");
		JTextField quantityInput = new JTextField(30);
		
		JLabel descriptionLabel = new JLabel("Description:");
		JTextField descInput = new JTextField(30);
	
		
		JButton addBtn = new JButton("Add");
		addBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				addAsset(nameInput.getText(), catagoryInput.getText(), priceInput.getText(), quantityInput.getText(), descInput.getText());				
			}

			
		});
		
		JButton closeBtn = new JButton("Cancel");
		closeBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				closeFrame();
			}			
		});
		
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		
		layout.setHorizontalGroup(layout
			    .createParallelGroup(GroupLayout.Alignment.LEADING)
			    .addComponent(assetsLabel, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			    .addGroup(layout.createSequentialGroup()
			        .addComponent(nameLabel, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			        .addComponent(nameInput, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			        .addComponent(catagoryLabel, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			        .addComponent(catagoryInput, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			    .addGroup(layout.createSequentialGroup()
			        .addComponent(quantityLabel, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			        .addComponent(quantityInput, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			        .addComponent(priceLabel, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			        .addComponent(priceInput, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			    .addGroup(layout.createSequentialGroup()
				        .addComponent(descriptionLabel, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				        .addComponent(descInput, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			    .addGroup(layout.createSequentialGroup()
				        .addComponent(addBtn, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGap(20)
				        .addComponent(closeBtn, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				        .addContainerGap())
			    );

			layout.setVerticalGroup(layout.createSequentialGroup()
				.addComponent(assetsLabel)
			    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			        .addComponent(nameLabel).addComponent(nameInput).addComponent(catagoryLabel).addComponent(catagoryInput))
			    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			        .addComponent(quantityLabel).addComponent(quantityInput).addComponent(priceLabel).addComponent(priceInput))
			    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			    		 .addComponent(descriptionLabel).addComponent(descInput))
			    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			    		 .addComponent(addBtn).addComponent(closeBtn))
			    .addContainerGap());
		pack();
	}

	private void addAsset(String name, String catagory, String price, String quantity, String descripion) {
		System.out.println("Create an asset");
		if (StringUtils.isBlank(name) || StringUtils.isBlank(catagory) || StringUtils.isBlank(quantity)) {
			alertMsg(this, "Please at least provide valid name, catagory, price and quantity");
			return;
		}
		
		Asset asset = new Asset();
		asset.setCategory(catagory);
		asset.setName(name);
		asset.setDescription(descripion);
		asset.setPrice(Double.parseDouble(price));
		asset.setQuantity(Integer.parseInt(quantity));
		
		AssetController controller = new AssetController();
		if(controller.addAsset(asset)){
			data.add(asset);
			closeFrame();
		}
		
	}	

	private void closeFrame() {
		this.dispose();
	}
}
