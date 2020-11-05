package com.spring.withwork.service;

import java.util.List;

import com.spring.withwork.vo.ConfirmVO;

public interface ConfirmService {
	void updateConfirm(ConfirmVO confirm) throws Exception;
	
	void updateAll(ConfirmVO confirm) throws Exception;
	
	//�Խñ� ��� ��ȸ
	List<ConfirmVO> getAllConfirm(ConfirmVO confirm);
	
	public void finishTodo(ConfirmVO confirm);

	
	ConfirmVO selectConfirm(ConfirmVO confirm) throws Exception;
	
}
