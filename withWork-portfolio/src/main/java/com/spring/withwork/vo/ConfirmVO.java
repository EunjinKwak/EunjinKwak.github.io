package com.spring.withwork.vo;

public class ConfirmVO {
	
	//verification
	public int v_num;
	public int t_num;
	public String state;
	public String feedback;
	public String confirmdate;
	public String finaldate;

	
	//todo
	public int p_num;
	public int d_num;
	public String title;
	public String text;
	public String orderdate;
	public String enddate;
	public int order_m;
	public String orderer;
	public int worker_m;
	public String worker;
	public String progress;
	public int edit_num;
	
	public int getV_num() {
		return v_num;
	}
	public void setV_num(int v_num) {
		this.v_num = v_num;
	}
	public int getT_num() {
		return t_num;
	}
	public void setT_num(int t_num) {
		this.t_num = t_num;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getConfirmdate() {
		return confirmdate;
	}
	public void setConfirmdate(String confirmdate) {
		this.confirmdate = confirmdate;
	}
	public int getP_num() {
		return p_num;
	}
	public void setP_num(int p_num) {
		this.p_num = p_num;
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
	public int getWorker_m() {
		return worker_m;
	}
	public void setWorker_m(int worker_m) {
		this.worker_m = worker_m;
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	public int getEdit_num() {
		return edit_num;
	}
	public void setEdit_num(int edit_num) {
		this.edit_num = edit_num;
	}
	
	
	
	public String getFinaldate() {
		return finaldate;
	}
	public void setFinaldate(String finaldate) {
		this.finaldate = finaldate;
	}
	public String getOrderer() {
		return orderer;
	}
	public void setOrderer(String orderer) {
		this.orderer = orderer;
	}
	public String getWorker() {
		return worker;
	}
	public void setWorker(String worker) {
		this.worker = worker;
	}
	@Override
	public String toString() {
		return "ConfirmVO [v_num=" + v_num + ", t_num=" + t_num + ", state=" + state + ", feedback=" + feedback
				+ ", confirmdate=" + confirmdate + ", finaldate=" + finaldate + ", p_num=" + p_num + ", d_num=" + d_num
				+ ", title=" + title + ", text=" + text + ", orderdate=" + orderdate + ", enddate=" + enddate
				+ ", order_m=" + order_m + ", orderer=" + orderer + ", worker_m=" + worker_m + ", worker=" + worker
				+ ", progress=" + progress + ", edit_num=" + edit_num + "]";
	}
	
	
	
	
	
}
