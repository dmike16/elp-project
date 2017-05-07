(function() {
  'use strict';

  const pushButton = document.querySelector('.js-push-btn');
  const publicKey = 'BFx0NFz4MRzR6OgtygJJbMC-i-BMyvKeS57xCDH-' +
    's5C8KAi4NnKzzEORgtXPopOqq3Uyh3G1pr3AH9uCZyTVq9Y';
  let swReg = null;
  let isSubscribed = false;

  function urlB64ToUintArray(url) {
    const padding = '='.repeat((4 - url.length % 4) % 4);
    const base64 = (url + padding).replace(/\-/g, '+').replace(/_/g, '-');

    const rawData = window.atob(base64);
    const out = new Uint8Array(rawData.length);

    for (let i = 0, len = rawData.length; i < len; i++) {
      out[i] = rawData.charCodeAt(i);
    }

    return out;
  }

  function updateBtn() {
    if (Notification.permission === 'denied') {
      pushButton.textContent = 'Push Messaging Blocked.';
      pushButton.disabled = true;
      updateSubscription(null);
      return;
    }

    if (isSubscribed) {
      pushButton.textContent = 'Disable Push Messaging';
    } else {
      pushButton.textContent = 'Enable Push Messaging';
    }

    pushButton.disabled = false;
  }

  function updateSubscription(subscription) {
    const subscriptionJson = document.querySelector('.js-subscription-json');
    const subscriptionDetails =
      document.querySelector('.js-subscription-details');

    if (subscription) {
      subscriptionJson.textContent = JSON.stringify(subscription);
      subscriptionDetails.classList.remove('is-invisible');
    } else {
      subscriptionDetails.classList.add('is-invisible');
    }
  }

  function subscribeUser() {
    const key = urlB64ToUintArray(publicKey);
    swReg.pushManager.subscribe({
      userVisibleOnly: true,
      applicationServerKey: key
    }).then((sub) => {
      console.log('User is subscribed');
      updateSubscription(sub);
      isSubscribed = true;
      updateBtn();
    }).catch((err) => {
      console.log('Failed to subscribe ', err);
      updateBtn();
    });
  }

  function unsubscribeUser(){
    console.log('In unsubscribe');
    swReg.pushManager.getSubscription().then((sub)=>{
      if(sub){
        return sub.unsubscribe();
      }
    }).catch((err)=>{
      console.log('Error during unsubsription ',err);
    }).then(()=>{
      updateSubscription(null);
      console.log('User is unsubsribed');
      isSubscribed = false;
      updateBtn();
    });
  }

  function initialiseUI() {
    pushButton.addEventListener('click', (evt) => {
      pushButton.disabled = true;
      if (isSubscribed) {
        unsubscribeUser();
      } else {
        subscribeUser();
      }
    });

    swReg.pushManager.getSubscription().then((ps) => {
      isSubscribed = ps !== null;
      if (isSubscribed) {
        console.log('User subscribed');
      } else {
        console.log('User is not subscribed');
      }
      updateBtn();
    });
  }

  if ('serviceWorker' in navigator && 'PushManager' in window) {
    console.log('Service Worker Suppoterd');
    navigator.serviceWorker.register('sw.js')
      .then((reg) => {
        console.log('Service Worker registered for scope ', reg.scope);
        swReg = reg;
        initialiseUI();
      }).catch((err) => {
        console.log('Registration Failed with error ', err);
      });
  } else {
    console.warn('Push Messaging not supported');
    pushButton.textContent = 'Push Not supported';
  }
})();
