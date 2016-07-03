function createXHR(){
  try{ return new XMLHttpRequest();}catch(ignore){}
  try{ return new ActiveXObject("Msxm12.XMLHTTP.6.0");}catch(ignore){}
  try{ return new ActiveXObject("Msxm12.XMLHTTP.3.0");}catch(ignore){}
  try{ return new ActiveXObject("Msxm12.XMLHTTP");}catch(ignore){}
  try{ return new ActiveXObject("Microsoft.XMLHTTP");}catch(ignore){}
  return null;
}
