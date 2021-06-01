package com.computer.trading.server.handlers;

import com.computer.trading.common.beans.Asset;
import com.computer.trading.common.message.CommandMessageRequest;
import com.computer.trading.common.message.CommandMessageResponse;
import com.computer.trading.common.utils.CommandEnum;
import com.computer.trading.common.utils.ResponseCode;
import com.computer.trading.server.dao.impl.AssetDaoImpl;
import com.computer.trading.server.dao.intf.AssetDao;

public class AssetActionHandler implements ActionHandler{

	@Override
	public CommandMessageResponse execute(CommandMessageRequest request) {
		CommandMessageResponse response  = null;
		CommandEnum cmmd = request.getCommand();
		if (cmmd == CommandEnum.ASSET_GET_ALL) {
			System.out.println("Get all assets action");
			AssetDao dao = new AssetDaoImpl();
			response = new CommandMessageResponse();
			response.setCode(ResponseCode.SUCCESS);
			response.setCommand(cmmd);
			response.setResponse(dao.getAllAssets());
		} else if(cmmd == CommandEnum.ASSET_ADD) {
			System.out.println("Get all assets action");
			AssetDao dao = new AssetDaoImpl();
			Asset asset = (Asset)request.getMessage();
			response = new CommandMessageResponse();
			response.setCode(ResponseCode.SUCCESS);
			response.setCommand(cmmd);			
			response.setResponse(dao.addAsset(asset));
		}
		
		return response;
	}

}
