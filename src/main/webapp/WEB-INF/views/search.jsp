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
			<div class='title'>
				<span class='irum'>이름</span>
				<span class='phoneNum'>전화번호</span>
				<span class='nai'>나이</span>
			</div>
			
			<div class='items'>
				<c:forEach var='vo' items="${list}">
					<div class='item'>
						<span class='irum'>${vo.sName }</span>
						<span class='phoneNum'>${vo.sPhone }</span>
						<span class='nai'>${vo.sAge }</span>
					</div>
				</c:forEach>
			</div>
			
			<input type='button' id='btnSearchR' value='조회'/>
			<input type='button' id='btnInsert' value='정보 저장페이지로'/>
			<input type='button' id='btnIndex' value='초기화면으로'/>
		</form>
	</div>
<script>
crud.init();
</script>	
</body>
</html>