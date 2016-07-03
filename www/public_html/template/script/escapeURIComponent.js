(function(exp)
{
  'use strict';
  var encodeUriFixed;
  if(typeof encodeURIComponent === 'undefined')
  {
    encodeUriFixed = function encodeURIFixed(str)
    {
      return escape(str).replace(/@/g,"%40")
      .replace(/\//g,"%2F").replace(/\+/g,"%2B").replace(/\%20/g,"+");
    };
  }else
  {
      encodeUriFixed = function escapeURIComponent(str)
      {
        return encodeURIComponent(str).replace(/[!'()*]/g,function(c)
      {
        return '%' + c.charCodeAt(0).toString(16);
      }).replace(/\%20/g,'+');
      };
  }
  if(Object.defineProperty){
    Object.defineProperty(exp,'encodeUriFixed',{
      configurable: true,
      enumerable : true,
      writable: false,
      value: encodeUriFixed
    });
  }else
  {
    exp.encodeUriFixed = encodeUriFixed;
  }
}(window));
