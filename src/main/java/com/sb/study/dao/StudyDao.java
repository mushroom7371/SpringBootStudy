package com.sb.study.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sb.study.vo.PagingVo;
import com.sb.study.vo.StudyAttVo;
import com.sb.study.vo.StudyVo;

//Data Access Object의 약자인 Dao. DB의 데이터에 접근하기 위해 생성함.
//DB에 접근하는 로직과 이를 받아 처리하는 비즈니스 로직을 분리하기 위해 사용함.

//interface로 선언 하였으므로 이를 구현할 클래스가 필요함. 해당 프로젝트에서는 service에서 구현 한다.
//매핑을 통하여 xml에서는 namespace를 통해 interface를 찾고, id로 메서드명을 구별한다.
@Mapper
public interface StudyDao {

	//추상메서드로 정의 되어있기에 내용이 없다.
	public List<StudyVo> selectStudyMember();
	public StudyVo viewStudyMember(String sPhone);
	public int insertStudyMember(StudyVo vo);
	public void modifyStudyMember(StudyVo vo);
	public void deleteStudyMember(String sPhone);
	public List<StudyVo> selectPaging(PagingVo vo);
	public int countBoard();
	public int fileUpload(List<StudyAttVo> vo);
	
}
