const CACHE_NAME = 'star-wars-v4';
const urls = [
  'index.html',
  'style.css',
  'star-wars-logo.jpg',
  'gallery',
  'gallery/bountyHunters.jpg',
  'gallery/myLittleVader.jpg',
  'gallery/snowTroopers.jpg'
];

self.addEventListener('install',(event)=>{
  console.log('Install Event Service Worker');
  event.waitUntil(
    caches.open(CACHE_NAME).then((cache)=>{
      console.log('Open cache');
      return cache.addAll(urls);
    })
  );
});

self.addEventListener('fetch',(event)=>{
  console.log('Fetch Service Worker');
  event.respondWith(
    caches.match(event.request).then((response)=>{
      if(response){
        return response;
      }
      let fetchRequest = event.request.clone();
      return fetch(fetchRequest)
        .then((response)=>{
          if(!response || response.status !== 200 || response.type !== 'basic'){
            return response;
          }
          let responseToCache = response.clone();
          return caches.open(CACHE_NAME).then((cache)=>{
            cache.put(event.request,responseToCache);
            return response;
          });
        });
    }).catch((err)=>{
      console.log('Fetch error Service Worker');
      return caches.put('/serviceworker/gallery/myLittleVader.jpg');
    })
  );
});

self.addEventListener('activate',(event)=>{
  console.log('Active');
  const CACHE_WHITE_LIST = [CACHE_NAME];
  event.waitUntil(caches.keys().then((names)=>{
    return Promise.all(names.map((name)=>{
      if(CACHE_WHITE_LIST.indexOf(name) === -1){
        return caches.delete(name);
      }
    }));
  }));
});

self.addEventListener('sync',(e)=>{
  self.registration.showNotification('Sync Event Fired for tag: '+e.tag);
});
