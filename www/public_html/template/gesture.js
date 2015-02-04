/* JavaScript Learning*/
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