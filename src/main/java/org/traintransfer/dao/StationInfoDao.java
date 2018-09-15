package org.traintransfer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.traintransfer.dao.entity.StationNameInfoEntity;
import org.traintransfer.dao.parameter.StationNameLikeParameter;
import org.traintransfer.dao.parameter.stationHistoryParameter;

@Repository
public interface StationInfoDao {

	List<String> selectLineList(String station_g_cd);

	List<StationNameInfoEntity> selectStationNameList(StationNameLikeParameter stationNameLikeParameter);

	void regSelectHistory(stationHistoryParameter shParameter);

	void updateSelectHistory(stationHistoryParameter shParameter);

	String selectUserID_SelectHistory(stationHistoryParameter shParameter);

	List<StationNameInfoEntity> selectHistory(String openId);

	void deleteSelectHistory(stationHistoryParameter shParameter);


}
