package org.traintransfer.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.traintransfer.common.Constants;
import org.traintransfer.common.Util;
import org.traintransfer.dao.StationInfoDao;
import org.traintransfer.dao.entity.StationNameInfoEntity;
import org.traintransfer.dao.parameter.StationNameLikeParameter;
import org.traintransfer.request.GetStationNameListRequest;
import org.traintransfer.response.StationNameListResponse;
import org.traintransfer.response.model.StationInfo;

import com.google.gson.Gson;

@Service
@Transactional
public class StationService {

	static final Logger log = LoggerFactory.getLogger(StationService.class);

	@Autowired
	private StationInfoDao staionInfoDao;

	public String getStationNameList(String jsonRequest) {
		Gson gson = new Gson();
		StationNameListResponse response = new StationNameListResponse();

		log.info("GetStationNameListRequest = " + jsonRequest);

		try {
			GetStationNameListRequest request = gson.fromJson(jsonRequest, GetStationNameListRequest.class);
			String stationName = request.requestInfo.stationLikeName;

			if(StringUtils.isEmpty(stationName)) {
				response.result.stationCount = 0;
			} else {
				StationNameLikeParameter param = new StationNameLikeParameter();
				param.setStationNameLikeSQL_1(Util.getLikeString(stationName));

				param.setStationNameLikeSQL_2(null);

//				if(stationName.length() == 1 || stationName.length() > 5) {
//					param.setStationNameLikeSQL_2(null);
//				} else {
//					param.setStationNameLikeSQL_2(Util.getLikeString(StringUtils.left(stationName, stationName.length()-1)));
//					param.setStationNameLikeSQL_3(Util.getLikeString(StringUtils.right(stationName, stationName.length()-1)));
//				}

				List<StationNameInfoEntity> nameList = staionInfoDao.selectStationNameList(param);
				List<StationInfo> stationInfoList = new ArrayList<StationInfo>();
				for (StationNameInfoEntity stationNameInfo : nameList) {
					StationInfo info = new StationInfo();
					info.stationGroupCode = stationNameInfo.getStation_g_cd();
					info.stationNameCN = stationNameInfo.getStation_name_cn();
					info.stationNameJP = stationNameInfo.getStation_name();
					info.stationNameRoman = stationNameInfo.getStation_name_r();

					stationInfoList.add(info);
				}
				response.result.stationCount = stationInfoList.size();
				response.result.stationList = stationInfoList;
			}

			response.responseCode = Constants.RESPONSE_CODE_OK;

		} catch(Exception e) {
			response.result = null;
			response.responseCode = Constants.RESPONSE_CODE_NG;
			response.errorInfo.message = e.getMessage();
			e.printStackTrace();

			log.error(e.getMessage(), e);
		}

		String json = gson.toJson(response);
		log.info("GetStationNameListResponse = " + json);

		return json;
	}
}
