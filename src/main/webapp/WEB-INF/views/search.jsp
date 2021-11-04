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
				<span class='seq'>번호</span>
				<span class='sName'>이름</span>
				<span class='sPhone'>전화번호</span>
				<span class='sAge'>나이</span>
			</div>
		<hr>
			
			<div class='items'>
				<c:forEach var='vo' items="${viewAll}">
					<div class='item' onclick="crud.view('${vo.sPhone}')">
						<span class='seq'>${vo.seq }</span>
						<span class='sName'>${vo.sName }</span>
						<span class='sPhone'>${vo.sPhone }</span>
						<span class='sAge'>${vo.sAge }</span>
					</div>
				</c:forEach>
			</div>
			
			<hr>
			
			<div id='btn_zone'>
				<c:if test="${paging.startPage>1 }">
					<input type='button' value='맨처음' onclick='crud.move(1)'/>
					<input type='button' value='이전' onclick='crud.move(${paging.startPage-1})'/>
				</c:if>
				
				<c:forEach var='p' begin='${paging.startPage }' end='${paging.endPage }'>
					<input type='button' value='${p }' onclick='crud.move(${p })'/>
				</c:forEach>
				
				<c:if test="${paging.endPage<paging.lastPage }">
					<input type='button' value='다음' onclick='crud.move(${paging.endPage+1 })'/>
					<input type='button' value='맨끝' onclick='crud.move(${paging.lastPage })'/>
				</c:if>
			</div>

			<hr>

			<input type='button' id='btnSearchR' value='조회'/>
			<input type='button' id='btnInsert' value='정보 저장페이지로'/>
			<input type='button' id='btnIndex' value='초기화면으로'/>
			
			<input type='hidden' name='sPhone' value='${param.sPhone }'/>	
			<input type='hidden' name='nowPage' value='${(empty param.nowPage)? 1 : param.nowPage }'/>
		</form>
	</div>
<script>
crud.init();
</script>	
</body>
</html>