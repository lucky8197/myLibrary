var OldPassFlag = true;
var passwordFlag = false;
var repasswordFlag = false;
var birthdayFlag = false;
var vocationFlag = false;
var emailFlag  = false;
var telFlag = false;
/*初始化信息*/
function getOldInfor(){
	$.post("getOldInfor" ,"html");
	if(document.getElementById("form") == null){
		window.location.reload(true);
	}
}
/*清空生日框*/
function newBirthdayFocus(){
	var ele = document.getElementById("newBirthday");
	ele.style.color = "black";
}
/*清空职业框*/
function newVocationFocus(){
	var ele = document.getElementById("newVocation");
	ele.style.color = "black";
}
/*清空邮箱框*/
function newEmailFocus(){
	var ele = document.getElementById("newEmail");
	ele.style.color = "black";
}
/*清空电话框*/
function newTelFocus(){
	var ele = document.getElementById("newTel");
	ele.style.color = "black";
}
/*旧密码框获取消息后显示提示信息*/
function oldPass_message(){
	var ele = document.getElementById("oldPass_message");
	ele.innerHTML = "修改密码必填此项";
	
}

/*校验新密码*/
function checkNewpass(str){
	if(str == ""){	
		passwordFlag = true;
	}else{
		if(str == document.getElementById("oldPass").value){
			document.getElementById("newPass_message").style = "color:#f40";
			document.getElementById("newPass_message").innerHTML = "新旧密码一样！";
			passwordFlag = true;
			return;
		}else{
			if(str.length <6){
				document.getElementById("newPass_message").style = "color:#f40";
				document.getElementById("newPass_message").innerHTML = "密码过短！请重新输入";	
				passwordFlag = false;
			}else if(str.length < 10){
				document.getElementById("newPass_message").style = "color:gray";
				document.getElementById("newPass_message").innerHTML = "长度为" + str.length + ", 密码有点简单啊！";	
				passwordFlag = true;
			}else if(str.length < 15){
				document.getElementById("newPass_message").style = "color:gray";
				document.getElementById("newPass_message").innerHTML = "符合要求";	
				passwordFlag = true;
			}else if(str.length <= 20){
				document.getElementById("newPass_message").style = "color:gray";
				document.getElementById("newPass_message").innerHTML = "羡慕你的记忆力！";	
				passwordFlag = true;
			}else{
				document.getElementById("newPass_message").style = "color:#f40";
				document.getElementById("newPass_message").innerHTML = "密码过长！请重新输入";	
				passwordFlag = false;
			}
		}
		
	}
}

/*校验重复密码*/
function checkRepassword(str){
	if(str == "" && document.getElementById("newPass").value != ""){
		document.getElementById("rePass_message").style = "color:#f40";
		document.getElementById("rePass_message").innerHTML = "为了保证你的密码，请再输入一次密码";	
		repasswordFlag = false;
	}else if(str == "" && document.getElementById("newPass").value == ""){
		repasswordFlag = true;
	}else if(str != "" && document.getElementById("newPass").value == ""){
		document.getElementById("rePass_message").style = "color:#f40";
		document.getElementById("rePass_message").innerHTML = "请先输入上一项";
		repasswordFlag = false;
	}else{
		if(passwordFlag){
			if(document.getElementById("newPass").value != document.getElementById("rePass").value){
				document.getElementById("rePass_message").style = "color:#f40";
				document.getElementById("rePass_message").innerHTML = "两次密码不一样，好好想想！";	
				repasswordFlag = false;
			}else{
				document.getElementById("rePass_message").style = "color:gray";
				document.getElementById("rePass_message").innerHTML = "两次密码一样。";
				repasswordFlag = true;
			}
		}else{
			document.getElementById("rePass_message").style = "color:#f40";
			document.getElementById("rePass_message").innerHTML = "新密码的格式不对，先修改上一项";	
			repasswordFlag = false;
		}
	}
}

/*邮箱正则表达校验*/
function checkemail(email){
	var str=email;
	 //在JavaScript中，正则表达式只能使用"/"开头和结束，不能使用双引号
	var Expression=/\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/; 
	var objExp=new RegExp(Expression);		//创建正则表达式对象
	if(objExp.test(str)==true){				//通过正则表达式进行验证
		return true;
	}else{
		return false;
	}
}

/*清除所有提示信息*/
function resetAll(){
	document.getElementById("oldPass_message").style.color = "gray";
	document.getElementById("oldPass_message").innerHTML = "修改密码必填此项";
	document.getElementById("newPass_message").innerHTML = "";
	document.getElementById("rePass_message").innerHTML = "";
	document.getElementById("birthday_message").innerHTML = "";
	document.getElementById("vocation_message").innerHTML = "";
	document.getElementById("email_message").innerHTML = "";
	document.getElementById("tel_message").innerHTML = "";
}
/*更新信息*/
function updatePerson(){
	checkNewpass(document.getElementById("newPass").value);
	checkRepassword(document.getElementById("rePass").value);
	checkBirthday(document.getElementById("newBirthday").value);
	checkVocation(document.getElementById("newVocation").value);
	checkEmail(document.getElementById("newEmail").value);
	checkTel(document.getElementById("newTel").value);
	if(!OldPassFlag){
		alert("旧密码错误");
		return;
	}
	if(!passwordFlag){
		alert("新密码错误");
		return;
	}
	if(!repasswordFlag){
		alert("重复密码有误");
		return;
	}
	if(!birthdayFlag){
		alert("生日格式有误");
		return;
	}
	if(!vocationFlag){
		alert("职业有误");
		return;
	}
	if(!emailFlag){
		alert("邮箱格式有误");
		return;
	}
	if(!telFlag){
		alert("电话号码有误");
		return;
	}
	$.post("updatePerson", $("#form").serializeArray(),
			function(data , statusText){
				alert(data);
				if(data == "修改成功，密码改变，请重新登录"){
					alert('点击跳转到登录页面！');
					toLogin();
				}
			},"html");
}

/*跳转到登录页面！*/
function toLogin(){
	window.location.href="http://localhost:8888/library/login";
}
