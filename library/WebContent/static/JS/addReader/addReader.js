var userFlag = false;
var nameFlag = false;
var passwordFlag = false;
var repasswordFlag = false;
var birthdayFlag = false;
var vocationFlag = false;
var emailFlag = false;
var telFlag = false;
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
function hideBook(){-0
	document.getElementById("list-drop2").style.display = "none";
}


function checkUser(str){
	if(str == ""){
		document.getElementById("user_message").style = "color:#f40";
		document.getElementById("user_message").innerHTML = "请输入用户名(2秒后自动获得焦点)";
		window.setTimeout("document.getElementById('user').focus()" , 2000);
		userFlag = false;
	}else if(checkNumAndLetter(str)){	
		if(str.length >= 4 && str.length <= 20){
			/*Ajax异步调用*/
			$.post("checkUser", $("#user").serializeArray(),
				function(data , statusText){
					document.getElementById("user_message").innerHTML = data;
					if(data == "用户名已存在，请重新输入"){
						document.getElementById("user_message").style = "color:red";		
					}
					window.setTimeout("resetUser_message();",3000);
				},"html");	
		}else{
			document.getElementById("user_message").style = "color:#f40";
			document.getElementById("user_message").innerHTML = "你输入的用户名不符合要求(2秒后自动获得焦点)";
			window.setTimeout("document.getElementById('user').focus()" , 2000);
			userFlag = false;
		}
	}else{
		document.getElementById("user_message").style = "color:#f40";
		document.getElementById("user_message").innerHTML = "用户名只能由字母（大小写）和数字组成";
		window.setTimeout("document.getElementById('user').focus()" , 2000);
		userFlag = false;
	}
}

/*验证字符串是否只包含字母和数字*/
function checkNumAndLetter(str){
	for(var i = 0; i < str.length; i++){
		var exp = (str.charCodeAt(i) >= 48 && str.charCodeAt(i) <= 57) || (str.charCodeAt(i) >= 65 && str.charCodeAt(i) <= 90) || (str.charCodeAt(i) >= 97 && str.charCodeAt(i) <= 122)
		if(!exp){
			return false;
		}
	}
	return true;
}
/*重置提示信息*/
function resetUser_message(){
	/*不满足要求*/
	if(document.getElementById("user_message").innerHTML.length >= 12){
		document.getElementById("user").focus();
		window.setTimeout("user_message();",2000);
		userFlag = false;
	}else{
		document.getElementById("user_message").style = "color:gray;";
		document.getElementById("user_message").innerHTML = "你的用户名满足要求！";
		userFlag = true;
	}
}
/*获得焦点后，显示提示信息*/
function user_message(){
	document.getElementById("user_message").style = "color:gray;";
	document.getElementById("user_message").innerHTML = "*4到20位字母或数字组成(带*的必填)";
}
/*校验姓名*/
function checkName(str){
	if(str == ""){
		document.getElementById("name_message").style = "color:gray";
		document.getElementById("name_message").innerHTML = "留下大名再走！";	
		nameFlag = true;
	}else{
		if(str.length >= 20 ){
			document.getElementById("name_message").style = "color:GRAY";
			document.getElementById("name_message").innerHTML = "名字过长！请重新输入，或者干脆为空！";
			nameFlag = false;
			return;
		}
		if(str.length > 5){
			document.getElementById("name_message").style = "color:gray";
			document.getElementById("name_message").innerHTML = "长度为"+ str.length + 
			",如果是中文名的话，就很强了！";
			nameFlag = true;
		}else{
			document.getElementById("name_message").style = "color:gray";
			document.getElementById("name_message").innerHTML = "你好 ，" + str;
			nameFlag = true;
		}
	}
	
}
/*获得焦点后，显示提示信息*/
function name_message(){
	document.getElementById("name_message").style = "color:gray;";
	document.getElementById("name_message").innerHTML = "*真实姓名(看心情填吧！)";
}
/*校验密码*/
function checkPassword(str){
	if(str == ""){
		document.getElementById("pass_message").style = "color:#f40";
		document.getElementById("pass_message").innerHTML = "您觉得密码不重要吗？";	
		passwordFlag = false;
	}else{
		if(str.length <6){
			document.getElementById("pass_message").style = "color:#f40";
			document.getElementById("pass_message").innerHTML = "密码过短！请重新输入";	
			passwordFlag = false;
		}else if(str.length < 10){
			document.getElementById("pass_message").style = "color:gray";
			document.getElementById("pass_message").innerHTML = "长度为" + str.length + ", 密码有点简单啊！";	
			passwordFlag = true;
		}else if(str.length < 15){
			document.getElementById("pass_message").style = "color:gray";
			document.getElementById("pass_message").innerHTML = "下一关没那么难！";	
			passwordFlag = true;
		}else if(str.length <= 20){
			document.getElementById("pass_message").style = "color:gray";
			document.getElementById("pass_message").innerHTML = "羡慕你的记忆力！";	
			passwordFlag = true;
		}else{
			document.getElementById("pass_message").style = "color:#f40";
			document.getElementById("pass_message").innerHTML = "密码过长！请重新输入";	
			passwordFlag = false;
		}
	}
}
/*获得焦点后，显示提示信息*/
function pass_message(){
	document.getElementById("pass_message").style = "color:gray;";
	document.getElementById("pass_message").innerHTML = "*不少于6位";
}
/*校验重复密码*/
function checkRepassword(str){
	if(str == ""){
		document.getElementById("repass_message").style = "color:#f40";
		document.getElementById("repass_message").innerHTML = "为了保证你的密码，请再输入一次密码";	
		repasswordFlag = false;
	}else{
		if(document.getElementById("password").value != document.getElementById("repassword").value){
			document.getElementById("repass_message").style = "color:#f40";
			document.getElementById("repass_message").innerHTML = "两次密码不一样，好好想想！";	
			repasswordFlag = false;
		}
			document.getElementById("repass_message").style = "color:gray";
			document.getElementById("repass_message").innerHTML = "两次密码一样。通过！";
			repasswordFlag = true;
	}
	
}
/*获得焦点后，显示提示信息*/
function repass_message(){
	if(document.getElementById("password").value == ""){
		document.getElementById("repass_message").style = "color:#f40";
		document.getElementById("repass_message").innerHTML = "先输入上一个！";
	}else{
		document.getElementById("repass_message").style = "color:gray;";
		document.getElementById("repass_message").innerHTML = "*再输一次密码";
	}
}
/*校验生日*/
function checkBirthday(str){
	if(str == ""){
		document.getElementById("birthday_message").style = "color:gray";
		document.getElementById("birthday_message").innerHTML = "不留生日也行！";
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
/*获得焦点后，显示提示信息*/
function vocation_message(){
	document.getElementById("vocation_message").style = "color:gray;";
	document.getElementById("vocation_message").innerHTML = "看心情填不填！";
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
		document.getElementById("email_message").innerHTML="请输入E-mail地址！";
		document.getElementById("email_message").style="color:#f40;";		
		emailFlag = false;
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

/*获得焦点后，显示提示信息*/
function email_message(){
	document.getElementById("email_message").innerHTML="*填写邮箱";
	document.getElementById("email_message").style="color:gray;";	
}
/*校验电话号码*/
function checkTel(str){
	if(str == ""){
		document.getElementById("tel_message").style="color:#f40;";
		document.getElementById("tel_message").innerHTML="填写电话号码！";
		telFlag = false;
	}else{
		if(str.length <= 20){
			document.getElementById("tel_message").style="color:gray;";
			document.getElementById("tel_message").innerHTML="填了就行！";
			telFlag = true;
		}else{
			document.getElementById("tel_message").style="color:#f40;";
			document.getElementById("tel_message").innerHTML="电话号码过长！20位以内";
			telFlag = false;
		}
	}
}
/*获得焦点后，显示提示信息*/
function tel_message(){
	document.getElementById("tel_message").innerHTML="*填写电话号码！";
	document.getElementById("tel_message").style="color:gray;";	
}
/*清除所有提示信息*/
function resetAll(){
	document.getElementById("user_message").innerHTML = "";
	document.getElementById("name_message").innerHTML = "";
	document.getElementById("pass_message").innerHTML = "";
	document.getElementById("repass_message").innerHTML = "";
	document.getElementById("sex_message").innerHTML = "";
	document.getElementById("birthday_message").innerHTML = "";
	document.getElementById("vocation_message").innerHTML = "";
	document.getElementById("email_message").innerHTML = "";
	document.getElementById("tel_message").innerHTML = "";
}
/*保存用户*/
function addReader(){
	if(!userFlag){
		if(document.getElementById("user").innerHTML == ""){
			alert("请输入用户名");
		}else{
			alert("用户名有误");
		}
		return;
	}
	if(!nameFlag){
		//为空也行
		if(document.getElementById("name").value == ""){
			nameFlag = true;
		}else{
			alert("名字有误");
			return;
		}
	}
	if(!passwordFlag){
		alert("密码有误");
		return;
	}
	if(!repasswordFlag){
		alert("重复密码有误");
		return;
	}
	//为空也行
	if(document.getElementById("birthday").value == ""){
		birthdayFlag = true;
	}
	//为空也行
	if(document.getElementById("vocation").value == ""){
		vocationFlag = true;
	}
	if(!emailFlag){
		alert("邮箱有误");
		return;
	}
	if(!telFlag){
		alert("电话号码有误");
		return;
	}
	$.post("addReader", $("#form").serializeArray(),
			function(data , statusText){
				alert(data);
				window.location.reload();
			},"html");
}