package org.traintransfer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.traintransfer.dao.entity.LineJoinInfoEntity;

@Repository
public interface LineJoinInfoDao {

	List<LineJoinInfoEntity> selectLineJoinInfo();

}
