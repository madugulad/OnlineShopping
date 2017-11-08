$(function(){
	$('#'+id).addClass('active');
})


var products = [
	['1', 'abc'], [2, 'def'], [3, 'ghi'], [4, 'ijk']
];

var $table = $("#tblProductList");
if($table.length){
	console.log("inside table datasource");
	$table.DataTable({
		data: products
	});
}