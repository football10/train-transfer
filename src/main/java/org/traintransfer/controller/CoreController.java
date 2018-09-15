package org.traintransfer.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.traintransfer.service.CoreService;

@RestController
public class CoreController {

	@Autowired
	private CoreService coreService;

	// 取得最近查询API
	@RequestMapping(value = "/core/getTransferList", method = POST, produces = "application/json;charset=UTF-8")
	public String getTransferList(@RequestBody String jsonRequest){
		return coreService.getTransferList(jsonRequest);
	}
}
