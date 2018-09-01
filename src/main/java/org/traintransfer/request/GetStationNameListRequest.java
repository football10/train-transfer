package org.traintransfer.request;

public class GetStationNameListRequest {

	public RequestInfo requestInfo;

	public class RequestInfo {
		// Station名称(模糊)
		public String stationLikeName;
	}

}
