package com.spring.withwork.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.withwork.vo.ConfirmVO;
import com.spring.withwork.vo.Criteria;

@Repository("ConfirmDaoMybatis")
public class ConfirmDaoMybatis {
	
	@Autowired
	private SqlSessionTemplate mybatis;
		
		public ConfirmDaoMybatis() {
		
		}
		//�Խù� ���
		public List<ConfirmVO> getAllConfirm(ConfirmVO confirm) { 
			return mybatis.selectList("ConfirmDao.getAllConfirm", confirm);
		}
		
		//�� ����
		public void updateConfirm(ConfirmVO confirm) {
			mybatis.update("ConfirmDao.updateConfirm", confirm);
		}
		
		//�� �ҷ�����
		public ConfirmVO selectConfirm(ConfirmVO confirm) {
			return mybatis.selectOne("ConfirmDao.selectConfirm", confirm);
		}
		
		public void updateAll(ConfirmVO confirm) {
			mybatis.update("ConfirmDao.updateAll", confirm);
			
		}
		
		public void finishTodo(ConfirmVO confirm) {
			mybatis.update("ConfirmDao.finishTodo", confirm);
			
		}
		
		//�Խù� ��� ��ȸ
		public List<ConfirmVO> list(Criteria cri) throws Exception {
			return mybatis.selectList("ConfirmDao.listPage",cri);
		}
		
		public List<ConfirmVO> list2(Criteria cri) throws Exception {
			return mybatis.selectList("ConfirmDao.listPage2", cri);
		}
		
		public List<ConfirmVO> list3(Criteria cri) throws Exception {
			return mybatis.selectList("ConfirmDao.listPage3", cri);
		}
		
		
		//�Խù� �� ����
		public int listCount() throws Exception {
			return mybatis.selectOne("ConfirmDao.listCount");
		}
		
}
