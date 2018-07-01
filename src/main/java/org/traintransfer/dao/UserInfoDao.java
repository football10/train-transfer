package org.traintransfer.dao;

import org.springframework.stereotype.Repository;
import org.traintransfer.dao.entity.UserInfoEntity;

@Repository
public interface UserInfoDao {

	UserInfoEntity selectUserInfo(String userId);

	long insertUserInfo(UserInfoEntity userInfoEntity);

	long updateUserInfo(UserInfoEntity userInfoEntity);
}
