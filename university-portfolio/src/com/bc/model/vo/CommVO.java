package com.bc.model.vo;

public class CommVO {
	private String c_idx, content, writer_date, writer, b_idx ,hakbun;

	
	public CommVO(String content, String writer, String b_idx) {
		super();
		this.content = content;
		this.writer = writer;
		this.b_idx = b_idx;
	}

	public CommVO() {}

	public String getC_idx() {
		return c_idx;
	}

	public void setC_idx(String c_idx) {
		this.c_idx = c_idx;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter_date() {
		return writer_date;
	}

	public void setWriter_date(String writer_date) {
		this.writer_date = writer_date;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getB_idx() {
		return b_idx;
	}

	public void setB_idx(String b_idx) {
		this.b_idx = b_idx;
	}

	public String getHakbun() {
		return hakbun;
	}

	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}

	@Override
	public String toString() {
		return "CommVO [c_idx=" + c_idx + ", content=" + content + ", writer_date=" + writer_date + ", writer=" + writer
				+ ", b_idx=" + b_idx + ", hakbun=" + hakbun + "]";
	}

	
	
	
}
