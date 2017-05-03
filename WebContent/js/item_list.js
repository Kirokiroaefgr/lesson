$(function(){

	$(".selectPage,.back,.next,.last,.first").on('click', function() {
		var num;

		if ($(this).hasClass('first')) {
			$("#selectNum").val(1);
		}

		if ($(this).hasClass('back')) {
			num = $(".active").text();
			$("#selectNum").val(num - 1);
		}

		if ($(this).hasClass('selectPage')) {
			num = $(this).text();
			$("#selectNum").val(num);
		}

		if ($(this).hasClass('next')) {
			num = parseInt($(".active").text());
			$("#selectNum").val(num + 1);
		}

		if ($(this).hasClass('last')) {
			num = $(this).text();
			num = num.substr(7);
			num = num.substr(0, num.length - 1);
			$("#selectNum").val(num);
		}

		$('#mainPage').submit();
		return false;
	});

});