<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/regist.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/JS/common/donghua.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/JS/regist/registCheck.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/JS/common/jquery-3.2.1.js"></script>
<title>注册页面</title>
</head>
<body onload="stack();">
	<div class="wrap">
		<div class="content">
			<%@ include file="header.jsp"%>
			<div class="regist_area">
				<form id="form" name="form" method="post" action="savePerson" onsubmit="return checkForm();">
					用户名<span class="padding1"></span><input type="text" id="user" name="person.user"  
					required onblur="checkUser(this.value);" onfocus="user_message();"/>
					<span id="user_message"></span><br/>
					姓名<span class="padding2"></span><input type="text" id="name" name="person.name" 
					onblur="checkName(this.value);" onfocus ="name_message();"/>
					<span id="name_message"></span><br/>
					密码<span class="padding2"></span><input type="password" id="password" name="person.password" required 
					onblur="checkPassword(this.value)" onfocus="pass_message();"/>
					<span id="pass_message"></span><br/>		
					重复密码<input type="password" id="repassword" name="repassword"  required
					onblur="checkRepassword(this.value);" onfocus="repass_message();"/>
					<span id="repass_message"></span><br/>
					性别 <input type="radio" name="person.sex" id="male" value="男" /> 男 
						<input type="radio" name="person.sex" id="female" value="女"/> 女 
					<span id="sex_message"></span><br/>			
					生日<span class="padding2"></span><input type="text"  id ="birthday" name="person.birthday" 
					onblur="checkBirthday(this.value)" onfocus="birthday_message();"/>
					<span id="birthday_message"></span><br/>					
					职业<span class="padding2"></span><input type="text"  id="vocation" name="person.vocation" 
					onblur="checkVocation(this.value);"onfocus="vocation_message();"/>
					<span id="vocation_message"></span><br/>					
					邮箱<span class="padding2"></span><input type="text" id = "email" name="person.email" required 
					onblur="checkEmail(this.value)" onfocus="email_message();" />
					<span id="email_message"></span><br/>					
					电话<span class="padding2"></span><input type="text"  id= "tel" name="person.tel" required 
					onblur="checkTel(this.value);" onfocus="tel_message();"/>
					<span id="tel_message"></span><br/>
					<input type="submit" value="注册" class="regist">
					<input type="reset" value="重置" class="reset" onclick="resetAll()">
					<a href="login" class="tologin">已有账号，去登录！</a>
				</form>
				<s:if test="fieldErrors.size() > 0">
					<div>
						<s:fielderror/>
					</div>
				</s:if>
				<s:if test="actionMessages.size() > 0">
					<div>
						<s:actionmessage/>
					</div>
				</s:if>
			 </div>
			 <%@ include file="footer.jsp"%>
		</div>
	</div>
</body>
</html>