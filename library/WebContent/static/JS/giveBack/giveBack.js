/*查询所有未归还的借阅记录*/
function notGiveBackBorrows(){
	if(document.getElementById("bookResult") == null){
		$.post("notGiveBackBorrows", 
				function(data , statusText){
					alert(data);
					if(data == "已检索到你所有未归还的借阅记录"){
						window.location.reload();
					}	
				},"html");
	}
}
/*还书*/
function giveBackBook(){
	var borrowCheck = document.getElementsByName("giveBack");
	var borrowIndex;
	for(var i = 0; i < borrowCheck.length; i++){
		if(borrowCheck[i].checked == true){
			borrowIndex = i;
			break;
		}
	}
	if(borrowIndex == null){
		alert("请选择书籍！");
		return;
	}
	$.post("giveBack" , {borrowIndex:borrowIndex}, 
		function(data , statusText){
			alert(data);
			if(data == "还书成功！"){
				$.post("notGiveBackBorrows", 
					function(data , statusText){
						if(data == "长时间未操作，请重新登录！"){
							window.location.href="http://localhost:8888/library/login";
						}	
						window.location.reload();
					},"html");
			}
		},"html");
}