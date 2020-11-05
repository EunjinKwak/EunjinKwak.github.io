package com.spring.withwork.vo;

public class SearchGroupPage {
	
	private int startPage;
	private int endPage;
	private boolean prev, next;
	
	private int total;
	private SearchGroupCri cri;
	
	public SearchGroupPage(SearchGroupCri cri, int total) {
		
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0)) * 10;
		this.startPage = this.endPage - 9;
		
		int realEnd = (int)(Math.ceil((total * 1.0) / cri.getAmount()));
		
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		
		this.next = this.endPage < realEnd;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	public int getTotal() {
		return total;
	}

	public SearchGroupCri getCri() {
		return cri;
	}

	@Override
	public String toString() {
		return "SearchGroupPage [startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next
				+ ", total=" + total + "]";
	}
	
	
}
