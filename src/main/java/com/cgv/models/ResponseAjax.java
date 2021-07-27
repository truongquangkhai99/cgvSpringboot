package com.cgv.models;

import java.util.List;

public class ResponseAjax {
	private String status;
	private String message;
	public Object data;
	private List<String> nameSeat;
	private BookingResponse listName;
	public ResponseAjax(String status, String message, Object data, List<String> nameSeat, BookingResponse listName) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
		this.nameSeat = nameSeat;
		this.listName = listName;
	}
	public BookingResponse getListName() {
		return listName;
	}
	public void setListName(BookingResponse listName) {
		this.listName = listName;
	}
	public List<String> getNameSeat() {
		return nameSeat;
	}
	public void setNameSeat(List<String> nameSeat) {
		this.nameSeat = nameSeat;
	}
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
	public ResponseAjax(String status, String message, Object data, List<String> nameSeat) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
		this.nameSeat = nameSeat;
	}
	
	

}
