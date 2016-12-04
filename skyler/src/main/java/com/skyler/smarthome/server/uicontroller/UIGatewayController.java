package com.skyler.smarthome.server.uicontroller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skyler.smarthome.server.data.GatewayDao;
import com.skyler.smarthome.server.model.Gateway;

@Controller
@RequestMapping("/gateway")
public class UIGatewayController {

	final static Logger logger = Logger.getLogger(UIGatewayController.class);

	@Autowired
	GatewayDao gatewayDao;

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Gateway> getAllGateways() {
		List<Gateway> gatewayList = gatewayDao.getAllGateways();
		return gatewayList;
	};

	@RequestMapping(value = "/{gatewayid}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Gateway getGatewayById(@PathVariable int gatewayid) {
		if (gatewayid > 0) {
			Gateway gateway = gatewayDao.getGatewayById(gatewayid);
			return gateway;
		} else {
			return null;
		}
	};

	@RequestMapping(value = "/update/{gatewayid}", method = RequestMethod.POST)
	public void updateGateway(@PathVariable int gatewayid, @RequestParam String gatewayField, @RequestParam String newParam) {
		if (gatewayid > 0 && gatewayField != null && newParam != null) {
			boolean result = gatewayDao.updateGatewayByField(gatewayid, gatewayField, newParam);
		}
	};

}
