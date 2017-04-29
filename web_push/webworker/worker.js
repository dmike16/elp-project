(function(){
  'use strict';

  document.getElementById('btnHi').addEventListener('click',()=>{
      worker.postMessage({'cmd':'start','msg':'Hello'});
  });
  document.getElementById('btnUnk').addEventListener('click',()=>{
      worker.postMessage({'cmd':'foo','msg':'???'});
  });
  document.getElementById('btnStop').addEventListener('click',()=>{
      worker.postMessage({'cmd':'stop','msg':'Bye'});
  });

  let worker = new Worker('dedicated/dictaded.js');
  worker.addEventListener('message',(e)=>{
    document.getElementById('result').textContent = 'From Worker : '+e.data;
  },false);
}());
