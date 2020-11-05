package com.bc.model.vo;

public class SearchMap {
	String search1 = "";
	String keyword = "";
	int  begin= 0;
	int end = 0;
	
	
	public SearchMap() {
		super();
	}
	
	public SearchMap(String search1, String keyword, int begin, int end) {
		super();
		this.search1 = search1;
		this.keyword = keyword;
		this.begin = begin;
		this.end = end;
	}

	public String getSearch1() {
		return search1;
	}
	public void setSearch1(String search1) {
		this.search1 = search1;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	@Override
	public String toString() {
		return "SearchMap [search1=" + search1 + ", keyword=" + keyword + ", begin=" + begin + ", end=" + end + "]";
	}
	
}
