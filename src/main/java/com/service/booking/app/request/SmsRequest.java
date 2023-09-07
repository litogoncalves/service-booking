package com.service.booking.app.request;

public class SmsRequest {
	
	private String username;
	private String password;
	private String partnerEventId;
	private String timezone;
	private String partnerMsgId;
	private String sender;
	private String sendTo;
	private String mobileOperator;
	private int priority;
	private String expirationDatetime;
	private String messageText;
	private String scheduleDatetime;
	private String beginTime;
	private String endTime;
	private boolean workingDays;
	private boolean isFlash;
	
	public SmsRequest() {
	}

	public SmsRequest(String username, String password, String partnerEventId, String timezone, String partnerMsgId,
			String sender, String sendTo, String mobileOperator, int priority, String expirationDatetime,
			String messageText, String scheduleDatetime, String beginTime, String endTime,
			boolean workingDays, boolean isFlash) {
		this.username = username;
		this.password = password;
		this.partnerEventId = partnerEventId;
		this.timezone = timezone;
		this.partnerMsgId = partnerMsgId;
		this.sender = sender;
		this.sendTo = sendTo;
		this.mobileOperator = mobileOperator;
		this.priority = priority;
		this.expirationDatetime = expirationDatetime;
		this.messageText = messageText;
		this.scheduleDatetime = scheduleDatetime;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.workingDays = workingDays;
		this.isFlash = isFlash;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPartnerEventId() {
		return partnerEventId;
	}

	public void setPartnerEventId(String partnerEventId) {
		this.partnerEventId = partnerEventId;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getPartnerMsgId() {
		return partnerMsgId;
	}

	public void setPartnerMsgId(String partnerMsgId) {
		this.partnerMsgId = partnerMsgId;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSendTo() {
		return sendTo;
	}

	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}

	public String getMobileOperator() {
		return mobileOperator;
	}

	public void setMobileOperator(String mobileOperator) {
		this.mobileOperator = mobileOperator;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getExpirationDatetime() {
		return expirationDatetime;
	}

	public void setExpirationDatetime(String expirationDatetime) {
		this.expirationDatetime = expirationDatetime;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public String getScheduleDatetime() {
		return scheduleDatetime;
	}

	public void setScheduleDatetime(String scheduleDatetime) {
		this.scheduleDatetime = scheduleDatetime;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public boolean isWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(boolean workingDays) {
		this.workingDays = workingDays;
	}

	public boolean isFlash() {
		return isFlash;
	}

	public void setFlash(boolean isFlash) {
		this.isFlash = isFlash;
	}
	
}
