package com.spring.withwork.vo;

import java.sql.Date;

public class ProjectVO {

	private int p_num;
	private int c_num;
	private String name;
	private int m_num;
	private Date startDate;
	private Date endDate;
	private Date regDate;
	private String status;
	private String id;
	private String content;
	private String subject;
	// 프로젝트 리스트 출력시 관리자 이름 호출
	private String g_name;
	private String p_name;
	private String depart;
	//1013 추가(박실)
	private String role;
	
	public ProjectVO() {
		
	}

	public ProjectVO(int p_num, int c_num, String name, int m_num, Date startDate, Date endDate, Date regDate,
			String status, String id, String content, String subject, String g_name, String p_name, String depart, String role) {
		super();
		this.p_num = p_num;
		this.c_num = c_num;
		this.name = name;
		this.m_num = m_num;
		this.startDate = startDate;
		this.endDate = endDate;
		this.regDate = regDate;
		this.status = status;
		this.id = id;
		this.content = content;
		this.subject = subject;
		this.g_name = g_name;
		this.p_name = p_name;
		this.depart = depart;
		this.role = role;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getM_num() {
		return m_num;
	}

	public void setM_num(int m_num) {
		this.m_num = m_num;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "ProjectVO [p_num=" + p_num + ", c_num=" + c_num + ", name=" + name + ", m_num=" + m_num + ", startDate="
				+ startDate + ", endDate=" + endDate + ", regDate=" + regDate + ", status=" + status + ", id=" + id
				+ ", content=" + content + ", subject=" + subject + ", g_name=" + g_name + ", p_name=" + p_name
				+ ", depart=" + depart + ", role=" + role + "]";
	}

}
