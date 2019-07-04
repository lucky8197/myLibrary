<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/updateNotice.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/JS/updateNotice/updateNotice.js"></script>
<title>公告编辑</title>
</head>
<body>
	<%@include file="managerHeader.jsp"%>
	<form id="form" action="findBook" method="post">
		<textArea rows="20" cols="80" name="newNotice"></textArea>
		<div>
			<input type="button" class="update" value="修改"
				onclick="updateNotice();" />
		</div>
	</form>
</body>
</html>