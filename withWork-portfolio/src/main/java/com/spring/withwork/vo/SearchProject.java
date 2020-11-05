package com.spring.withwork.vo;

public class SearchProject {
	
	private int c_num;
	
	private String type;
	private String keyword;

	public SearchProject() {

	}

	public SearchProject(String type, String keyword, int c_num) {
		this.type = type;
		this.keyword = keyword;
		this.c_num = c_num;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public int getC_num() {
		return c_num;
	}

	public void setC_num(int c_num) {
		this.c_num = c_num;
	}

	@Override
	public String toString() {
		return "SearchProject [c_num=" + c_num + ", type=" + type + ", keyword=" + keyword + "]";
	}
	
}
