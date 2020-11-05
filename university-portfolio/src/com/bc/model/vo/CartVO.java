package com.bc.model.vo;

public class CartVO {
	private String hakbun;
	private String subjectnum;
	private String subject;
	private String name;
	private String time;
	private String classroom;
	private int grade;
	private int personnel;
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
	public int getPersonnel() {
		return personnel;
	}
	public void setPersonnel(int personnel) {
		this.personnel = personnel;
	}
	@Override
	public String toString() {
		return "CartVO [hakbun=" + hakbun + ", subjectnum=" + subjectnum + ", subject=" + subject + ", name=" + name
				+ ", time=" + time + ", classroom=" + classroom + ", grade=" + grade + ", personnel=" + personnel + "]";
	}
	
	
}
