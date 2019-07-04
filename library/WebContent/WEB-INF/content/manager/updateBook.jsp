<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/updateBook.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/JS/updateBook/updateBook.js"></script>
<title>更新图书</title>
</head>
<body onload="stack();">
	<%@include file="managerHeader.jsp"%>
	<div class="update_area">
		<div class="caption">管理员修改图书信息</div>
		<form id="form" name="form" method="post">

			编号<span class="padding2"></span><input type="text" id="id"
				name="id" onblur="checkId(this.value);" /> <span id="id_message"></span><br />

			书名<span class="padding2"></span><input type="text" id="book_name"
				name="newBook_name" onblur="checkName(this.value);"
				onfocus="name_message();" /> <span id="name_message"></span><br />

			类型<span class="padding2"></span><input type="text" id="book_type"
				name="newBook_type" onblur="checkType(this.value);"
				onfocus="type_message();" /> <span id="type_message"></span><br />

			书架<span class="padding2"></span><input type="text" id="book_case"
				name="newBook_case" onblur="checkCase(this.value)"
				onfocus="case_message();" /> <span id="case_message"></span><br />

			作者<span class="padding2"></span><input type="text" id="author"
				name="newAuthor" onblur="checkAuthor(this.value);"
				onfocus="author_message();" /> <span id="author_message"></span><br />

			出版社<span class="padding1"></span><input type="text"
				id="book_concern" name="newConcern"
				onblur="checkConcern(this.value);" onfocus="concern_message();" />
			<span id="concern_message"></span><br /> 价格<span class="padding2"></span><input
				type="text" id="price" name="newPrice"
				onblur="checkPrice(this.value)" onfocus="price_message();" /> <span
				id="price_message"></span><br /> 数量<span class="padding2"></span><input
				type="text" id="count" name="newCount"
				onblur="checkCount(this.value);" onfocus="count_message();" /> <span
				id="count_message"></span><br /> 页数<span class="padding2"></span><input
				type="text" id="page" name="newPage"
				onblur="checkPage(this.value)" onfocus="page_message();" /> <span
				id="page_message"></span><br /> <input type="button" value="修改"
				class="update" onclick="updateBook();"> <input
				type="reset" value="重置" class="reset" onclick="resetAll()">
		</form>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>