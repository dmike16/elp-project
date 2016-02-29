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
