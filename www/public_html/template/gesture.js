/* JavaScript Learning*/
/* Class Example
function Polygon(iSides){
    this.sides=iSides;
    if(typeof Polygon._initialized == "undefined"){
        Polygon.prototype.getArea=function(){
            return 0;
        };
    }
    Polygon._initialized = true;
}

function Triangle(iBase,iHeight){
    Polygon.call(this,3);
    this.base = iBase;
    this.height = iHeight;
    if(typeof Triangle._initialized == "undefined"){
        Triangle.prototype.getArea = function(){
            return 0.5*this.base*this.height;
        };
    }
    Triangle._initialized = true;
}
Triangle.prototype = Object.create(Polygon);

function Rectangle(iLenght,iWidth){
    Polygon.call(this,4);
    this.lenght = iLenght;
    this.width = iWidth;
    if(typeof Rectangle._initialized == "undefined"){
        Rectangle.prototype.getArea =function(){
            return this.lenght*this.width;
        };
    }
}
Rectangle.prototype = new Polygon();

var tri = new Triangle(12,4);
var rec = new Rectangle(22,11);
alert(tri.sides);
alert(tri.getArea());

alert(rec.sides);
alert(rec.getArea());
*/

/*
 * Popup window
var oNewWin=window.open("license.html","_blank","height=150,width=300i,resizable=yes");
oNewWin.moveTo(0,0);
oNewWin.resizeTo(300,500);*/


/*
 * Confirm Popup
 if(confirm("Are you sure")){
    alert("I'm so glad you're sure");
}else{
    alert("i'm sorry !!!!!");
}*/

/* prompt
var sResult = prompt("What's your name",",");
if(sResult != null){
    alert("welcom, " + sResult);
}*/


/* Status bar
window.status="You ar createa";
*/
/* Timeout and Interval
//var iTimeoutId = setTimeout(function(){alert("Hello ZIO"); },2000);
//clearTimeout(iTimeoutId);
var iNum = 0;
var iMax = 10;
var iIntervalID;

function incNum(){
    iNum++;
    
    if(iNum == iMax){
        clearInterval(iIntervalID);
    }
    alert("Bella zio");
}
iIntervalID = setInterval(incNum, 1000);
*/

/* History
alert(window.history.lenght);
*/

/* Open and Write on*/
var oNewWin = window.open("about::blank", "newwindow","height=150,width=300,top=10,left=10,resizable=yes");

oNewWin.document.open();
oNewWin.document.write("<html><head><title>New Window</title></head>");
oNewWin.document.write("<body>This is a Nea Window</body></html>");
oNewWin.document.close();