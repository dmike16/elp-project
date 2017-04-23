//Import and export
//export function beta(){console.log("Beta EACMS6");}
(function(){
  'use strict';
  //Constant variable reference
  const PI = 3.141593;
  console.log(PI);
  //Scoped variable
  let callback =[];
  for(let i = 0;i < 3; i++){
    callback[i] = i;
  }
  console.dir(callback);
  //Arrow function
  let sum = (x,y)=> x+y;
  console.log(sum(3,5));
  //Default parameters
  let mult = function mult(a,b=1){return a*b;};
  console.log(mult(3));
  //Rest parameters
  let rest = function rest(x,y,...a){
    return (x+y)*a.length;
  };
  console.log(rest(1,2,"hello","zio",3));
  //Spred operator
  var params = ["hello","zio",3];
  var other = [1,2,...params];
  console.log(other);
  //String interpolation
  var obj = {name : 'foo'};
  console.log(`Zio bello ${obj.name}`);
  console.log(String.raw`foo\n${42}ccc` === "foo\\n42ccc");
  //Array matching
  var list = [1,2,3];
  var [a,,b] = list;
  console.log([a,b] = [b,a]);
  //Class definition
  class Shape{
    constructor(id,x,y){
      this._id = id;
      this.move(x,y);
    }
    move(x,y){
      this._x = x;
      this._y = y;
    }

    get id(){return this._id;}
    set id(id){this._id = id;}
  }
  console.log(new Shape(1,2,3).id);
})();
