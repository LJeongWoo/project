package com.DTO;

public class memberDTO {
	
	private String Email;
	private String Id;
	private String Pw;
	private String Nick;
	private String Address;
		
	
	
	
	
	
	public memberDTO(String email, String id, String nick, String address) {
		super();
		Email = email;
		Id = id;
		Nick = nick;
		Address = address;
	}
	public memberDTO(String email, String id, String pw, String nick, String address) {
		super();
		Email = email;
		Id = id;
		Pw = pw;
		Nick = nick;
		Address = address;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getPw() {
		return Pw;
	}
	public void setPw(String pw) {
		Pw = pw;
	}
	public String getNick() {
		return Nick;
	}
	public void setNick(String nick) {
		Nick = nick;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	
	
}
