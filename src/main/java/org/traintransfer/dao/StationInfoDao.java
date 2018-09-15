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


	//最近查询
	void regSelectHistory(stationHistoryParameter shParameter);

	void updateSelectHistory(stationHistoryParameter shParameter);

	String selectUserID_SelectHistory(stationHistoryParameter shParameter);

	List<StationNameInfoEntity> selectHistory(String openId);

	void deleteSelectHistory(stationHistoryParameter shParameter);

	//收藏点点
	void regCollectionStation(stationHistoryParameter shParameter);

	String selectUserID_CollectionStation(stationHistoryParameter shParameter);

	List<StationNameInfoEntity> selectCollectionStation(String openId);

	void deleteCollectionStation(stationHistoryParameter shParameter);

}
