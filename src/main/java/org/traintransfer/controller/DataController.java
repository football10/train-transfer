package org.traintransfer.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.traintransfer.service.StationService;

@RestController
public class DataController {

	@Autowired
	private StationService stationService;

	// Station名称照合API
	@RequestMapping(value = "/data/getStationNameList", method = POST, produces = "application/json;charset=UTF-8")
	public String getStationNameList(@RequestBody String jsonRequest){
		return stationService.getStationNameList(jsonRequest);
	}

}
