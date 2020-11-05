package com.bc.model.vo;

public class SubjectVO {
	private String subjectnum, subject, time, classroom, d_num, f_num, name;
	private int grade, personnel;
	
	public SubjectVO(String subjectnum, String subject, String time, String classroom, String d_num, String f_num,
			String name, int grade, int personnel) {
		super();
		this.subjectnum = subjectnum;
		this.subject = subject;
		this.time = time;
		this.classroom = classroom;
		this.d_num = d_num;
		this.f_num = f_num;
		this.name = name;
		this.grade = grade;
		this.personnel = personnel;
	}
	
	public SubjectVO() {
		super();
	}
	
	public SubjectVO(String subjectnum, String subject, String time, String classroom, String d_num, String f_num,
			int personnel) {
		super();
		this.subjectnum = subjectnum;
		this.subject = subject;
		this.time = time;
		this.classroom = classroom;
		this.d_num = d_num;
		this.f_num = f_num;
		this.personnel = personnel;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		return "SubjectVO [subjectnum=" + subjectnum + ", subject=" + subject + ", time=" + time + ", classroom="
				+ classroom + ", d_num=" + d_num + ", f_num=" + f_num + ", name=" + name + ", grade=" + grade
				+ ", personnel=" + personnel + "]";
	}

	

	
	
}
