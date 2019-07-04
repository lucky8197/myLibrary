var userFlag = false;
var birthdayFlag = false;
var vocationFlag = false;
var emailFlag = false;
var telFlag = false;
var noteFlag = false;
/*显示隐藏div*/
function showReader(){
	document.getElementById("list-drop1").style.display = "block";
}
/*隐藏div*/
function hideReader(){
	document.getElementById("list-drop1").style.display = "none";
}
/*显示隐藏div*/
function showBook(){
	document.getElementById("list-drop2").style.display = "block";
}
/*隐藏div*/
function hideBook(){
	document.getElementById("list-drop2").style.display = "none";
}

/*校验用户名*/
function checkUser(str){
	if(str == ""){
		document.getElementById("user_message").style = "color:#f40";
		document.getElementById("user_message").innerHTML = "请输入用户名";
		window.setTimeout("document.getElementById('user').focus();",3000);
		userFlag = false;
	}else{
		if(str.length >= 4 && str.length <= 20){
			/*Ajax异步调用*/
			$.post("checkUser", $("#user").serializeArray(),
				function(data , statusText){
					document.getElementById("user_message").innerHTML = data;
					
					if(document.getElementById("user_message").innerHTML.length == 12){
						document.getElementById("user_message").style = "color:gray;";
						document.getElementById("user_message").innerHTML = "输入的用户名存在！";
						userFlag = true;
					}else{
						document.getElementById("user_message").style = "color:red;";
						document.getElementById("user_message").innerHTML = "输入的用户名不存在";				
						window.setTimeout("document.getElementById('user').focus();",3000);
						userFlag = false;
					}
				},"html");
		}else{
			document.getElementById("user_message").style = "color:#f40";
			document.getElementById("user_message").innerHTML = "你输入的用户名不符合要求";
			window.setTimeout("document.getElementById('user').focus();",3000);
			userFlag = false;
		}
	}
}

/*获得焦点后，显示提示信息*/
function user_message(){
	document.getElementById("user_message").style = "color:gray;";
	document.getElementById("user_message").innerHTML = "4到20位字母或数字组成。";
}


/*校验生日*/
function checkBirthday(str){
	if(str == ""){
		birthdayFlag = true;
	}else{
		if(str.length != 10){
			document.getElementById("birthday_message").style = "color:#f40";
			document.getElementById("birthday_message").innerHTML = "生日格式错误，格式为xxxx.xx.xx";
			return;
		}else{
			if(str.substr(0,4) < 1900 || str.substr(0,4) > 2019){
				document.getElementById("birthday_message").style = "color:#f40";
				document.getElementById("birthday_message").innerHTML = "生日年份范围错误(1900-2019)";
				return;
			}else{
				if(str.substr(5,2) < 01 || str.substr(5, 2) >  12){
					document.getElementById("birthday_message").style = "color:#f40";
					document.getElementById("birthday_message").innerHTML = "生日月份范围错误(01-12)";
					return;
				}else{
					if(str.substr(8,2) < 01 || str.substr(8,2) > 31){
						document.getElementById("birthday_message").style = "color:#f40";
						document.getElementById("birthday_message").innerHTML = "生日日期范围错误(01-31)";
						return;
					}
						
				}
			}
		}
		document.getElementById("birthday_message").style = "color:gray";
		document.getElementById("birthday_message").innerHTML = "生日满足要求";
		birthdayFlag = true;
	}
}

/*获得焦点后，显示提示信息*/
function birthday_message(){
	document.getElementById("birthday_message").style = "color:gray;";
	document.getElementById("birthday_message").innerHTML = "如1997.06.06";
}


/*校验职业*/
function checkVocation(str){
	if(str == "" ){
		vocationFlag = true;
	}else {
		if(str.length > 10){
			document.getElementById("vocation_message").style = "color:#f40;";
			document.getElementById("vocation_message").innerHTML = "职业过长，请重新输入（10位以内）！";
			vocationFlag = false;
		}else{
			vocationFlag = true;
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

/*校验邮箱*/
function checkEmail(str){
	if(str == ""){	
		emailFlag = true;
	}else if(!checkemail(str)){
		document.getElementById("email_message").innerHTML="您输入的E-mail格式不正确！";
		document.getElementById("email_message").style="color:#f40;";	
		emailFlag = false;
	}else if(str.length > 50){
		document.getElementById("email_message").innerHTML="您输入的E-mail过长！";
		document.getElementById("email_message").style="color:#f40;";	
		emailFlag = false;
	}else{
		document.getElementById("email_message").innerHTML="E-mail满足要求"
		document.getElementById("email_message").style="color:gray;";	
		emailFlag = true;
	}
}

/*校验电话号码*/
function checkTel(str){
	if(str == ""){
		telFlag = true;
	}else{
		if(str.length <= 20){
			document.getElementById("tel_message").style="color:gray;";
			document.getElementById("tel_message").innerHTML="符合要求";
			telFlag = true;
		}else{
			document.getElementById("tel_message").style="color:#f40;";
			document.getElementById("tel_message").innerHTML="电话号码过长！20位以内";
			telFlag = false;
		}
	}
}


/*校验备注*/
function checkNote(str){
	if(str == "" ){
		noteFlag = true;
	}else {
		if(str.length > 200){
			document.getElementById("vocation_message").style = "color:#f40;";
			document.getElementById("vocation_message").innerHTML = "职业过长，请重新输入（200位以内）！";
			noteFlag = true;
		}else{
			noteFlag = true;
		}
	}
}

/*清除所有提示信息*/
function resetAll(){
	document.getElementById("user_message").innerHTML = "";
	document.getElementById("birthday_message").innerHTML = "";
	document.getElementById("vocation_message").innerHTML = "";
	document.getElementById("email_message").innerHTML = "";
	document.getElementById("tel_message").innerHTML = "";
	document.getElementById("note_message").innerHTML = "";
}

/*清除所有输入框内容*/
function resetAllValue(){
	document.getElementById("user").value = "";
	document.getElementById("newBirthday").value = "";
	document.getElementById("newVocation").value = "";
	document.getElementById("newEmail").value = "";
	document.getElementById("newTel").value = "";
	document.getElementById("newNote").value = "";
}

/*更新信息*/
function updateReader(){
	checkBirthday(document.getElementById("newBirthday").value);
	checkVocation(document.getElementById("newVocation").value);
	checkEmail(document.getElementById("newEmail").value);
	checkTel(document.getElementById("newTel").value);
	checkNote(document.getElementById("newNote").value);	
	if(!userFlag){
		alert("用户名有误");
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
	if(!noteFlag){
		alert("备注有误");
		return;
	}
	$.post("updateReader", $("#form").serializeArray(),
			function(data , statusText){
				alert(data);
				resetAll();
				resetAllValue();
			},"html");
}
