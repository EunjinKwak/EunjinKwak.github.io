package com.spring.withwork.service;

import java.util.List;

import com.spring.withwork.vo.CompanyVO;
import com.spring.withwork.vo.DepartmentVO;
import com.spring.withwork.vo.GuestVO;
import com.spring.withwork.vo.RolesVO;
import com.spring.withwork.vo.SearchGroupCri;

public interface MainService {

	public void register(GuestVO guest) throws Exception;

	// 1012수정 (박실)
	public int checkId(String email);

	public String findId(GuestVO guest);

	public int chkId(GuestVO guest);

	public int updatePwd(GuestVO guest);

	public void updateAuthStatus(GuestVO guest);

	public String otherLogin(GuestVO guest);
	
	// 1009수정 (최은서)
	public GuestVO guestInfo(GuestVO guest);

	// 1012수정 (박실)
	public int insertGroup(CompanyVO company);

	public int googleRegister(GuestVO guest);

	public int kakaoRegister(GuestVO guest);

	public int updateName(GuestVO guest);

	public int checkPwd(GuestVO guest);

	public void withdrawal(GuestVO guest);

	public String login(GuestVO guest);

	// 1009수정 (최은서)
	public List<GuestVO> getProjectMe(GuestVO guest);
	
	// 1013추가 (박실)
	public List<RolesVO> getRoles(String c_num);

	// 1013추가 (박실)
	public List<RolesVO> getDept(String c_num);

	// 1013추가 (박실)
	public int updateMember(DepartmentVO dept);

	// 1014추가 (박실)
	public List<CompanyVO> getGroupList(SearchGroupCri cri);

	// 1014추가 (박실)
	public CompanyVO getGroup(String c_num);

	// 1014추가 (박실)
	public int getTotal(SearchGroupCri cri);
	
}
