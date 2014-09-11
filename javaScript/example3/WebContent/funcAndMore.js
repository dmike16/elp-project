/**
 * 
 */
function ToConvert(frm) {
	var str=frm.units.value;
	var T=parseFloat(frm.temp.value);
	
	if(str == "celsius")
		return ((5/9)*(T-32)).toFixed(2);
	else if (str == "fara")
		return (((9/5)*T)+32).toFixed(2);
	else return "Not a valid units";
}