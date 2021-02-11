package com.DTO;

public class memberDTO {
	//필드
	private String email;
	private String pw;
	private String tel;
	private String address;
	public memberDTO(String email, String tel, String address) {
		super();
		this.email = email;
		this.tel = tel;
		this.address = address;
	}

	//생성자
	public memberDTO(String email, String pw) {
		super();
		this.email = email;
		this.pw = pw;
	}

	public memberDTO(String email, String pw, String tel, String address) {
		super();
		this.email = email;
		this.pw = pw;
		this.tel = tel;
		this.address = address;
	}
	//getter
	public String getEmail() {
		return email;
	}

	public String getPw() {
		return pw;
	}

	public String getTel() {
		return tel;
	}

	public String getAddress() {
		return address;
	}

}
