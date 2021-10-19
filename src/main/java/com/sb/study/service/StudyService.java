package com.sb.study.service;

import java.util.List;

import com.sb.study.vo.StudyVo;

public interface StudyService {
	List<StudyVo> selectStudyMember(StudyVo vo);
	List<StudyVo> insertStudyMember(StudyVo vo);
}
