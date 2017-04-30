(function() {
  'use strict';

  //Wrap HttpRequeste in a Promise.
  function get(url) {
    return new Promise((resolve, reject) => {
      let req = new XMLHttpRequest();
      req.open('GET', url);

      req.onload = () => {
        if (req.status === 200) {
          resolve(req.response);
        } else {
          reject(Error(req.stausText));
        }
      };

      req.onerror = () => {
        reject(Error("Network Error"));
      };

      req.send();
    });
  }

  function getJSON(url) {
    return get(url).then(JSON.parse)
      .catch((error) => {
        console.log('[INFO] Error: ', error);
        throw error;
      });
  }

  getJSON('story.json').then((story) => {
    console.log('HEAD', story.heading);
    return story.chapterUrls.map(getJSON)
      .reduce((sequence,chapterPromise)=>{
        return sequence.then(()=>{
          return chapterPromise;
        }).then((chapter)=>{
          console.log('Chapter',chapter.html);
        });
      },Promise.resolve());
  }).then(()=>{
    console.log('All done');
  }).catch((err)=>{
    console.log(err);
  }).then(()=>{
    console.log('Stop spinner');
  });


})();
