package com.sb.study.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sb.study.vo.StudyAttVo;

@Controller
public class FileUploadController {
	
	final static String saveDir = "C:\\eclipse\\workspace\\SpringBootStudy\\BootStudy\\src\\main\\webapp\\upload\\";
	
	public List<StudyAttVo> upload(HttpServletRequest req) {
		
		List<StudyAttVo> attList = null;
		
		try {
			req.setCharacterEncoding("utf-8");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSS");
			
			String contentType = req.getContentType();
	
			if(contentType.toLowerCase().startsWith("multipart/")) {
				
				attList = new ArrayList<StudyAttVo>();
			
				Collection<Part> parts = req.getParts();
				for(Part p : parts) {
					if( p.getHeader("Content-Disposition").contains("filename=")) { // file tag
						String fileName = p.getSubmittedFileName();
						StudyAttVo attVo = new StudyAttVo();
						
						String date = sdf.format(new Date());
						
						if(p.getSize()>0) {
							p.write(saveDir + date + "-" + fileName);
							p.delete();
	
							attVo.setSysAtt(date + "-" + fileName);
							attVo.setOriAtt(fileName);
							attList.add(attVo);
						}
					}
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return attList;
	}


}
