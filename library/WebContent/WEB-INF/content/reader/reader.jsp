<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>读者主页</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/reader.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/JS/reader/reader.js"></script>
</head>
<body onload="stack();showTop();">
	<%@ include file="readerHeader.jsp"%>
		<div class="center">
			<div class="ranking">
				<%
					List<BookBean> list = new ArrayList<>();
					list = (List<BookBean>) session.getAttribute("bookTop");
					if (list != null && list.size() > 0) {
				%>
				<span>借阅排行榜</span>
				<table border="1">
					<tr>
						<th>编号</th>
						<th>书名</th>
						<th>类型</th>
						<th>作者</th>
						<th class="red">总借阅数</th>
					</tr>
					<%
						for (int i = 0; i < list.size(); i++) {
					%>
					<tr>
						<td><%=list.get(i).getId()%></td>
						<td><%=list.get(i).getBook_name()%></td>
						<td>
							<%
								String type = list.get(i).getBook_type();
										if (type == null || type == "") {
											type = "无";
										}
										out.print(type);
							%>
						</td>
						<td><%=list.get(i).getAuthor()%></td>
						<td><%=list.get(i).getBorrownum()%></td>
					</tr>
					<%
						}
						}
					%>
				</table>
			</div>
			<span>公告</span>
			<div class="notice">
				<%
					String notice = (String) application.getAttribute("notice");
					if (notice != null) {
						out.print((String) application.getAttribute("notice"));
					}else{
						out.print("管理员还未发布公告");
					}
				%>
			</div>
		</div>
		<%@ include file="../footer.jsp"%>
</body>
</html>