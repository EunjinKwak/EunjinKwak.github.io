package com.bc.model.vo;

public class NoticeVO {
	private String n_idx;
	private String name;
	private String title;
	private String content;
	private String email;
	private String regdate;
	private String hit;
	private String hakbun;
	
	public NoticeVO() {
		super();
	}
	public NoticeVO(String n_idx, String name, String title, String content, String email, String regdate, String hit, String hakbun) {
		super();
		this.n_idx = n_idx;
		this.name = name;
		this.title = title;
		this.content = content;
		this.email = email;
		this.regdate = regdate;
		this.hit = hit;
		this.hakbun = hakbun;
	}
	public String getN_idx() {
		return n_idx;
	}
	public String getName() {
		return name;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getEmail() {
		return email;
	}
	public String getRegdate() {
		return regdate;
	}
	public String getHit() {
		return hit;
	}
	public String getHakbun() {
		return hakbun;
	}
	public void setN_idx(String n_idx) {
		this.n_idx = n_idx;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}
	@Override
	public String toString() {
		return "NoticeVO [n_idx=" + n_idx + ", name=" + name + ", title=" + title + ", content=" + content + ", email="
				+ email + ", regdate=" + regdate + ", hit=" + hit + ", hakbun="+ hakbun + "]";
	}
	
}
