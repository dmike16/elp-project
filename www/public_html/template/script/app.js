(function(){
  var app = angular.module('gemStore', []);

  app.controller('StoreController', function(){
    this.products = gems;
  });
  var gems = [
    {
      name: 'Dodecahedron',
      price: 112.95,
      description: 'Something Special',
      canPurchase: false,
      soldOut: false,
      images:[
        'ddmLogo.svg',
        'ddmLogo.svg'
      ]
    },
    {
      name: 'Azurite',
      price: 32,
      description: 'Something Special',
      canPurchase: true,
      soldOut: false,
      images:[
        'ddmLogo.svg',
        'ddmLogo.svg'
      ]
    },
    {
      name: 'Zircon',
      price: 1233,
      description: 'Something Special',
      canPurchase: false,
      soldOut: false,
      images:[
        'ddmLogo.svg',
        'ddmLogo.svg'
      ]
    }
  ];

  // Using Promises for Ajax request
  function $http(url){
    var core = {
      ajax: function(method, url, args){
        var promise = new Promise(function(resolve, reject){

          var client = new XMLHttpRequest();
          var uri = url;

          client.open(method, uri);
          client.onload = function(){
            if (this.status >= 200 && this.status < 300){
              resolve(this.response);
            } else {
              reject(this.statusText);
            }
          };
          client.onerror = function(){
            reject(this.statusText);
          };
          client.send();
          client = null;
        });

        return promise;
      }
    };

    return {
      'get': function get(args){
        return core.ajax('GET',url,args);
      }
    };
  }

  var dmAPI = 'story.json';

  function getJSON(url){
    return $http(url).get('default').then(JSON.parse).catch(function(err){
      console.error("getJSON failed for", url, err);
      throw err;
    });
  }
  /*var storyPromise;

  function getChapter(i){
    storyPromise = storyPromise || getJSON(dmAPI);

    return storyPromise.then(function(story){
      return getJSON(story.chapterUrls[i]);
    });
  }

  getChapter(1).then(function(chapter){
    console.log('c',chapter);
  },function(err){
    console.log('e',err);
  });*/

  // Download ASYNC all the chapter
  // First Version Download one at Time

  /*
  getJSON(dmAPI).then(function(story){
    console.log(story.heading);

    return story.chapterUrls.reduce(function(sequence,chapterUrl){
      return sequence.then(function(){
        return getJSON(chapterUrl);
      }).then(function(chapter){
        console.log(chapter.name);
      });
    }, Promise.resolve());
  }).then(function(){
    console.log("All Done");
  }).catch(function(err){
    console.error("Error" + err.message);
  }).then(function(){
    document.querySelector('#spinner').style.display = 'none';
  });
  */

  // Second Version Download all one time and afetef apply
  /*
  getJSON(dmAPI).then(function(story){
    console.log(story.heading);

    return Promise.all(story.chapterUrls.map(getJSON));
  }).then(function(chapters){
    chapters.forEach(function(chapter){
      console.log(chapter.name);
    });
    console.log("All Done");
  }).catch(function(err){
    console.error("Error" + err.message);
  }).then(function(){
    document.querySelector('#spinner').style.display = 'none';
  });
  */

  // Thirth Version Download all in one and apply in sequence
  getJSON(dmAPI).then(function(story){
    console.log(story.heading);

    return story.chapterUrls.map(getJSON).reduce(function(sequence,chapterPromises){
      return sequence.then(function(){
        return chapterPromises;
      }).then(function(chapter){
        console.log(chapter.name);
      });
    },Promise.resolve());
  }).then(function(){
    console.log("All Done");
  }).catch(function(err){
    console.error("Error" + err.message);
  }).then(function(){
    document.querySelector('#spinner').style.display = 'none';
  });
}());
