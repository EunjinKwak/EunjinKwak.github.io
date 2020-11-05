package com.spring.withwork.vo;

import java.sql.Date;

public class GuestVO {
	
	private int g_num;
	private int m_num;
	private int c_num;
	private int d_num;
	private int p_num;
	private String password;
	private String g_name;
	private String c_name;
	private String address;
	private String email;
	private String phone;
	private String depart;
	private String role;
	private String authority;
	private Date regdate;
	private String authKey;
	private String authStatus;
		
	public GuestVO() {
		
	}

	public GuestVO(int g_num, int m_num, int c_num, int d_num, int p_num, String password, String g_name, String c_name,
			String address, String email, String phone, String depart, String role, String authority, Date regdate,
			String authKey, String authStatus) {
		super();
		this.g_num = g_num;
		this.m_num = m_num;
		this.c_num = c_num;
		this.d_num = d_num;
		this.p_num = p_num;
		this.password = password;
		this.g_name = g_name;
		this.c_name = c_name;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.depart = depart;
		this.role = role;
		this.authority = authority;
		this.regdate = regdate;
		this.authKey = authKey;
		this.authStatus = authStatus;
	}

	public int getG_num() {
		return g_num;
	}

	public void setG_num(int g_num) {
		this.g_num = g_num;
	}

	public int getM_num() {
		return m_num;
	}

	public void setM_num(int m_num) {
		this.m_num = m_num;
	}

	public int getC_num() {
		return c_num;
	}

	public void setC_num(int c_num) {
		this.c_num = c_num;
	}

	public int getD_num() {
		return d_num;
	}

	public void setD_num(int d_num) {
		this.d_num = d_num;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getAuthKey() {
		return authKey;
	}

	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}

	public String getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}

	@Override
	public String toString() {
		return "GuestVO [g_num=" + g_num + ", m_num=" + m_num + ", c_num=" + c_num + ", d_num=" + d_num + ", p_num="
				+ p_num + ", password=" + password + ", g_name=" + g_name + ", c_name=" + c_name + ", address="
				+ address + ", email=" + email + ", phone=" + phone + ", depart=" + depart + ", role=" + role
				+ ", authority=" + authority + ", regdate=" + regdate + ", authKey=" + authKey + ", authStatus="
				+ authStatus + "]";
	}

	
}
