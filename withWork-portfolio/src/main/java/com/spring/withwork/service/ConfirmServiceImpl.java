package com.spring.withwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.withwork.dao.*;
import com.spring.withwork.vo.ConfirmVO;

@Service("ConfirmService")
public class ConfirmServiceImpl implements ConfirmService{

	@Autowired
	private ConfirmDaoMybatis ConfirmDaoMybatis;

	//�Խñ� ����
	@Override
	public void updateConfirm(ConfirmVO confirm) throws Exception {
		ConfirmDaoMybatis.updateConfirm(confirm);
	}
	//�Խñ� ��� ��ȸ
	@Override
	public List<ConfirmVO> getAllConfirm(ConfirmVO confirm) {
		return ConfirmDaoMybatis.getAllConfirm(confirm);
	}
	@Override
	public ConfirmVO selectConfirm(ConfirmVO confirm) throws Exception {
		return ConfirmDaoMybatis.selectConfirm(confirm);
		
	}
	
	@Override
	public void updateAll(ConfirmVO confirm) throws Exception {
		ConfirmDaoMybatis.updateAll(confirm);
		
	}
	@Override
	public void finishTodo(ConfirmVO confirm) {
		ConfirmDaoMybatis.finishTodo(confirm);
		
	}
	

}
