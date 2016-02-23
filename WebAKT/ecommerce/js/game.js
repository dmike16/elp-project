$(function($){
	var bound = {
		width: window.innerWidth,
		heigth: window.innerHeight
	};
	
	$("button").on("mouseover",{lim: bound},function(e){
		var lambda = Math.random();
		var lim = e.data.lim;
		var x = (e.clientX - (lim.width*lambda));
		
		if((e.clientX + x) >= lim.width || (e.clientX +x) <= 0){
			x = e.clientX - lim.width /2;
		}

		lambda = Math.random();
		var y = (e.clientY - (lim.heigth*lambda));
		if((e.clientY + y) >= lim.heigth ||(e.clientY +y) <= 0){
			y = e.clientY - lim.heigth / 2;
		}
		var style = {
			transform: "translate("+x+"px,"+y+"px)"
		};
		
		$(this).css(style);
	});
});