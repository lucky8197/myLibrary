<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/readerHeader.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/JS/header_time/header_time.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/JS/common/jquery-3.2.1.js"></script>
<title></title>
</head>
<body>
	<div class="head_wrap">
		<div class="head_content">
			<%@ include file="../header.jsp"%>
			<div class="nav_wrap">
				<ul class="nav_ul">
					<li class="nav_content"><a href="toHomePage">首页</a></li>
					<li class="nav_content"><a href="borrowPage">图书借阅</a></li>
					<li class="nav_content"><a href="giveBackPage">图书归还</a></li>
					<li class="nav_content"><a href="borrowRecordPage">借阅记录</a></li>
					<li class="nav_content"><a href="updateInforPage" class="long">修改个人信息</a></li>
					<li class="nav_content"><a href="logOut" class="red">退出登录</a></li>
					<li class="nav_content"><span>欢迎你，<s:property value="#session.user"/></span></li>
				</ul>
				<span id="time" class="time" onload="setTime();"></span>
			</div>
		</div>
	</div>	
</body>
</html>