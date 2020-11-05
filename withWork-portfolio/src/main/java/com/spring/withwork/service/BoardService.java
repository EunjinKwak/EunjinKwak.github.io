package com.spring.withwork.service;

import java.util.List;

import com.spring.withwork.vo.ConfirmVO;
import com.spring.withwork.vo.Criteria;

public interface BoardService {
	
	//게시물 목록 조회
	public List<ConfirmVO> list(Criteria cri) throws Exception;
	
	//게시물 목록 (결재처리)
	public List<ConfirmVO> list2(Criteria cri) throws Exception;
	
	public List<ConfirmVO> list3(Criteria cri) throws Exception;
	
	//게시물 총 갯수
	public int listCount() throws Exception;
	
	
}
