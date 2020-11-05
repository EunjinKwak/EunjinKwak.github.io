package com.bc.model.vo;

public class SelectVO {
	private String d_num, subject, subjectnum;

	public SelectVO() {}

	public SelectVO(String d_num, String subject, String subjectnum) {
		super();
		this.d_num = d_num;
		this.subject = subject;
	}

	public String getSubjectnum() {
		return subjectnum;
	}

	public void setSubjectnum(String subjectnum) {
		this.subjectnum = subjectnum;
	}

	public String getD_num() {
		return d_num;
	}

	public void setD_num(String d_num) {
		this.d_num = d_num;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "SelectVO [d_num=" + d_num + ", subject=" + subject + ", subjectnum=" + subjectnum + "]";
	}


		
	
}
