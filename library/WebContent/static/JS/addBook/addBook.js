var nameFlag = false;
var typeFlag = false;
var caseFlag = false;
var authorFlag = false;
var concernFlag = false;
var priceFlag = false;
var countFlag = false;
var pageFlag = false;



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


/*校验书名*/
function checkName(str){
	if(str == ""){
		document.getElementById("name_message").style = "color:#f40";
		document.getElementById("name_message").innerHTML = "请输入书名";
		nameFlag = false;
	}else if(str.length >= 30){
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
	if(str == ""){
		typeFlag = true;
	}else if(str.length >= 30){
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
	if(str == ""){
		caseFlag = true;
	}else if(str.length >= 30){
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
	if(str == ""){
		document.getElementById("author_message").style = "color:#f40";
		document.getElementById("author_message").innerHTML = "请输入作者";
		authorFlag = false;
	}else if(str.length >= 50){
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
	if(str == ""){
		concernFlag = true;
	}else if(str.length >= 50){
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
	if(str == ""){
		document.getElementById("price_message").style = "color:#f40";
		document.getElementById("price_message").innerHTML = "请输入价格";
		pricceFlag = false;
	}else if(str.length >= 50){
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
	if(str == ""){
		document.getElementById("count_message").style = "color:#f40";
		document.getElementById("count_message").innerHTML = "请输入数量";
		countFlag = false;
	}else if(str.length >= 50){
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
	if(str == ""){
		pageFlag = true;
	}else if(str.length >= 50){
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
	document.getElementById("name_message").innerHTML = "";
	document.getElementById("type_message").innerHTML = "";
	document.getElementById("case_message").innerHTML = "";
	document.getElementById("author_message").innerHTML = "";
	document.getElementById("concern_message").innerHTML = "";
	document.getElementById("price_message").innerHTML = "";
	document.getElementById("count_message").innerHTML = "";
	document.getElementById("page_message").innerHTML = "";
}

/*添加图书*/
function addBook(){
	if(!nameFlag){
		if(document.getElementById("book_name").value == ""){
			alert("请输入书名");
		}else{
			alert("书名有误");
		}
		return;
	}
	if(!typeFlag){
		if(document.getElementById("book_type").value == ""){
			typeFlag = true;
		}else{
			alert("类型有误");
			return;
		}
	}
	if(!caseFlag){
		if(document.getElementById("book_case").value == ""){
			caseFlag = true;
		}else{
			alert("书架有误");
			return;
		}
	}
	if(!authorFlag){
		if(document.getElementById("author").value == ""){
			alert("请输入作者");
		}else{
			alert("作者有误");
		}
		return;
	}
	if(!concernFlag){
		if(document.getElementById("book_concern").value == ""){
			concernFlag = true;
		}else{
			alert("出版社有误");
			return;
		}
	}
	if(!priceFlag){
		if(document.getElementById("price").value == ""){
			alert("请输入作者");
		}else{
			alert("作者有误");
		}
		return;
	}
	if(!countFlag){
		if(document.getElementById("count").value == ""){
			alert("请输入数量");
		}else{
			alert("数量有误");
		}
		return;
	}
	if(!pageFlag){
		if(document.getElementById("book_concern").value == ""){
			pageFlag = true;
		}else{
			alert("页数有误");
			return;
		}
	}
	
	$.post("addBook" , $("#form").serializeArray(),	
		function(data , statusText){
			alert(data);
			window.location.reload();
		},"html");
}













