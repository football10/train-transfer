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

	// 登录最近查询API
	@RequestMapping(value = "/data/regSelectHistory", method = POST, produces = "application/json;charset=UTF-8")
	public String regSelectHistory(@RequestBody String jsonRequest){
		return stationService.regSelectHistory(jsonRequest);
	}

	// 取得最近查询API
	@RequestMapping(value = "/data/getSelectHistory", method = POST, produces = "application/json;charset=UTF-8")
	public String getSelectHistory(@RequestBody String jsonRequest){
		return stationService.getSelectHistory(jsonRequest);
	}

	// 删除最近查询API
	@RequestMapping(value = "/data/delSelectHistory", method = POST, produces = "application/json;charset=UTF-8")
	public String delSelectHistory(@RequestBody String jsonRequest){
		return stationService.deltSelectHistory(jsonRequest);
	}

	// 登录收藏站点API
	@RequestMapping(value = "/data/regCollectionStation", method = POST, produces = "application/json;charset=UTF-8")
	public String regCollectionStation(@RequestBody String jsonRequest){
		return stationService.regCollectionStation(jsonRequest);
	}

	// 取得收藏站点API
	@RequestMapping(value = "/data/getCollectionStation", method = POST, produces = "application/json;charset=UTF-8")
	public String getCollectionStation(@RequestBody String jsonRequest){
		return stationService.getCollectionStation(jsonRequest);
	}

	// 删除收藏站点API
	@RequestMapping(value = "/data/delCollectionStation", method = POST, produces = "application/json;charset=UTF-8")
	public String delCollectionStation(@RequestBody String jsonRequest){
		return stationService.delCollectionStation(jsonRequest);
	}

	// 取得附近站点API
	@RequestMapping(value = "/data/getNearbyStation", method = POST, produces = "application/json;charset=UTF-8")
	public String getNearbyStation(@RequestBody String jsonRequest){
		return stationService.getNearbyStation(jsonRequest);
	}
}
