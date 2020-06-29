package com.dbs.commons.responsewrapper;

public class DBS_ResponseWarapperVO {

	private boolean success;
	private String status;
	private Object data;
	private String message;
	
	public DBS_ResponseWarapperVO(boolean success, String status, Object data, String message) {
		super();
		this.success = success;
		this.status = status;
		this.data = data;
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
