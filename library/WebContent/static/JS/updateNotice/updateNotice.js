
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


function updateNotice(){
	$.post("updateNotice" , $("#form").serializeArray(),
			function(data , statusText){
				alert(data);
			} ,"html" );
}