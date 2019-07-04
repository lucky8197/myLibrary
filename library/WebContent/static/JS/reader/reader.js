/**
 * 显示借阅排行榜
 * @returns
 */
function showTop(){
	$.post("showBookTop",
		function(data , statusText){
			window.setTimeout("window.location.reload();" , 600000);
		} , "html");
}