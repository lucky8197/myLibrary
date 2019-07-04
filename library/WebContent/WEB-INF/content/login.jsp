<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/login.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/JS/common/donghua.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/JS/login/loginCheck.js"></script>

</head>
<body onload="stack();">
	<div class="wrap">
		<div class="content">
			<%@include file="header.jsp"%>		
			<div class="login_area" id="area1" >
				<!-- 显示fieldError -->
				<div class="field_message">    
    				<s:if test="fieldErrors.size()>0">				
    					<s:fielderror/>
    				</s:if>
	   			 </div>
				<!-- 显示actionMessage -->
				<div class="action_message">
	    			<s:if test="actionMessages.size()>0">			
	    				<s:actionmessage/>
	    			</s:if>
    			</div>
				<s:form id="form1" action="processLogin" method="post" onsubmit="return check();" onfocus="hideMes();">
					<s:textfield name="person.user" label="用户名"  cssClass="input" id="input1"></s:textfield>
					<s:password name="person.password" label="密   码"  cssClass="input" id="input2"></s:password>
					<tr>
						<td >
							<input type="submit" value="登录" class="button1">
						</td>
						<td>
							<input type="reset" value="重置" class="button2">
						</td>
					</tr>
					<tr>
					<td colspan="2">
						<div class="regist_area">
								<span>还没有账号？</span><a href="regist">注册</a>
						</div>
					</td>
					</tr>
				</s:form>
			</div>
			<%@include file="footer.jsp" %>
		</div>	
	</div>
	
</body>
</html>