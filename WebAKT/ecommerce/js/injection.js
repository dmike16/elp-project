function loadScript(url, callback) {
    var script = document.createElement("script");
    script.type = "text/javascript";

    if (script.readyState) {
        script.onreadyStatechange = function() {
            if (script.readyState === "loaded" || script.readyState === "complete") {
                script.onreadyStatechange = null;
                callback();
            }
        };
    } else {
        script.onload = function() {
            callback();
        }
    }

    script.src = url;
    document.getElementsByTagName('head')[0].appendChild(script);
}

function corsScriptRequest(methdod, url) {
    var xhr = new XMLHttpRequest();
    if ('withCredentials' in xhr) {
        xhr.open(methdod, url, true);
    } else if (typeof XDomainRequest !== 'undefined') {
        xhr = new XDomainRequest();
        xhr.open(method, url);
    } else {
        xhr = null;
        throw new Error('No XMLHttpRequest support');
    }
    xhr.onreadyStatechange = function() {
        if (xhr.readyState === 4) {
            if (xhr.status >= 200 && xhr.status < 300 || xhr.status === 304) {
                var script = document.createElement('script');
                script.type = 'text/javascript';
                script.text = xhr.responseText;
                document.body.appendChild(script);
            }
        }
    };
    xhr.onerror = function() {
        console.log('Error in the request');
    }

    xhr.send();
}
