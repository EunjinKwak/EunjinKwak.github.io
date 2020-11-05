package com.spring.withwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.withwork.dao.RoadmapDAO;
import com.spring.withwork.vo.ProjectVO;
import com.spring.withwork.vo.RolesVO;
import com.spring.withwork.vo.SearchProject;

@Service
public class RoadmapServiceImpl implements RoadmapService {

	@Autowired
	private RoadmapDAO roadmapDao;
	
	@Transactional
	@Override
	public int insertProject(ProjectVO prj) {
		
		roadmapDao.insertProject(prj);
		
		int result = roadmapDao.insertJoiner(prj);
		
		return result;
	}
	
	// 1013추가 (박실)
	@Override
	public List<ProjectVO> prjList(String c_num) {
		return roadmapDao.prjList(c_num);
	}
	
	@Override
	public ProjectVO getPrj(String p_num) {
		return roadmapDao.getPrj(p_num);
	}
	
	@Override
	public List<ProjectVO> managerList(int c_num) {
		return roadmapDao.managerList(c_num);
	}
	
	@Override
	public int updateProject(ProjectVO prj) {
		return roadmapDao.updateProject(prj);
	}
	
	@Override
	public List<ProjectVO> searchProject(SearchProject sp) {
		return roadmapDao.searchProject(sp);
	}
	
}
