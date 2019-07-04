<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,vo.*,java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/giveBack.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/JS/giveBack/giveBack.js"></script>
<title>读者归还</title>
</head>
<body onload="notGiveBackBorrows();">
	<%@ include file="readerHeader.jsp"%>
	<div class="wrap">
		<div class="resultArea">
			<%
				List<BorrowBean> list = new ArrayList<>();
				list = (List<BorrowBean>) session.getAttribute("borrowList");
				if (list != null && list.size() > 0) {
			%>
			<table id="bookResult" border="1">
				<caption class="table_caption">所有未归还借阅记录</caption>
				<tr>
					<th>ID</th>
					<th>书名</th>	
					<th>类型</th>
					<th>作者</th>
					<th>借阅时间</th>
					<th>应还时间</th>
					<th>还书</th>
				</tr>
				<%
					for (int i = 0; i < list.size(); i++) {
				%>
				<tr>
					<td><%=list.get(i).getId()%></td>
					<td><%=list.get(i).getBook().getBook_name()%>></td>
					<td>
						<%
							String bookType = list.get(i).getBook().getBook_type();
									if (bookType == null) {
										bookType = "无";
									}
									out.print(bookType);
						%>
					</td>
					<td>
						<%
							String Author = list.get(i).getBook().getAuthor();
									if (Author == null) {
										Author = "无";
									}
									out.print(Author);
						%>
					</td>
					<%
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					%>
					<td><%=format.format(list.get(i).getBorrow_time())%></td>
					<td>
						<%
							Date back_time = list.get(i).getBack_time();
									out.print(format.format(back_time));
						%>
					</td>
					<td><input type="radio" name="giveBack" value="<%=i + 1%>" /></td>
				</tr>
				<%
					}
				%>
			</table>
			<div class="borrow_area">
				<input type="button" value="归还" class="borrowButton"
					onclick="giveBackBook();" />
			</div>
			<%
				}
			%>
		</div>
	</div>
</body>
</html>