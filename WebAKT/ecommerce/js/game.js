$(function($){
	var bound = {
		width: window.innerWidth,
		heigth: window.innerHeight
	};
	
	$("button").on("mouseover",{lim: bound},function(e){
		var x = e.data.width*Math.random();
		var y = e.data.height*Math.random();
		
	});
});