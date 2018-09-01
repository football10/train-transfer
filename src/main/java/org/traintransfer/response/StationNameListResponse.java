package org.traintransfer.response;

import java.util.List;

import org.traintransfer.response.CommonResponse;
import org.traintransfer.response.model.StationInfo;

public class StationNameListResponse extends CommonResponse {

	public StationListResult result = new StationListResult();

	public class StationListResult {
		public int stationCount;
		public List<StationInfo> stationList;
	}

}
