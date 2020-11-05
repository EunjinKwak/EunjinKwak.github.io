package com.spring.withwork.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.withwork.vo.ProjectVO;
import com.spring.withwork.vo.RolesVO;
import com.spring.withwork.vo.SearchProject;

@Repository
public class RoadmapDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	// 1013수정 (박실)
	public int insertProject(ProjectVO prj) {
		return mybatis.insert("RoadmapMapper.insertProject", prj);
	}

	public List<ProjectVO> prjList(String c_num) {
		return mybatis.selectList("RoadmapMapper.prjList", c_num);
	}

	public ProjectVO getPrj(String p_num) {
		return mybatis.selectOne("RoadmapMapper.getPrj", p_num);
	}

	public List<ProjectVO> managerList(int c_num) {
		return mybatis.selectList("RoadmapMapper.managerList", c_num);
	}

	public int updateProject(ProjectVO prj) {
		return mybatis.update("RoadmapMapper.updateProject", prj);
	}

	public List<ProjectVO> searchProject(SearchProject sp) {
		return mybatis.selectList("RoadmapMapper.searchProject", sp);
	}

	public int insertJoiner(ProjectVO prj) {
		return mybatis.insert("RoadmapMapper.insertJoiner", prj);
		
	}

}
