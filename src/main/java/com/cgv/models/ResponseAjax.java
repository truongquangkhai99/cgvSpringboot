package com.cgv.models;

public class ResponseAjax {
	private String status;
	private String message;
	public Object data;
	public ResponseAjax(String status, String message, Object data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ResponseAjax(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	public ResponseAjax() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ResponseAjax [status=" + status + ", message=" + message + "]";
	}
	
	

}
