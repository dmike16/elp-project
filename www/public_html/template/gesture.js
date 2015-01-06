/* JavaScript Learning*/

function sayHi(){
    alert("Bella zio");
}
function callAnotherFunction(fnFunction,vArgument){
    fnFunction(vArgument);
}

callAnotherFunction(sayHi);
alert(callAnotherFunction.toString());