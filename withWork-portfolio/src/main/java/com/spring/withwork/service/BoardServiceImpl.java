package com.spring.withwork.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.withwork.dao.ConfirmDaoMybatis;
import com.spring.withwork.vo.ConfirmVO;
import com.spring.withwork.vo.Criteria;

@Service("BoardService")
public class BoardServiceImpl implements BoardService {

	@Inject
	private ConfirmDaoMybatis dao;
	
	//게시물 목록 조회
	@Override
	public List<ConfirmVO> list(Criteria cri) throws Exception {
		return dao.list(cri);
	}
	
	@Override
	public List<ConfirmVO> list2(Criteria cri) throws Exception {
		return dao.list2(cri);
	}
	
	@Override
	public List<ConfirmVO> list3(Criteria cri) throws Exception {
		return dao.list3(cri);
	}

	
	@Override
	public int listCount() throws Exception {
		return dao.listCount();
	}


}
