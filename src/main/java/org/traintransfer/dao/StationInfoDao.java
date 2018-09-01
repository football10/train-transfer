package org.traintransfer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.traintransfer.dao.entity.StationNameInfoEntity;
import org.traintransfer.dao.parameter.StationNameLikeParameter;

@Repository
public interface StationInfoDao {

	List<String> selectLineList(String station_g_cd);

	List<StationNameInfoEntity> selectStationNameList(StationNameLikeParameter stationNameLikeParameter);

}
