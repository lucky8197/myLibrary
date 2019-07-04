var setTime = function(){
	document.getElementById("time").innerHTML = new Date().
	toLocaleString();
}
window.setInterval("setTime();" , 1000);
