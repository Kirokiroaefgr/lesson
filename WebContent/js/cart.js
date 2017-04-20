function plus(id){
var num=document.getElementById(id);
if(num.value<99){num.value=(num.value==""?0:parseInt(num.value))+1}
}

function minus(id){
	var num=document.getElementById(id);

	if(num.value>1){num.value=(num.value==""?0:parseInt(num.value))-1}
	}