package com.bc.model.vo;

public class StudentVO {
	String hakbun;
	String name;
	String password;
	String email;
	String phone;
	String d_num;
	int s_grade = 0;
	
	public StudentVO(String hakbun, String name, String password, String email, String phone, String d_num,
			int s_grade) {
		super();
		this.hakbun = hakbun;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.d_num = d_num;
		this.s_grade = s_grade;
	}
	
	
	public StudentVO(String hakbun, String name, String password, String email, String phone, String d_num) {
		super();
		this.hakbun = hakbun;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.d_num = d_num;
	}


	public StudentVO() {
		super();
	}
	
	public String getHakbun() {
		return hakbun;
	}
	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getD_num() {
		return d_num;
	}
	public void setD_num(String d_num) {
		this.d_num = d_num;
	}
	public int getS_grade() {
		return s_grade;
	}
	public void setS_grade(int s_grade) {
		this.s_grade = s_grade;
	}
	@Override
	public String toString() {
		return "StudentVO [hakbun=" + hakbun + ", name=" + name + ", password=" + password + ", email=" + email
				+ ", phone=" + phone + ", d_num=" + d_num + ", s_grade=" + s_grade + "]";
	}
	
	
	
	
	
}
