package org.traintransfer.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.lang3.StringUtils;

public class Util {

	public static String getLikeString(String value) {

		StringBuffer result = new StringBuffer();
		for(int i = 0; i < value.length(); i++) {
			result.append("%").append(StringUtils.mid(value, i, 1));
		}
		result.append("%");

		return result.toString();
	}

	// 根据服务器系统时间，计算当前状态
	public static String getStatus(String deadline) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cl = Calendar.getInstance();
		String sysDate = dateFormat.format(cl.getTime());

        try {
        	dateFormat.parse(deadline);
        } catch(Exception e) {
            return "报名中";
        }

        if (sysDate.compareTo(deadline) <= 0) {
        	return "报名中";
        } else {
        	return "已结束";
        }
	}
}
