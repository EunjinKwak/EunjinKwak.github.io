package com.bc.model.vo;

public class CR_BBSVO {
	private String b_idx, subjectnum, title, writer,	
					writer_date, content,hakbun;
	private int hit;
	public CR_BBSVO() {}
	
	public String getB_idx() {
		return b_idx;
	}
	public void setB_idx(String b_idx) {
		this.b_idx = b_idx;
	}
	public String getSubjectnum() {
		return subjectnum;
	}
	public void setSubjectnum(String subjectnum) {
		this.subjectnum = subjectnum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWriter_date() {
		return writer_date;
	}
	public void setWriter_date(String writer_date) {
		this.writer_date = writer_date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	public String getHakbun() {
		return hakbun;
	}
	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}
	@Override
	public String toString() {
		return "CR_BBSVO [b_idx=" + b_idx + ", subjectnum=" + subjectnum + ", title=" + title + ", writer=" + writer
				+ ", writer_date=" + writer_date + ", content=" + content + ", hakbun=" + hakbun + ", hit=" + hit + "]";
	}

	
}
