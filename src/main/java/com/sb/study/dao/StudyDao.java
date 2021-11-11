package com.sb.study.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sb.study.vo.PagingVo;
import com.sb.study.vo.StudyAttVo;
import com.sb.study.vo.StudyVo;

@Mapper
public interface StudyDao {

	public List<StudyVo> selectStudyMember();
	public StudyVo viewStudyMember(String sPhone);
	public int insertStudyMember(StudyVo vo);
	public void modifyStudyMember(StudyVo vo);
	public void deleteStudyMember(String sPhone);
	public List<StudyVo> selectPaging(PagingVo vo);
	public int countBoard();
	public List<StudyAttVo> fileUpload(List<StudyAttVo> vo);
	
}
