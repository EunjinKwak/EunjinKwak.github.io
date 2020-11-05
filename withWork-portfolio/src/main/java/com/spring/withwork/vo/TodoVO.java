package com.spring.withwork.vo;

public class TodoVO {
	private int t_num;
	private int p_num;
	private String p_name;
	private int d_num;
	private String title;
	private String text;
	private String orderdate;
	private String enddate;
	private int order_m;
	private String orderer;
	private String depart;
	private String o_role;
	private int worker_m;
	private String worker;
	private String w_depart;
	private String w_role;
	private String progress;
	private int betweendate;
	private int edit_num;
	
	public TodoVO() {

	}

	public int getT_num() {
		return t_num;
	}

	public void setT_num(int t_num) {
		this.t_num = t_num;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getD_num() {
		return d_num;
	}

	public void setD_num(int d_num) {
		this.d_num = d_num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public int getOrder_m() {
		return order_m;
	}

	public void setOrder_m(int order_m) {
		this.order_m = order_m;
	}

	public String getOrderer() {
		return orderer;
	}

	public void setOrderer(String orderer) {
		this.orderer = orderer;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getO_role() {
		return o_role;
	}

	public void setO_role(String o_role) {
		this.o_role = o_role;
	}

	public int getWorker_m() {
		return worker_m;
	}

	public void setWorker_m(int worker_m) {
		this.worker_m = worker_m;
	}

	public String getWorker() {
		return worker;
	}

	public void setWorker(String worker) {
		this.worker = worker;
	}

	public String getW_depart() {
		return w_depart;
	}

	public void setW_depart(String w_depart) {
		this.w_depart = w_depart;
	}

	public String getW_role() {
		return w_role;
	}

	public void setW_role(String w_role) {
		this.w_role = w_role;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public int getBetweendate() {
		return betweendate;
	}

	public void setBetweendate(int betweendate) {
		this.betweendate = betweendate;
	}

	public int getEdit_num() {
		return edit_num;
	}

	public void setEdit_num(int edit_num) {
		this.edit_num = edit_num;
	}

	@Override
	public String toString() {
		return "TodoVO [t_num=" + t_num + ", p_num=" + p_num + ", p_name=" + p_name + ", d_num=" + d_num + ", title="
				+ title + ", text=" + text + ", orderdate=" + orderdate + ", enddate=" + enddate + ", order_m="
				+ order_m + ", orderer=" + orderer + ", depart=" + depart + ", o_role=" + o_role + ", worker_m="
				+ worker_m + ", worker=" + worker + ", w_depart=" + w_depart + ", w_role=" + w_role + ", progress="
				+ progress + ", betweendate=" + betweendate + ", edit_num=" + edit_num + "]";
	}
}
