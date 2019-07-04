var idFlag = false;
var nameFlag = true;
var typeFlag = true;
var caseFlag = true;
var authorFlag = true;
var concernFlag = true;
var priceFlag = true;
var countFlag = true;
var pageFlag = true;


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


/*校验书ID*/
function checkId(str){
	if(str == ""){
		document.getElementById("id_message").style = "color:#f40";
		document.getElementById("id_message").innerHTML = "请输入id";
		window.setTimeout("document.getElementById('id').focus();",3000);
		idFlag = false;
	}else{
		/*Ajax异步调用*/
		$.post("checkId", $("#id").serializeArray(),
			function(data , statusText){
				if(data.length == 5){
					document.getElementById("id_message").style = "color:gray;";
					document.getElementById("id_message").innerHTML = "输入id存在";
					idFlag = true;
				}else{
					document.getElementById("id_message").style = "color:red;";
					document.getElementById("id_message").innerHTML = "输入的id不存在";				
					window.setTimeout("document.getElementById('id').focus();",3000);
					idFlag = false;
				}
			},"html");
	}
}


/*校验书名*/
function checkName(str){
	if(str.length >= 30){
		document.getElementById("name_message").style = "color:#f40";
		document.getElementById("name_message").innerHTML = "你输入的书名不符合要求";
		nameFlag = false;
	}else{
		nameFlag = true;
	}
	
}

/*获得焦点后，显示提示信息*/
function name_message(){
	document.getElementById("name_message").style = "color:gray;";
	document.getElementById("name_message").innerHTML = "*30位以内(带*的必填)";
}

/*校验类型*/
function checkType(str){
	if(str.length >= 30){
		document.getElementById("type_message").style = "color:#f40";
		document.getElementById("type_message").innerHTML = "你输入的书名不符合要求";
		typeFlag = false;
	}else{
		typeFlag = true;
	}
}

/*获得焦点后，显示提示信息*/
function type_message(){
	document.getElementById("type_message").style = "color:gray;";
	document.getElementById("type_message").innerHTML = "20位以内";
}

/*校验书架*/
function checkCase(str){
	if(str.length >= 30){
		document.getElementById("case_message").style = "color:#f40";
		document.getElementById("case_message").innerHTML = "你输入的类型不符合要求";
		caseFlag = false;
	}else{
		caseFlag = true;
	}
}

/*获得焦点后，显示提示信息*/
function case_message(){
	document.getElementById("case_message").style = "color:gray;";
	document.getElementById("case_message").innerHTML = "30位以内";
}

/*校验作者*/
function checkAuthor(str){
	if(str.length >= 50){
		document.getElementById("author_message").style = "color:#f40";
		document.getElementById("author_message").innerHTML = "你输入的作者不符合要求";
		authorFlag = false;
	}else{
		authorFlag = true;
	}
}

/*获得焦点后，显示提示信息*/
function author_message(){
	document.getElementById("author_message").style = "color:gray;";
	document.getElementById("author_message").innerHTML = "50位以内";
}

/*校验出版社*/
function checkConcern(str){
	if(str.length >= 50){
		document.getElementById("concern_message").style = "color:#f40";
		document.getElementById("concern_message").innerHTML = "你输入的出版社不符合要求";
		concernFlag = false;
	}else{
		concernFlag = true;
	}
}

/*获得焦点后，显示提示信息*/
function concern_message(){
	document.getElementById("concern_message").style = "color:gray;";
	document.getElementById("concern_message").innerHTML = "10位以内";
}


/*校验价格*/
function checkPrice(str){
	if(str.length >= 50){
		document.getElementById("price_message").style = "color:#f40";
		document.getElementById("price_message").innerHTML = "你输入的价格不符合要求";
		priceFlag = false;
	}else{
		priceFlag = true;
	}
}
 	
/*获得焦点后，显示提示信息*/
function price_message(){
	document.getElementById("price_message").style = "color:gray;";
	document.getElementById("price_message").innerHTML = "8位以内";
}

/*校验数量*/
function checkCount(str){
	if(str.length >= 50){
		document.getElementById("count_message").style = "color:#f40";
		document.getElementById("count_message").innerHTML = "你输入的数量不符合要求";
		countFlag = false;
	}else{
		countFlag = true;
	}
}

/*获得焦点后，显示提示信息*/
function count_message(){
	document.getElementById("count_message").style = "color:gray;";
	document.getElementById("count_message").innerHTML = "10位以内";
}

/*校验页数*/
function checkPage(str){
	if(str.length >= 50){
		document.getElementById("page_message").style = "color:#f40";
		document.getElementById("page_message").innerHTML = "你输入的数量不符合要求";
		pageFlag = false;
	}else{
		pageFlag = true;
	}
}

/*获得焦点后，显示提示信息*/
function page_message(){
	document.getElementById("page_message").style = "color:gray;";
	document.getElementById("page_message").innerHTML = "10位以内";
}

/*清除所有提示信息*/
function resetAll(){
	document.getElementById("id_message").innerHTML = "";
	document.getElementById("name_message").innerHTML = "";
	document.getElementById("type_message").innerHTML = "";
	document.getElementById("case_message").innerHTML = "";
	document.getElementById("author_message").innerHTML = "";
	document.getElementById("concern_message").innerHTML = "";
	document.getElementById("price_message").innerHTML = "";
	document.getElementById("count_message").innerHTML = "";
	document.getElementById("page_message").innerHTML = "";
}

/*更新图书*/
function updateBook(){
	if(!idFlag){
		alert("id有误");
		return;
	}
	if(!nameFlag){
		alert("书名有误");
		return;
	}
	if(!typeFlag){
		alert("类型有误");
		return;
	}
	if(!caseFlag){
		alert("书架有误");
		return;
	}
	if(!authorFlag){
		alert("作者有误");
		return;
	}
	if(!concernFlag){
		alert("出版社有误");
		return;
	}
	if(!priceFlag){
		alert("作者有误");
		return;
	}
	if(!countFlag){
		alert("数量有误");
		return;
	}
	if(!pageFlag){
		alert("页数有误");
		return;

	}
	$.post("updateBook" , $("#form").serializeArray(),	
		function(data , statusText){
			alert(data);
		},"html");
}


