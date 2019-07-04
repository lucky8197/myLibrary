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
function searchReader(){
	if(document.getElementById("ReaderInfo").value == ""){
		alert("请输入检索内容！");
		return;
	}
	var ra = document.getElementsByName("way");
	for(var i = 0; i < ra.length; i++){
		if(ra[i].checked == true){
			break;
		}
		if(i == ra.length - 1){
			alert("请输入检索方式！");
			return;
		}
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