package com.sb.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.study.dao.StudyDao;
import com.sb.study.vo.PagingVo;
import com.sb.study.vo.StudyAttVo;
import com.sb.study.vo.StudyVo;

@Service
public class StudyService {
	
	@Autowired
	StudyDao studyDao;
	
	public List<StudyAttVo> fileUpload(){
		return studyDao.fileUpload();
	}
	
	public List<StudyVo> selectStudyMember() {
		return studyDao.selectStudyMember();
	}
	
	public int countBoard() {
		return studyDao.countBoard();
	}
	
	public List<StudyVo> selectPaging(PagingVo vo) {
		return studyDao.selectPaging(vo);
	}
	
	public StudyVo viewStudyMember(String sPhone) {
		return studyDao.viewStudyMember(sPhone);
	}
	
	public void deleteStudyMember(String sPhone) {
		studyDao.deleteStudyMember(sPhone);
	}
	
	public int insertStudyMember(StudyVo vo) {

		return studyDao.insertStudyMember(vo);
	}
	
	public void modifyStudyMember(StudyVo vo) {
		studyDao.modifyStudyMember(vo);
	}
}
