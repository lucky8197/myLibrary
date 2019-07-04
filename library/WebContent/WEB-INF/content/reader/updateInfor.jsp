<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.*,java.util.*,java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/updateInfor.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/JS/updateInfor/updateInfor.js"></script>
<script type="text/javascript">

/*验证旧密码*/
function checkOldPass(str){
	if(str == ""){
		document.getElementById("oldPass_message").style = "color:gray";
		document.getElementById("oldPass_message").innerHTML = "修改密码必填此项";
		OldPassFlag = true;
	}else{
		if(str == "<%=((PersonBean) session.getAttribute("person")).getPassword()%>"){
			document.getElementById("oldPass_message").style = "color:gray";
			document.getElementById("oldPass_message").innerHTML = "密码正确";
			OldPassFlag = true;
		}else{
			document.getElementById("oldPass_message").style = "color:red";
			document.getElementById("oldPass_message").innerHTML = "密码错误";
			OldPassFlag = false;
		}
	}
}

/*校验生日*/
function checkBirthday(str){
	if(str == ""){
		document.getElementById("newBirthday").value = "<%=((PersonBean) session.getAttribute("person")).getBirthday()%>";
		document.getElementById("newBirthday").style.color = "gray";
		birthdayFlag = true;
	}else{
		if(str.length < 10){
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

/*校验职业*/
function checkVocation(str){
	if(str == "" ){
		document.getElementById("newVocation").value = "<%=((PersonBean) session.getAttribute("person")).getVocation()%>";
		document.getElementById("newVocation").style.color = "gray";
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

/*校验邮箱*/
function checkEmail(str){
	if(str == ""){
		document.getElementById("newEmail").value = "<%=((PersonBean) session.getAttribute("person")).getEmail()%>";
		document.getElementById("newEmail").style.color = "gray";	
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
		document.getElementById("newTel").value = "<%=((PersonBean) session.getAttribute("person")).getTel()%>";
			document.getElementById("newTel").style.color = "gray";
			telFlag = true;
		} else {
			if (str.length <= 20) {
				document.getElementById("tel_message").style = "color:gray;";
				document.getElementById("tel_message").innerHTML = "符合要求";
				telFlag = true;
			} else {
				document.getElementById("tel_message").style = "color:#f40;";
				document.getElementById("tel_message").innerHTML = "电话号码过长！20位以内";
				telFlag = false;
			}
		}
	}
</script>
<title>修改信息页面</title>
</head>
<body onload="getOldInfor();">
	<%@ include file="readerHeader.jsp"%>
	<div class="wrap">
		<div class="content">
			<%
			PersonBean person = (PersonBean) session.getAttribute("person");
				if (person != null) {
			%>
			<div class="update_area">
				<div class="caption">修改个人信息</div>
				<form id="form" name="form" method="post">
					旧密码<span class="padding1"></span><input type="password"
						id="oldPass" onblur="checkOldPass(this.value);"
						onfocus="oldPass_message();" /> <span id="oldPass_message">修改密码必填此项</span><br />

					新密码<span class="padding1"></span><input type="password"
						id="newPass" name="newPass" onblur="checkNewpass(this.value);" />
					<span id="newPass_message"></span><br /> 重复密码<input type="password"
						id="rePass" onblur="checkRepassword(this.value);" /> <span
						id="rePass_message"></span><br />
					<%
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					%>
					生日<span class="padding2"></span><input type="text" id="newBirthday"
						name="newBirthday"
						value="<%=format.format(person.getBirthday())%>"
						onfocus="newBirthdayFocus();" onblur="checkBirthday(this.value);" />
					<span id="birthday_message"></span><br /> 职业<span class="padding2"></span><input
						type="text" id="newVocation" name="newVocation"
						value="<%=person.getVocation()%>" onfocus="newVocationFocus();"
						onblur="checkVocation(this.value);" /> <span id="vocation_message"></span><br />

					邮箱<span class="padding2"></span><input type="text" id="newEmail"
						name="newEmail" value="<%=person.getEmail()%>"
						onfocus="newEmailFocus();" onblur="checkEmail(this.value);" /> <span
						id="email_message"></span><br /> 电话<span class="padding2"></span><input
						type="text" id="newTel" name="newTel"
						value="<%=person.getTel()%>" onfocus="newTelFocus();"
						onblur="checkTel(this.value);" /> <span id="tel_message"></span><br />
					<input type="button" value="修改" class="update"
						onclick="updatePerson();"> <input type="reset" value="重置"
						class="reset" onclick="resetAll()">
				</form>
			</div>
			<%
				}
			%>
		</div>
	</div>
</body>
</html>