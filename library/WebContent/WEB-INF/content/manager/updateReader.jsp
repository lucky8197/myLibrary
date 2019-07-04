<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/updateReader.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/JS/updateReader/updateReader.js"></script>
<title>更新读者</title>
</head>
<body onload="stack();">
	<%@include file="managerHeader.jsp"%>
	
	<div class="update_area">
		<div class="caption">管理员修改读者信息</div>
		<form id="form" name="form" method="post">

			用户名<span class="padding1"></span><input type="text" id="user"
				name="person.user" onblur="checkUser(this.value);"
				onfocus="user_message();" /> <span id="user_message"></span><br />

			生日<span class="padding2"></span><input type="text" id="newBirthday"
				name="newBirthday" onfocus="birthday_message();"
				onblur="checkBirthday(this.value);" /> <span id="birthday_message"></span><br />

			职业<span class="padding2"></span><input type="text" id="newVocation"
				name="newVocation" onblur="checkVocation(this.value);" /> <span
				id="vocation_message"></span><br /> 邮箱<span class="padding2"></span><input
				type="text" id="newEmail" name="newEmail"
				onblur="checkEmail(this.value);" /> <span id="email_message"></span><br />

			电话<span class="padding2"></span><input type="text" id="newTel"
				name="newTel" onblur="checkTel(this.value);" /> <span
				id="tel_message"></span><br /> 备注<span class="padding2"></span><input
				type="text" id="newNote" name="newNote"
				onblur="checkNote(this.value);" /> <span id="note_message"></span><br />


			<input type="button" value="修改" class="update"
				onclick="updateReader();"> <input type="reset" value="重置"
				class="reset" onclick="resetAll()">
		</form>
	</div>
	
	<%@ include file="../footer.jsp"%>
</body>
</html>