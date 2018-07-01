package org.traintransfer.response;

public class CommonResponse {

	public String responseCode;
	public ErrorInfo errorInfo = new ErrorInfo();

	public class ErrorInfo {
		public String message;
	}

}
