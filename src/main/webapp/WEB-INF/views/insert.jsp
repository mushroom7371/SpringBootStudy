<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<script src='/js/functions.js'></script>
<title>insert page</title>
</head>
<style>
#index form>label{
	display:inline-block;
	width:200px;
}
</style>
<body>
	<h2>입력 페이지입니다.</h2>
	<div id='crud'>
		<form name='frm_insert' id='frm_insert' method='post' action=''>
			<label>이름</label>
				<input type='text' name='sName' id='sName' placeholder="홍길동"/>
			<hr/>
		
			<label>전화 번호</label>
				<input type='text' name='sPhone' id='sPhone' placeholder="010-0000-0000" maxlength="13"/>
			<hr/>
			
			<label>나이</label>
				<input type='text' name='sAge' id='sAge' placeholder="00" maxlength="2"/>
			<hr/>
			
			<input type='button' id='btnInsertR' value='정보 저장'/>
			<input type='button' id='btnSearch' value='데이터 조회 페이지로'/>
			<input type='button' id='btnIndex' value='초기화면으로'/>
		</form>
		
		<form name='frm_upload' id='frm_upload' method='post'>
			<label>파일첨부</label>
			<input type='file' name='attfile' id='attfile' multiple/>
			
			<div id='image_preview'>
			<div id='attzone'></div>
		</div>
	</form>
	</div>
	
<script>
crud.init();
</script>	
</body>
</html>