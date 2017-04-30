const dataCacheName = 'weatherData-v1';
const cacheName = 'weatherPWA-final-1';
const filesToCache = [
  '/elp-project/branches/html/webFundamental/pwapp/',
  'index.html',
  'scripts/app.js',
  'styles/inline.css',
  'images/clear.png',
  'images/cloudy-scattered-showers.png',
  'images/cloudy.png',
  'images/fog.png',
  'images/ic_add_white_24px.svg',
  'images/ic_refresh_white_24px.svg',
  'images/partly-cloudy.png',
  'images/rain.png',
  'images/scattered-showers.png',
  'images/sleet.png',
  'images/snow.png',
  'images/thunderstorm.png',
  'images/wind.png'
];

self.addEventListener('install', (e)=> {
  console.log('[ServiceWorker] Install');
  e.waitUntil(
    caches.open(cacheName).then(function(cache) {
      console.log('[ServiceWorker] Caching app shell');
      return cache.addAll(filesToCache);
    })
  );
});

self.addEventListener('active',(e)=>{
  console.log('[ServiceWorker] Activate');
  e.waitUntil(caches.keys().then((names)=>{
    return Promise.all(names.map((name)=>{
      if(name !== cacheName && name !== dataCacheName){
        console.log('[ServiceWorker] Removing old cache ',key);
        return caches.delete(key);
      }
    }));
  }));
});

self.addEventListener('fetch', (e)=> {
  console.log('[Service Worker] Fetch', e.request.url);
  let dataUrl = 'https://query.yahooapis.com/v1/public/yql';
  if (e.request.url.indexOf(dataUrl) > -1) {
    /*
     * When the request URL contains dataUrl, the app is asking for fresh
     * weather data. In this case, the service worker always goes to the
     * network and then caches the response. This is called the "Cache then
     * network" strategy:
     * https://jakearchibald.com/2014/offline-cookbook/#cache-then-network
     */
    e.respondWith(
      caches.open(dataCacheName).then(function(cache) {
        return fetch(e.request).then(function(response){
          cache.put(e.request.url, response.clone());
          return response;
        });
      })
    );
  } else {
    /*
     * The app is asking for app shell files. In this scenario the app uses the
     * "Cache, falling back to the network" offline strategy:
     * https://jakearchibald.com/2014/offline-cookbook/#cache-falling-back-to-network
     */
    e.respondWith(
      caches.match(e.request).then(function(response) {
        return response || fetch(e.request);
      })
    );
  }
});
