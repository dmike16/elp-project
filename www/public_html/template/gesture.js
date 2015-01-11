/* JavaScript Learning*/

function StringBuffer (){
	this.__strings__=new Array;
	
	if(typeof StringBuffer._initialized == "undefined"){
		StringBuffer.prototype.append = function (str){	
			this.__strings__.push(str);
		};
		StringBuffer.prototype.toString = function(){
			return this.__strings__.join("");
		};
	}
	StringBuffer._initialized = true;
}

var d1 = new Date();
var str="";
for(var i=0; i< 100; i++){
	str += "text";
}
var d2 = new Date();

alert("Concatenation with +: "+ (d2.getTime()-d1.getTime()));

var oBuffer = new StringBuffer();
d1 = new Date();
for (var i=0; i < 100; i++) {
	oBuffer.append("text");
}
var sResult = oBuffer.toString();
d2 = new Date();
alert("Concatenation with StringBuffer: " + (d2.getTime() - d1.getTime()));