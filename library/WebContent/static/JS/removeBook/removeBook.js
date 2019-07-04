/*删除书籍*/
function removeBook(){
	var borrowCheck = document.getElementsByName("remove");
	var bookIndex;
	for(var i = 0; i < borrowCheck.length; i++){
		if(borrowCheck[i].checked == true){
			bookIndex = i;
			break;
		}
	}
	if(bookIndex == null){
		alert("请选择书籍！");
		return;
	}
	$.post("removeBook" , {bookIndex:bookIndex}, 
		function(data , statusText){
			alert(data);
			if(data == "删除失败，重新登录试试"){
				window.location.href="logOut";
			}else if(data == "删除成功"){
				window.location.reload();
			}
		},"html");
}

