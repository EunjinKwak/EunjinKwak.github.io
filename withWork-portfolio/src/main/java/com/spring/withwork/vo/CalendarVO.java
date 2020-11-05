package com.spring.withwork.vo;

public class CalendarVO {
	private int p_num;
	private int c_num;
	private int m_num;
	private String name;
	private String startdate;
	private String enddate;
	private String status;
	
	public CalendarVO() {
		super();
	}

	public CalendarVO(int p_num, int c_num, int m_num, String name, String startdate, String enddate, String status) {
		super();
		this.p_num = p_num;
		this.c_num = c_num;
		this.m_num = m_num;
		this.name = name;
		this.startdate = startdate;
		this.enddate = enddate;
		this.status = status;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	public int getC_num() {
		return c_num;
	}

	public void setC_num(int c_num) {
		this.c_num = c_num;
	}

	public int getM_num() {
		return m_num;
	}

	public void setM_num(int m_num) {
		this.m_num = m_num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CalendarVO [p_num=" + p_num + ", c_num=" + c_num + ", m_num=" + m_num + ", name=" + name
				+ ", startdate=" + startdate + ", enddate=" + enddate + ", status=" + status + "]";
	}
	
	
}
