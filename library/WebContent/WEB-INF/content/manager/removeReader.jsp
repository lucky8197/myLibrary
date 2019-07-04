<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,vo.*,java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/removeReader.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/JS/removeReader/removeReader.js"></script>
<title>删除读者</title>
</head>
<body>
	<%@include file="managerHeader.jsp"%>	
	
	<form id="form" action="removeReader" method="post">
		<input type="text" id="readerInfo" name="readerInfo" /><input
			type="button" class="find" value="按用户名检索"
			onclick="removeInput();findReader();" /> <input type="hidden"
			name="way" value="user" /> <br />
	</form>

	<div class="resultArea" id="resultArea">
		<%
			List<PersonBean> person = new ArrayList<>();
			person = (List<PersonBean>) session.getAttribute("personManagement");
			if (person != null && person.size() > 0) {
		%>
		<table id="bookResult" border="1" bgcolor="#999999" width="888px">
			<caption class="table_caption">检索结果</caption>
			<tr>
				<th>ID</th>
				<th>用户名</th>
				<th>姓名</th>
				<th>性别</th>
				<th>职业</th>
				<th>邮箱</th>
				<th>电话号码</th>
				<th>生日</th>
				<th>创建时间</th>
				<th>操作</th>
			</tr>
			<%
				for (int i = 0; i < person.size(); i++) {
			%>
			<tr>
				<td><%=person.get(i).getId()%></td>
				<td><%=person.get(i).getUser()%></td>
				<td>
					<%
						String name = person.get(i).getName();
								if (name == null || name == "") {
									name = "无";
								}
								out.print(name);
					%>
				</td>
				<td>
					<%
						String sex = person.get(i).getSex();
								if (sex == null || sex == "") {
									sex = "无";
								}
								out.print(sex);
					%>
				</td>
				<td>
					<%
						String vocation = person.get(i).getVocation();
								if (vocation == null || vocation == "") {
									vocation = "无";
								}
								out.print(vocation);
					%>
				</td>
				<td><%=person.get(i).getEmail()%></td>
				<td><%=person.get(i).getTel()%></td>
				<%
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				%>
				<td>
					<%
						Date birthday = person.get(i).getBirthday();
								if (birthday == null) {
									String birthdayStr = "无";
									out.print(birthdayStr);
								} else {
									out.print(birthday);
								}
					%>
				</td>
				<td><%=format.format(person.get(i).getCreate_date())%></td>
				<td><input type="radio" name="remove" value="<%=i + 1%>" /></td>
			</tr>
			<%
				}
			%>
		</table>
		<div class="remove_area">
			<input type="button" value="删除" class="borrowButton"
				onclick="removeReader();" />
		</div>
		<%
			}
		%>
	</div>
</body>
</html>