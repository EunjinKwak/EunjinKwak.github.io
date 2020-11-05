package com.spring.withwork.vo;

public class RolesVO {
	
	private int r_num;
	private int g_num;
	private int c_num;
	private String role;
	
	public RolesVO() {
		
	}
	public RolesVO(int r_num, int g_num, int c_num, String role) {
		this.r_num = r_num;
		this.g_num = g_num;
		this.c_num = c_num;
		this.role = role;
	}
	
	public int getR_num() {
		return r_num;
	}
	public void setR_num(int r_num) {
		this.r_num = r_num;
	}
	public int getG_num() {
		return g_num;
	}
	public void setG_num(int g_num) {
		this.g_num = g_num;
	}
	public int getC_num() {
		return c_num;
	}
	public void setC_num(int c_num) {
		this.c_num = c_num;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "RolesVO [r_num=" + r_num + ", g_num=" + g_num + ", c_num=" + c_num + ", role=" + role + "]";
	}
	
	
}
