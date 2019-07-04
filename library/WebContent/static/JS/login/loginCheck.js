/*验证表单是否为空*/
function check(){
	var name = document.getElementById("input1").value
	var password = document.getElementById("input2").value 
	if(name == null || name == ""){
		alert("请输入用户名");
		document.getElementById("input1").focus();
		return false;
	}
	if(password == null || password == ""){
		document.getElementById("input2").focus();
		alert("请输入密码");
		return false;
	}
	return true;
}

function hideMes(){
	document.getElementsByClassName("action_message")[0].style.display="none";
	document.getElementsByClassName("field_message")[0].style.display="none";
}
