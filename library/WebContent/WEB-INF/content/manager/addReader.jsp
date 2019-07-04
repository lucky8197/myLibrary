<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/addReader.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/JS/addReader/addReader.js"></script>
<title>添加读者</title>
</head>
<body onload="stack();">
	<%@include file="managerHeader.jsp"%>
	
		<div class="add_area">
			<div class="caption">管理员添加读者</div>
			<form id="form" name="form" method="post">
				用户名<span class="padding1"></span><input type="text" id="user"
					name="person.user" onblur="checkUser(this.value);"
					onfocus="user_message();" /> <span id="user_message"></span><br />
				姓名<span class="padding2"></span><input type="text" id="name"
					name="person.name" onblur="checkName(this.value);"
					onfocus="name_message();" /> <span id="name_message"></span><br />
				密码<span class="padding2"></span><input type="password"
					id="password" name="person.password" required
					onblur="checkPassword(this.value)" onfocus="pass_message();" /> <span
					id="pass_message"></span><br /> 重复密码<input type="password"
					id="repassword" name="repassword"
					onblur="checkRepassword(this.value);" onfocus="repass_message();" />
				<span id="repass_message"></span><br /> 性别 <input type="radio"
					name="person.sex" id="male" value="男" /> 男 <input type="radio"
					name="person.sex" id="female" value="女" /> 女 <span
					id="sex_message"></span><br /> 生日<span class="padding2"></span><input
					type="text" id="birthday" name="person.birthday"
					onblur="checkBirthday(this.value)" onfocus="birthday_message();" />
				<span id="birthday_message"></span><br /> 职业<span class="padding2"></span><input
					type="text" id="vocation" name="person.vocation"
					onblur="checkVocation(this.value);" onfocus="vocation_message();" />
				<span id="vocation_message"></span><br /> 邮箱<span class="padding2"></span><input
					type="text" name="person.email" onblur="checkEmail(this.value)"
					onfocus="email_message();" /> <span id="email_message"></span><br />
				电话<span class="padding2"></span><input type="text"
					name="person.tel" onblur="checkTel(this.value);"
					onfocus="tel_message();" /> <span id="tel_message"></span><br /> <input
					type="button" value="添加 " class="add" onclick="addReader();">
				<input type="reset" value="重置" class="reset" onclick="resetAll()">
			</form>
		</div>
		
		<%@ include file="../footer.jsp"%>
</body>
</html>