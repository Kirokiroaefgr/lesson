$(function(){
	$("img.CP").click(function(){
		var ImgSrc = $(this).attr("src");
		console.log(ImgSrc);
		$("img.MP").attr({src:ImgSrc});
		$("img.MP").hide();
		$("img.MP").fadeIn("slow");
		return false;
	});
});