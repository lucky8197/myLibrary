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

/*搜索读者*/
function findReader(){
	if(document.getElementById("readerInfo").value == ""){
		alert("请输入检索内容！");
		return;
	}
	$.post("searchReader" ,$("#form").serializeArray(),
		function (data , statusText){
			alert(data);
			if(data == "已检索到相关读者！"){				
				window.location.reload();
			}
		},"html");
}
/*重置输入框*/
function removeInput(){
	$("#resultArea").css("display","none");
}
/*删除读者*/
function removeReader(){
	var removeCheck = document.getElementsByName("remove");
	var removeIndex;
	for(var i = 0; i < removeCheck.length; i++){
		if(removeCheck[i].checked == true){
			removeIndex = i;
			break;
		}
	}
	if(removeIndex == null){
		alert("请选择读者");
		return;
	}
	$.post("removeReader" , {removeIndex:removeIndex}, 
			function(data , statusText){
				alert(data);
				if(data == "长时间未操作，请重新登录！"){
					window.location.href="http://localhost:8888/library/login";
				}else if(data == "删除成功"){
					window.location.reload();
				}
			},"html");
}
