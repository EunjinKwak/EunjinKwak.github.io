package com.spring.withwork.vo;

import org.springframework.web.util.UriComponentsBuilder;

public class SearchGroupCri {
	
	private int pageNum;
	private int amount;
	
	private String type;
	
	public SearchGroupCri() {
		this(1,10);
	}
	
	public SearchGroupCri(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public String[] getTypeArr() {
		
		return type==null ? new String[] {} : type.split("");
	}
	
	public String getListLink() {
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.pageNum)
				.queryParam("amount", this.getAmount())
				.queryParam("type", this.getType());
		
		return builder.toUriString();
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "SearchGroupCri [pageNum=" + pageNum + ", amount=" + amount + ", type=" + type + "]";
	}
	
	
}
