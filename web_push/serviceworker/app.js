(function() {
  'use strict';
  window.addEventListener('load', (e) => {
    if ('serviceWorker' in navigator) {
      window.addEventListener('load', (evt) => {
        navigator.serviceWorker.register('sw.js')
          .then((reg) => {
            console.log('Service Worker registered : ', reg.scope);
            if (reg.installing) {
              console.log('Service Worker Installing');
            } else if (reg.waiting) {
              console.log('Service Worker Waiting');
            } else if (reg.active) {
              console.log('Service Worker Active');
            }
            return reg.sync.getTags();
          }, (err) => {
            console.log('Error in Service Worker', err);
          })
          .then((tags) => {
            if (tags.includes('syncTest')) {
              console.log('There is already a sync pending');
            }
          }).catch((err) => {
            console.log('Error ', err);
          });
      });
    }

    document.querySelector('#register').addEventListener('click', (e) => {
      e.preventDefault();
      Notification.requestPermission().then((status) => {
        switch (status) {
          case 'denied':
            throw new Error('Permession denied');
          case 'granted':
            return navigator.serviceWorker.ready;
          default:
            throw new Error('Permession default');
        }
      }).then((reg)=>{
        return reg.sync.register('syncTest');
      }).then(()=>{
        console.log('Background sync registered');
      }).catch((err)=>{
        console.log(err);
      });
    });
  });
})();
