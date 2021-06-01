package com.computer.trading.client.controller;

import java.util.List;

import com.computer.trading.client.ServerConnection;
import com.computer.trading.client.context.LoginContext;
import com.computer.trading.client.util.Configuration;
import com.computer.trading.common.Constants;
import com.computer.trading.common.beans.Asset;
import com.computer.trading.common.message.CommandMessageRequest;
import com.computer.trading.common.message.CommandMessageResponse;
import com.computer.trading.common.utils.CommandEnum;
import com.computer.trading.common.utils.ResponseCode;

public class AssetController {
	private ServerConnection connection = null;
	private Configuration config = null;
	
	public AssetController(Configuration config) {
		this.config = config;
		connection = ServerConnection.getInstance(this.config.getServerHost(), this.config.getServerPort());
	}
	
	public AssetController() {
		this.config = Configuration.getInstance(Constants.CLIENT_CONFIG_PATH);
		connection = ServerConnection.getInstance(this.config.getServerHost(), this.config.getServerPort());
	}

	public List<Asset> getAllAssets() {
		CommandMessageRequest request = new CommandMessageRequest();
		request.setCommand(CommandEnum.ASSET_GET_ALL);
		request.setCurrentUser(LoginContext.getInstance().getCurrentUser());
		try {
			CommandMessageResponse response = connection.sendMessage(request);
			if (response.getCode() == ResponseCode.SUCCESS) {
				List<Asset> assets = (List<Asset>) response.getResponse();
				return assets;
			}
		} catch (Exception e) {
			System.err.println("Failed to login to the trading platform: " + e.getMessage());
		}
		return null;
	}

	public boolean addAsset(Asset asset) {
		CommandMessageRequest request = new CommandMessageRequest();
		request.setCommand(CommandEnum.ASSET_ADD);
		request.setCurrentUser(LoginContext.getInstance().getCurrentUser());
		request.setMessage(asset);
		try {
			CommandMessageResponse response = connection.sendMessage(request);
			if (response.getCode() == ResponseCode.SUCCESS) {
				
				return (boolean)response.getResponse();
			}
		} catch (Exception e) {
			System.err.println("Failed to login to the trading platform: " + e.getMessage());
		}
		return false;
	}
}
