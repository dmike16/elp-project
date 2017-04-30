self.addEventListener('message', (e) => {
  let data = e.data;
  switch (data.cmd) {
    case 'start':
      self.postMessage('WORKER STARTED ' + data.msg);
      break;
    case 'stop':
      self.postMessage('WORKER STOPPED ' + data.msg);
      break;
    default:
      self.postMessage('Unkown Message ' + data.msg);
      break;
  }
});
