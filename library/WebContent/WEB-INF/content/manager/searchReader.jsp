<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,vo.*,java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/searchReader.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/JS/searchReader/searchReader.js"></script>
<title>搜索读者</title>
</head>
<body>
	<%@include file="managerHeader.jsp"%>
	
	<form id="form" action="searchReader" method="post">
		<input type="text" id="ReaderInfo" name="ReaderInfo" /><input
			type="button" class="find" value="检索"
			onclick="removeInput();searchReader();" /> <br />
		<div class="wayArea">
			<label class="fingWay">检索方式：</label> <input type="radio" name="way"
				value="user" checked> 按用户名 <input type="radio" name="way"
				value="name"> 按姓名 <input type="radio" name="way"
				value="tel"> 按电话号码
		</div>
	</form>

	<div class="resultArea" id="resultArea">
		<%
			List<PersonBean> person = new ArrayList<>();
			person = (List<PersonBean>) session.getAttribute("personManagement");
			if (person != null && person.size() > 0) {
		%>
		<table id="personResult" border="1" bgcolor="#999999" width="888px">
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
								if (name == null) {
									name = "无";
								}
								out.print(name);
					%>
				</td>
				<td>
					<%
						String sex = person.get(i).getSex();
								if (sex == null) {
									sex = "无";
								}
								out.print(sex);
					%>
				</td>
				<td>
					<%
						String vocation = person.get(i).getVocation();
								if (vocation == null) {
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
			</tr>
			<%
				}
			%>
		</table>
		<%
			}
		%>
	</div>
</body>
</html>