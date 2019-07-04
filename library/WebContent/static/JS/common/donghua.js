var statusText = "Copyright 2019-2020 All Right Reserved. 罗亮. 版权所有 联系地址：常州市常州大学武进校区。电话：18351211787 维护：罗亮　　技术支持：罗亮"
var out = "";
var pause = 0.1;
var animateWidth = 10;
var position = animateWidth;
var i = 0;
var stack = function(){
	if(statusText.charAt(i) != " "){
		out = "";
		//将第 0到第i-1 个字符拼成输出字符串
		for(var j = 0; j < i; j++){
			out += statusText.charAt(j);
		}
		//增加一定宽度的空格
		for(j = i; j < position; j++){
			out += "&nbsp";
		}
		//将第i个字符添加到输出字符串里
		out += statusText.charAt(i);
		for(j = position; j < animateWidth; j++){
			out += "&nbsp"; 
		}
		document.getElementById("copyright").innerHTML = out;
		//如果后出来的字符串紧靠前面的字符串
		if(position == i){
			animateWidth++;
			position = animateWidth;
			i++;
		}
		else{
			position--;
		}
	}else{
		i++;
	}
	if(i < statusText.length){
		 window.setTimeout("stack()",pause); 
	}	
}
