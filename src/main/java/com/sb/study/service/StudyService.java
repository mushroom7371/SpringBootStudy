package com.sb.study.service;

import java.util.List;

import com.sb.study.vo.StudyVo;

public interface StudyService {
	List<StudyVo> selectStudyMember(StudyVo vo);
	int insertStudyMember(StudyVo vo);
}
