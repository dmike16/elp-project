self.addEventListener('push',(evt)=>{
  console.log('[Service Worker] Push Received.');
  console.log(`[Service Worker] Push had this data: "${evt.data.text()}"`);

  const title = 'Push Codelab';
  const options = {
    body: evt.data.text(),
    icon: 'images/icon.png',
    badge: 'images/badge.png'
  };
  evt.waitUntil(self.registration.showNotification(title,options));
});

self.addEventListener('notificationclick',(evt)=>{
  console.log('[ServiceWorker] Notification click');
  evt.notification.close();
  evt.waitUntil(clients.openWindow('https://developers.google.com/web/'));
});
