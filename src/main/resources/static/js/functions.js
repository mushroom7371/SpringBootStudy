/**
 * 테스트용
 */

//static resource로 클라이언트로 부터 요청이 들어왔을 때 요청에 대한 리소스가 이미 만들어져 있다.
//빈 객체를 생성한다. 이 이후에 function 선언을 통하여 crud.init 등으로 function에 접근 가능하다.
var crud = {};

crud.init = function(){
	$('#index #btnIndex').on('click', function(){
		$('#index').load('./');
	})
	
	$('#index #btnInsert').on('click', function(){
		$('#index').load('./insert.springboot');
		//index 영역의 btnInsert 버튼이 클릭되면 함수 실행, index 영역에 ./insert.springboot url을 호출하고 난뒤의 view를 load 한다.
	})

	$('#index #btnSearch').on('click', function(){
		$('#index').load('./search.springboot');
	})
	
	$('#index #btnSearchR').on('click', function(){
		$('#index').load('./searchR.springboot');
	})
	
	
	$('#crud #btnInsertR').on('click', function(){
		
		var frm = $('#frm_insert')[0];
		var param = $(frm).serialize();
		
		var frm2 = $('#frm_upload')[0];
		var data = new FormData(frm2);
		
		//비동기 처리
		$.ajax({
			type : 'POST',
			url : 'fup.springboot',
			enctype : 'multipart/form-data',
			data : data,
			contentType : false,	
			processData : false,	
			success : function(resp){
				$.post('./insertR.springboot', param, function(){
					$('#index').load('./search.springboot');
				})
			},
			error : function(xhr, resp, status){
				alert(resp + "," + status);
			}
		})
	})
	
	$('#crud #btnModify').on('click', function(){
		
		var frm = $('#frm_view')[0];
		var param = $(frm).serialize();
		
		$.ajax({
			type    : 'POST',
			url     : './modify.springboot',
			data    : param,
			success : function(resp){
				$('#index').load('./search.springboot');
			}
		})
	})
	
	$('#index #btnDelete').on('click', function(){
		
		var frm = $('#frm_view')[0];
		var param = $(frm).serialize();
		
		$.ajax({
			type    : 'POST',
			url     : './delete.springboot',
			data    : param,
			success : function(resp){
				$('#index').load('./search.springboot');
			}
		})
	})
	
}

crud.view = function(sPhone){
	var frm = $('#frm_search')[0];
	frm.sPhone.value = sPhone;
	var param = $(frm).serialize();
	$.post('view.springboot', param, function(data){
					$('#index').html(data);
	})
}

crud.move = function(nowPage){
	var frm = $('#frm_search')[0];
	frm.nowPage.value = nowPage;
	var param = $(frm).serialize();
	
	$('#index').load('searchR.springboot', param);
}