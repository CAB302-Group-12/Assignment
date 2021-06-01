package com.computer.trading.server.handlers;

import com.computer.trading.common.message.CommandMessageRequest;
import com.computer.trading.common.message.CommandMessageResponse;

public interface ActionHandler {

	CommandMessageResponse execute(CommandMessageRequest request);

}
