function datePickerfunc() {
		$("#datepicker").datepicker({
			dateFormat : "yy-mm-dd",
			weekStart : -1,

		});
	});

function onReady() {
	calculateBMI();
	$("INPUT").change(calculateBMI)
}

//main
$(document).ready(onReady);
