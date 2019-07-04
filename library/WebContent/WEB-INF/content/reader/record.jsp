<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,vo.*,java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<%
	int index;
	if (session.getAttribute("nowPage") == null) {
		index = 1;
	} else {
		index = (Integer) session.getAttribute("nowPage");
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/record.css" />
<script type="text/javascript">
/*查询所有借阅记录*/
function borrowRecords(){
	var refresh = "<%=session.getAttribute("refresh")%>";
	if(refresh == "null"){
		refresh = "true";
	}
	if(refresh == "true"){
		$.post("findBorrowRecord",
				function(data , statusText){
					alert(data);
					if(data == "已检索到你所有的借阅记录"){
						window.location.reload(true);
					}else if(data == "长时间未操作，请重新登录！"){
						window.location.href="http://localhost:8888/library/login";
					}	
				},"html");
		/*首页*/
		firstPage();
	}
}
/*上一页*/
function previousPage(){
	var nowPage = "<%=index%>";
	var flag = "上一页";
	$.post("ChangePage" , {nowPage:nowPage,flag:flag} , "html");
	window.location.reload();
}
/*下一页*/
function nextPage(){
	var nowPage = "<%=index%>";
	var flag = "下一页";
	$.post("ChangePage" , {nowPage:nowPage,flag:flag} ,"html");
	window.location.reload();
}
/*首页*/
function firstPage(){
	var nowPage = "<%=index%>";
	var flag = "首页";
	$.post("ChangePage" , {nowPage:nowPage,flag:flag} , "html");
	window.location.reload();
}
/*上一页*/
function finalPage(){
	var nowPage = "<%=index%>";
		var flag = "末页";
		$.post("ChangePage", {
			nowPage : nowPage,
			flag : flag
		}, "html");
		window.location.reload();
	}
</script>
<title>借阅记录</title>
</head>
<body onload="borrowRecords();">
	<%@ include file="readerHeader.jsp"%>
	<div class="wrap">
		<div class="resultArea">
			<%
				Map<Integer, List<BorrowBean>> map = new HashMap<Integer, List<BorrowBean>>();
				map = (Map<Integer, List<BorrowBean>>) session.getAttribute("allBorrowList");
				if (map != null && map.size() > 0) {
			%>
			<table id="bookResult" border="1">
				<caption class="table_caption">所有借阅记录</caption>
				<tr>
					<th>ID</th>
					<th>书名</th>
					<th>类型</th>
					<th>作者</th>
					<th>借阅时间</th>
					<th>应还时间</th>
					<th>归还时间</th>
					<th>是否归还</th>
				</tr>
				<%
					for (int i = 0; i < map.get(index).size(); i++) {
				%>
				<tr>
					<td><%=map.get(index).get(i).getId()%></td>
					<td><%=map.get(index).get(i).getBook().getBook_name()%></td>
					<td>
						<%
							String bookType = map.get(index).get(i).getBook().getBook_type();
									if (bookType == null) {
										bookType = "无";
									}
									out.print(bookType);
						%>
					</td>
					<td>
						<%
							String Author = map.get(index).get(i).getBook().getAuthor();
									if (Author == null) {
										Author = "无";
									}
									out.print(Author);
						%>
					</td>
					<%
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					%>
					<td><%=format.format(map.get(index).get(i).getBorrow_time())%></td>
					<td>
						<%
							Date back_time = map.get(index).get(i).getBack_time();
									out.print(format.format(back_time));
						%>
					</td>
					<td>
						<%
							Date BackTime = map.get(index).get(i).getBackTime();
									if (BackTime == null) {
										String strBackTime = "无";
										out.print(strBackTime);
									} else {
										out.print(format.format(BackTime));
									}
						%>
					</td>
					<td class="ifBack">
						<%
							String ifBack;
									if (BackTime == null) {
										ifBack = "否";
									} else {
										ifBack = "是";
									}
									out.print(ifBack);
						%>
					</td>
				</tr>

				<%
					}
				%>
			</table>
			<div class="pagingArea">
				<div class="pagingWrap">
					<ul>
						<li class="paging"><a href="javascript:firstPage();">首页</a></li>
						<li class="paging"><a href="javascript:previousPage();">上一页</a></li>
						<li class="paging"><a href="javascript:nextPage();">下一页</a></li>
						<li class="paging"><a href="javascript:finalPage();">末页</a></li>
						<li class="paging"><label>第<%=index%>页
						</label></li>
						<li class="paging"><label>共<%=map.size()%>页
						</label></li>
					</ul>
				</div>
			</div>
			<%
				}
			%>
		</div>
	</div>
</body>
</html>