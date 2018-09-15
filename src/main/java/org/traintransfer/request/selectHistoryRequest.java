package org.traintransfer.request;

public class selectHistoryRequest {

	public RequestInfo requestInfo;

	public class RequestInfo {
		// UserID
		public String openid;

		//stationGroupCode
		public String stationGroupCode;

		public String stationNameCN;
		public String stationNameJP;
		public String stationNameRoman;


	}
}
