package com.DTO;

public class MessageDTO {

	private int num;
	private String sendemail;
	private String receiveemail;
	private String message;
	private String date;
	
	
	
	
	public MessageDTO(int num, String sendemail, String receiveemail, String message, String date) {
		super();
		this.num = num;
		this.sendemail = sendemail;
		this.receiveemail = receiveemail;
		this.message = message;
		this.date = date;
	}
	public MessageDTO(String sendemail, String receiveemail, String message) {
		super();
		this.sendemail = sendemail;
		this.receiveemail = receiveemail;
		this.message = message;
	}
	public int getNum() {
		return num;
	}
	public String getSendemail() {
		return sendemail;
	}
	public String getReceiveemail() {
		return receiveemail;
	}
	public String getMessage() {
		return message;
	}
	public String getDate() {
		return date;
	}
	
	
}
