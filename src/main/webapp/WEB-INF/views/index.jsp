<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>index</title>
</head>
<body>
	<h2>인덱스</h2>
	<div id = 'index'>
		<form name='frm_index' id='frm_index' method='post' action=''>
			<input type='button' id='btnSearch' value='조회 페이지로'/>
			<input type='button' id='btnInsert' value='입력 페이지로'/>
		</form>
	</div>
</body>
<script>
$('#index #btnInsert').on('click', function(){
	$('#index').load('./insert.springboot');
})

$('#index #btnSearch').on('click', function(){
	$('#index').load('./search.springboot');
})
</script>
</html>