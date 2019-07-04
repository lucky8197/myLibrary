<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>     	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/managerHeader.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/JS/header_time/header_time.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/JS/common/jquery-3.2.1.js"></script>
<script type="text/javascript">

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

</script>	
<title></title>
</head>
<body>
	<div class="header_wrap">
		<div class="header_content">
			<%@include file="../header.jsp"%>
			<div class="nav_wrap">
				<ul class="nav_ul">
					<li class="nav_content"><a href="toManagerHomePage">首页</a></li>
					<li class="nav_content">
						<div class="nav-list" id="nav-list" onmouseover="showReader();"
							onmouseout="hideReader();">读者管理</div>
						<div class="list-drop" id="list-drop1" style="display: none;"
							onmouseover="showReader();" onmouseout="hideReader();">
							<ul class="list-ul">
								<li><a href="toSearchReaderPage">搜索读者</a></li>
								<li><a href="toAddReaderPage">添加读者</a></li>
								<li><a href="toUpdateReaderPage">更新读者</a></li>
								<li><a href="toRemoveReaderPage">删除读者</a></li>
							</ul>
						</div>
					</li>
					<li class="nav_content">
						<div class="nav-list" id="nav-list" onmouseover="showBook();"
							onmouseout="hideBook();">图书管理</div>
						<div class="list-drop" id="list-drop2" style="display: none;"
							onmouseover="showBook();" onmouseout="hideBook();">
							<ul class="list-ul">
								<li><a href="toAddBookPage">添加图书</a></li>
								<li><a href="toUpdateBookPage">更新图书</a></li>
								<li><a href="toRemoveBookPage">删除图书</a></li>
							</ul>
						</div>
					</li>
					<li class="nav_content"><a href="toUpdateNoticePage">公告编辑</a></li>
					<li class="nav_content"><a href="logOut" class="red">退出登录</a></li>
					<li class="nav_content"><span>欢迎你，<s:property value="#session.user"/></span></li>
				</ul>
				<span id="time" class="time" onload="setTime();"></span>
			</div>
		</div>
	</div>
</body>
</html>