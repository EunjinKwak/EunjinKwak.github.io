package com.bc.model.vo;

public class SearchListVO {
	
	String search;
	String keyword;
	int  begin= 0;
	int end= 0;
	
	
	public SearchListVO() {
		super();
	}


	public SearchListVO(String search, String keyword, int begin, int end) {
		super();
		this.search = search;
		this.keyword = keyword;
		this.begin = begin;
		this.end = end;
	}


	public String getSearch() {
		return search;
	}


	public void setSearch(String search) {
		this.search = search;
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
		return "SearchListVO [search=" + search + ", keyword=" + keyword + ", begin=" + begin + ", end=" + end + "]";
	}
	
	
	
	

}
