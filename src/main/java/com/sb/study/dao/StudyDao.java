package com.sb.study.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sb.study.vo.StudyVo;

@Mapper
public interface StudyDao {

	public List<StudyVo> selectStudyMember(StudyVo vo);
	public int insertStudyMember(StudyVo vo);
}
