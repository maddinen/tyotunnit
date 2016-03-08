
function onReady() {
	$("#datepicker").datepicker({
		dateFormat : "yy-mm-dd",
		weekStart : -1,
	});
};

//main
$(document).ready(onReady);