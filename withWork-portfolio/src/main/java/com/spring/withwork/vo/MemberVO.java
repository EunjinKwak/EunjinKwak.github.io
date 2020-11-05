package com.spring.withwork.vo;

public class MemberVO {
	private int m_num;
	private int c_num;
	private int g_num;
	private int d_num;
	private int r_num;
	private String authority;
	private String role;
	private String g_name;
	private String email;
	private String depart;
	
	public MemberVO() {
		super();
	}

   public MemberVO(int c_num, int g_num, String authority) {
	      this.c_num = c_num;
	      this.g_num = g_num;
	      this.authority = authority;
   }

	public MemberVO(int m_num, int c_num, int g_num, int d_num, int r_num, String authority, String role, String g_name,
			String email, String depart) {
		super();
		this.m_num = m_num;
		this.c_num = c_num;
		this.g_num = g_num;
		this.d_num = d_num;
		this.r_num = r_num;
		this.authority = authority;
		this.role = role;
		this.g_name = g_name;
		this.email = email;
		this.depart = depart;
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

	public int getG_num() {
		return g_num;
	}

	public void setG_num(int g_num) {
		this.g_num = g_num;
	}

	public int getD_num() {
		return d_num;
	}

	public void setD_num(int d_num) {
		this.d_num = d_num;
	}

	public int getR_num() {
		return r_num;
	}

	public void setR_num(int r_num) {
		this.r_num = r_num;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	@Override
	public String toString() {
		return "MemberVO [m_num=" + m_num + ", c_num=" + c_num + ", g_num=" + g_num + ", d_num=" + d_num + ", r_num="
				+ r_num + ", authority=" + authority + ", role=" + role + ", g_name=" + g_name + ", email=" + email
				+ ", depart=" + depart + "]";
	}

	
	
}
