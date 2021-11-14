package com.sb.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.study.dao.StudyDao;
import com.sb.study.vo.PagingVo;
import com.sb.study.vo.StudyAttVo;
import com.sb.study.vo.StudyVo;

//기존엔 service, serviceImpl 두개가 있었으나 하나로 통일하였다.
//interface를 사용하여 구현하는 이유는 다형성을 위함이지만, 1:1 매칭을 하게 되면 interface의 의미가 없으므로 사용하지 않음

//Service는 request에 대하여 어떤 처리를 할지 결정함. 
//Controller가 받은 요청에 알맞는 정보를 가공해서 Controller에 데이터를 넘긴다.
@Service
public class StudyService {
	
	@Autowired
	StudyDao studyDao;
	
	public int fileUpload(List<StudyAttVo> vo){
		return studyDao.fileUpload(vo);
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
