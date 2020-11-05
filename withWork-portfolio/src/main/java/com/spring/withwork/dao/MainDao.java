package com.spring.withwork.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.withwork.vo.CompanyVO;
import com.spring.withwork.vo.DepartmentVO;
import com.spring.withwork.vo.GuestVO;
import com.spring.withwork.vo.MemberVO;
import com.spring.withwork.vo.RolesVO;
import com.spring.withwork.vo.SearchGroupCri;
import com.spring.withwork.vo.SearchProject;

@Repository
public class MainDao {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void register(GuestVO guest) {
		mybatis.insert("MainMapper.register", guest);
	}

	// 1012수정 (박실)
	public int checkId(String email) {
		return mybatis.selectOne("MainMapper.checkId", email);
	}

	public String findId(GuestVO guest) {
		return mybatis.selectOne("MainMapper.findId", guest);
	}

	public int chkId(GuestVO guest) {
		return mybatis.selectOne("MainMapper.chkId", guest);
	}

	public int updatePwd(GuestVO guest) {
		return mybatis.update("MainMapper.updatePwd", guest);
	}

	public void updateAuthKey(GuestVO guest) {
		mybatis.update("MainMapper.updateAuthKey", guest);
		
	}

	public void updateAuthStatus(GuestVO guest) {
		mybatis.update("MainMapper.updateAuthStatus", guest);
	}

	public int login(GuestVO guest) {
		return mybatis.selectOne("MainMapper.login", guest);
	}
	
	// 1009수정 (최은서)
	public GuestVO guestInfo(GuestVO guest) {
		return mybatis.selectOne("MainMapper.guestInfo", guest);
	}

	// 1012수정 (박실)
	public int insertGroup(CompanyVO company) {
		return mybatis.insert("MainMapper.insertGroup", company);
	}

	public String otherLogin(GuestVO guest) {
		return mybatis.selectOne("MainMapper.otherLogin", guest);
	}

	public int googleRegister(GuestVO guest) {
		return mybatis.insert("MainMapper.googleRegister", guest);
	}

	public int kakaoRegister(GuestVO guest) {
		return mybatis.insert("MainMapper.kakaoRegister", guest);
	}

	public int updateName(GuestVO guest) {
		return mybatis.update("MainMapper.updateName", guest);
	}

	public int checkPwd(GuestVO guest) {
		return mybatis.selectOne("MainMapper.checkPwd", guest);
	}

	public void withdrawal(GuestVO guest) {
		mybatis.update("MainMapper.withdrawal", guest);
	}
	
	// 1009수정 (최은서)
	public List<GuestVO> getProjectMe(GuestVO guest) {
		return mybatis.selectList("MainMapper.getProjectMe", guest);
	}

	// 1012추가 (박실)
	public int insertRoles(List<CompanyVO> roleList) {
		return mybatis.insert("MainMapper.insertRoles", roleList);
	}

	// 1012추가 (박실)
	public int insertDept(List<DepartmentVO> deptList) {
		return mybatis.insert("MainMapper.insertDept", deptList);
	}

	// 1012추가 (박실)
	public int insertMember(MemberVO member) {
		return mybatis.insert("MainMapper.insertMember", member);
	}
	
	// 1013추가 (박실)
	public List<RolesVO> getRoles(String c_num) {
		return mybatis.selectList("MainMapper.getRoles", c_num);
	}

	// 1013추가 (박실)
	public List<RolesVO> getDept(String c_num) {
		return mybatis.selectList("MainMapper.getDept", c_num);
	}

	// 1013추가 (박실)
	public int updateMember(DepartmentVO dept) {
		return mybatis.update("MainMapper.updateMember", dept);
	}

	// 1014추가 (박실)
	public List<CompanyVO> getGroupList(SearchGroupCri cri) {
		//임시
		return mybatis.selectList("MainMapper.getGroupList", cri);
	}

	// 1014추가 (박실)
	public CompanyVO getGroup(String c_num) {
		return mybatis.selectOne("MainMapper.getGroup", c_num);
	}

	// 1014추가 (박실)
	public int getTotal(SearchGroupCri cri) {
		return mybatis.selectOne("MainMapper.getTotal", cri);
	}
}
