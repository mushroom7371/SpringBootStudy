package com.sb.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.study.dao.StudyDao;
import com.sb.study.vo.StudyVo;

@Service
public class StudyService {
	
	@Autowired
	StudyDao studyDao;
	
	public List<StudyVo> selectStudyMember() {
		return studyDao.selectStudyMember();
	}
	
	public StudyVo viewStudyMember(StudyVo vo) {
		return studyDao.viewStudyMember(vo);
	}
	
	public int insertStudyMember(StudyVo vo) {

		return studyDao.insertStudyMember(vo);
	}
}
