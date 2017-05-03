$(function() {


			$.ajax({
				url : 'MainTopJson',
				type : 'GET',
				dataType : 'json',
				success : function(json) {
					console.log(json);
					console.log(json[0].itemName);
					for (i = 0; i < json.length; i++) {
						$('#Recommended')
								.append(
										'<div class="col-xs-12 col-sm-3"><a class="selectRecommended"><img src="./img/Product/'
												+ json[i].itemImg01
												+ '" class="img-responsive" style="width:100%" alt="Image"><span id="'+json[i].itemId+'">'
												+ json[i].itemName
												+ '</span></a></div>');
					};

					$(document).on('click','.selectRecommended',function(){
						var num = $('span',this).attr('id');
//						console.log(num);
						$("#selectId").val(num);
//						 console.log($("#selectId").val());
						$('#mainTop').submit();
						return false;
					});

				}
			});


});