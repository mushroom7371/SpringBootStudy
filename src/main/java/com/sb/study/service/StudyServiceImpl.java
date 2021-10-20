package com.sb.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.study.dao.StudyDao;
import com.sb.study.vo.StudyVo;

@Service
public class StudyServiceImpl implements StudyService {
	
	@Autowired
	StudyDao studyDao;

	@Override
	public List<StudyVo> selectStudyMember(StudyVo vo) {
		// TODO Auto-generated method stub
		return studyDao.selectStudyMember(vo);
	}
	
	@Override
	public int insertStudyMember(StudyVo vo) {
		// TODO Auto-generated method stub

		return studyDao.insertStudyMember(vo);
	}

}
