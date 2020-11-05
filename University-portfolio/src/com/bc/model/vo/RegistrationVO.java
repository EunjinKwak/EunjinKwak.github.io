package com.bc.model.vo;

public class RegistrationVO {
	private String hakbun;
	private String subjectnum;
	private String subject;
	private String name;
	private String time;
	private String classroom;
	private int grade = 0;
	private String d_num;
	private String f_num;
	private int personnel = 0;
	
	
	public String getHakbun() {
		return hakbun;
	}
	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}
	public String getSubjectnum() {
		return subjectnum;
	}
	public void setSubjectnum(String subjectnum) {
		this.subjectnum = subjectnum;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getD_num() {
		return d_num;
	}
	public void setD_num(String d_num) {
		this.d_num = d_num;
	}
	public String getF_num() {
		return f_num;
	}
	public void setF_num(String f_num) {
		this.f_num = f_num;
	}
	public int getPersonnel() {
		return personnel;
	}
	public void setPersonnel(int personnel) {
		this.personnel = personnel;
	}
	@Override
	public String toString() {
		return "RegistrationVO [hakbun=" + hakbun + ", subjectnum=" + subjectnum + ", subject=" + subject + ", name="
				+ name + ", time=" + time + ", classroom=" + classroom + ", grade=" + grade + ", d_num=" + d_num
				+ ", f_num=" + f_num + ", personnel=" + personnel + "]";
	}
	
	
	
	
	
}
