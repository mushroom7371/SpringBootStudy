/**
 * 테스트용
 */

var crud = {};

crud.init = function(){
	
	$('#crud #btnInsertR').on('click', function(){
		
		var frm = $('#frm_insert')[0];
		var param = $(frm).serialize();
		
		$.ajax({
			type    : 'POST',
			url     : './insertR.springboot',
			data    : param,
			success : function(resp){
				alert('성공~!');
			}
		})
	})
}