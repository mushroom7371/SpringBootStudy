/**
 * 테스트용
 */

var crud = {};

crud.init = function(){
	$('#index #btnIndex').on('click', function(){
		$('#index').load('./');
	})
	
	$('#index #btnInsert').on('click', function(){
		$('#index').load('./insert.springboot');
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
		
		$.ajax({
			type    : 'POST',
			url     : './insertR.springboot',
			data    : param,
			success : function(resp){
				$('#index').load('./search.springboot');
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