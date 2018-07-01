package org.traintransfer.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Util {

	// TODO
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
