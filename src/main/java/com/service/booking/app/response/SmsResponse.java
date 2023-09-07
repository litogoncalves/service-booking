package com.service.booking.app.response;

public class SmsResponse {
	
	private String usenditResponse;
	private boolean success;
	private int status;
	private String message;
	
	public SmsResponse() {
		
	}

	public String getUsenditResponse() {
		return usenditResponse;
	}

	public void setUsenditResponse(String usenditResponse) {
		this.usenditResponse = usenditResponse;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
