// Ajax Example
(function() {
    window.onload = function() {
        document.getElementById("helloButton").addEventListener("click", sendRequest, false);
    };

    function createXHR() {
        try {
            return new XMLHttpRequest();
        } catch (e) {
            console.log(e);
        }
        try {
            return new ActiveXObject("Msxml2.XMLHTTP.6.0");
        } catch (e) {
            console.log(e);
        }
        try {
            return new ActiveXObject("Msxml2.XMLHTTP.3.0");
        } catch (e) {
            console.log(e);
        }
        try {
            return new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            console.log(e);
        }
        try {
            return new ActiveXObject("Microsoft.XMLHTTP");
        } catch (e) {
            console.log(e);
        }
        return null;
    }

    function sendRequest() {
        var xhr = createXHR();

        if (xhr) {
            xhr.open("GET", "ajax.php", true);
            xhr.onreadystatechange = function() {
                handlerResponse(xhr);
            };
            xhr.send(null);
        }
    }

    function handlerResponse(response) {
        if (response.readyState === 4 && response.status === 200) {
            var xml = response.responseXML;
            var msg = xml.querySelector("message").textContent;
            document.querySelector("#response").textContent = msg;
        }
    }
}());
// Ajaxk old Style one way comunication
(function() {
    function sendRequest(url, payload, method) {
        switch (method) {
            case 'image':
                var img = new Image();
                img.src = url + '?rating=' + payload['rating'] + '&transport=' + payload['transport'];
                break;
            case 'iframe':
                var ifr = document.createElement('iframe');
                ifr.style.visibility = 'hidden';
                document.body.appendChild(ifr);
                ifr.src = url + '?rating=' + payload['rating'] + '&transport=' + payload['transport'];
                break;
            case 'script':
                var script = document.createElement('script');
                script.src = url + '?rating=' + payload['rating'] + '&transport=' + payload['transport'];
                script.type = 'text/javascript';
                document.body.appendChild(script);
                break;
            case 'link':
                var link = document.createElement('link');
                link.rel = 'stylesheet';
                link.type = 'text/css';
                link.href = url + '?rating=' + payload['rating'] + '&transport=' + payload['transport'];
                document.getElementsByTagName('head')[0].appendChild(link);
                break;
            case 'post':
                var ifrPost = makeIframe();
                var ifrForm = makeIframeForm(ifrPost, url, payload);
                ifrForm.submit();
                break;
                case 'cookie':
                    for(var key in payload){
                        document.cookie = key +'=' + payload[key] +' ; path=/';
                    }
                    window.location = url;
                break;
            default:
                window.location = url + '?rating=' + payload['rating'] + '&transport=' + payload['transport'];
        }

    }

    function makeIframe() {
        var iframe = null;
        if (window.ActiveXObject) {
            iframe = document.createElement('<iframe/>');
        } else {
            iframe = document.createElement('iframe');
        }
        iframe.style.visibility = 'hidden';
        document.body.appendChild(iframe);
        return iframe;
    }

    function makeIframeForm(ifr, url, payload) {
        var ifrDoc = null;
        var ifrWindow = ifr.contentWindow || ifr.contentDocument;
        if (ifrWindow.document) {
            ifrDoc = ifrWindow.document;
        } else {
            ifrDoc = ifrWindow;
        }
        if (!ifrDoc.body) {
            var html = ifrDoc.createElement('html');
            html.appendChild(ifrDoc.createElement('head'));
            html.appendChild(ifrDoc.createElement('body'));
            ifrDoc.appendChild(html);
        }

        var ifrForm = ifrDoc.createElement('form');
        ifrForm.action = url;
        ifrForm.method = 'post';
        ifrDoc.body.appendChild(ifrForm);

        for (var key in payload) {
            var ifrText = ifrDoc.createElement('input');
            ifrText.type = 'text';
            ifrText.name = key;
            ifrText.value = payload[key];
            ifrForm.appendChild(ifrText);
        }

        return ifrForm;

    }

    function rate(rating, method) {
        var transport = method;
        var url = "setrating.php";
        var payload = {
            'rating': encodeURIComponent(rating),
            'transport': encodeURIComponent(transport)
        };
        sendRequest(url, payload, method);
        var result = document.querySelector('#result');
        var ratingForm = document.querySelector('#ratingForm');
        ratingForm.style.display = "none";
        result.textContent = 'Thank for your voting';
        result.style.display = "block";
    }

    var input = document.querySelectorAll('input[name=rating]');
    for (var i = 0, len = input.length; i < len; i++) {
        input[i].addEventListener('click', function() {
            rate(this.value, 'cookie');
        }, false);
    }
}());
