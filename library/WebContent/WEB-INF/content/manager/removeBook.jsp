<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,vo.*,java.text.*"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/removeBook.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/JS/removeBook/removeBook.js"></script>
<title>刪除图书</title>
</head>
<body>
	<%@include file="managerHeader.jsp"%>
	
		<form id="form" action="findBookManager" method="post">
			<input type="text" id="bookInfo" name="bookInfo" /><input
				type="submit" class="find" value="检索"/> <br />
			<div class="wayArea">
				<label class="fingWay">检索方式：</label> <input type="radio" name="way" 
					value="bookName" checked> 按书名 <input type="radio" name="way"
					value="author"> 按作者 <input type="radio" name="way"
					value="type"> 按类型 <input type="radio" name="way"
					value="bookCase"> 按书架
			</div>
		</form>

		<div class="resultArea" id="resultArea">
			<s:if test="actionMessages.size() > 0">
				<div class="message">
					<s:actionmessage/>
				</div>
			</s:if>
			<s:if test="bookResult.size()>0">
				<table id="bookResult" border="1">
					<caption class="table_caption">检索结果</caption>
					<tr>
						<th>ID</th>
						<th>书名</th>
						<th>类型</th>
						<th>书架</th>
						<th>作者</th>
						<th>出版社</th>
						<th>价格</th>
						<th>页数</th>
						<th>库存</th>
						<th>借阅数</th>
						<th>入库时间</th>
						<th>操作</th>
					</tr>
					
					<s:iterator value="bookResult" status="st">
							<tr>
								<td><s:property value="id"/></td>
								<td><s:property value="book_name"/></td>
								<td><s:property value="book_type"/></td>
								<td><s:property value="book_case"/></td>
								<td><s:property value="author"/></td>
								<td><s:property value="book_concern"/></td>
								<td><s:property value="price"/></td>
								<td><s:property value="page"/></td>
								<td><s:property value="count"/></td>
								<td><s:property value="borrownum"/></td>
								<td><s:property value="inTime"/></td>
								<td><input type="radio" name="remove"/></td>
							</tr>			
						</s:iterator>
			
				</table>
				<div class="borrow_area">
					<input type="button" value="删除" class="borrowButton"
						onclick="removeBook();" />
				</div>
			</s:if>
		</div>
</body>
</html>