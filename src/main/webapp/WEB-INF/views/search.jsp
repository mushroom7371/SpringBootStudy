<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<script src='/js/functions.js'></script>
<title>search page</title>
</head>
<style>
#index form>label{
	display:inline-block;
	width:200px;
}
</style>
<body>
	<h2>조회 페이지입니다.</h2>
	<div id='crud'>
		<form name='frm_search' id='frm_search' method='post' action=''>
			<label>이름</label>
				<input type='text' name='sName' id='sName' readonly/>
			<hr/>
		
			<label>전화 번호</label>
				<input type='text' name='sPhone' id='sPhone' readonly/>
			<hr/>
			
			<label>나이</label>
				<input type='text' name='sAge' id='sAge' readonly/>
			<hr/>
			
			<input type='button' id='btnInsert' value='정보 저장페이지로'/>
			<input type='button' id='btnIndex' value='초기화면으로'/>
		</form>
	</div>
<script>
crud.init();
</script>	
</body>
</html>