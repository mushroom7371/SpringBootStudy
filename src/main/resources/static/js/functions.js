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
}