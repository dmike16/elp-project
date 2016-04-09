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
// Ajaxk old Style 
(function() {
    "use strict";

    function sendRequest(url, payload, method, target, status, timeout) {
        target.innerHTML = '&nbsp';
        if (status.show) {
            var statusImage = document.createElement('img');
            statusImage.id = 'progressBar';
            statusImage.border = status.border;
            statusImage.src = 'progress.gif';
        }
        var timer;

        switch (method) {
            case 'image':
                var request = new Image();
                request.onerror = function() {
                    cancelRequest(target, 'Server Error', request, timer);
                };
                request.onload = function() {
                    handleResponse(target, timer);
                };
                request.src = url + '?rating=' + payload['rating'] + '&transport=' + payload['transport'] +
                '&timestamp='+payload['timestamp'] + '&response='+payload['response'];
                timer = setTimeout(function() {
                    cancelRequest(target, "Network timeout", request, timer);
                }, 1000 * timeout);
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
                for (var key in payload) {
                    document.cookie = key + '=' + payload[key] + ' ; path=/';
                }
                window.location = url;
                break;
            default:
                window.location = url + '?rating=' + payload['rating'] + '&transport=' + payload['transport'];
        }

    }

    function cancelRequest(target, message, request, timer) {
        if (timer) {
            clearTimeout(timer);
        }
        request.onload = null;
        target.innerHTML = message;
    }

    function handleResponse(target, timer) {
        if (timer) {
            clearTimeout(timer);
        }

        var results = (function readCookie(name) {
            var nameEQ = name + '=';
            var ca = document.cookie.split(';');
            for (var i = 0, len = ca.length; i < len; i++) {
                var c = ca[i];
                while (c.charAt(0) === '') {
                    c = c.substring(1, c.length);
                }
                if (c.indexOf(nameEQ) === 0) {
                    return c.substring(nameEQ.length, c.length);
                }
            }
        }("PollResults"));

        var rating = 0,
            avg = 0,
            total = 0;

        var rs = results.split('a');
        if(rs.length === 3){
            rating = rs[0];
            avg = rs[1];
            total = rs[2];
        }
        target.setAttribute("style","display:block;");
        target.innerHTML = target.innerHTML = "Thank you for voting.  You rated this a <strong>" + rating + "</strong>.  There are <strong>" + total + "</strong> total votes.  The average is <strong>" +
            avg + 
            "</strong>.  You can see the ratings in the <a href='rating.txt' target='_blank'>ratings file</a>.";
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

    function rate(rating, method, response) {
        var transport = method;
        var url = "setrating.php";
        var timeStamp = (new Date()).getTime();
        var status = true;
        var timeout = 5000;
        var payload = {
            'rating': encodeURIComponent(rating),
            'transport': encodeURIComponent(transport),
            'timestamp': encodeURIComponent(timeStamp),
            'response' : encodeURIComponent(response)
        };
        var target = document.querySelector('#result');
        sendRequest(url, payload, method,target,status,timeout);
    }

    var input = document.querySelectorAll('input[name=rating]');
    for (var i = 0, len = input.length; i < len; i++) {
        input[i].addEventListener('click', function() {
            rate(this.value, 'image','cookie');
        }, false);
    }
}());

//Ajax two-way comunication old style
(function() {
    function sendRequest(url, payload, target, timeout) {
        var request = new Image();
        var timer;

        request.onerror = function() {
            cancelRequest(target, "Server Error", request, timer);
        };
        request.onload = function() {
            handleResponse(target, request, timer);
        };
        request.src = url + '?' + payload;
        networkTimeout = function() {
            cancelRequest(target, "Server timeout", request, timer);
        };
        timer = setTimeout(networkTimeout, timeout * 1000);
    }

    function cancelRequest(target, message, request, timer) {
        if (timer) {
            clearTimeout(timer);
        }
        request.onload = null;
        target.innerHTML = message;
    }

    function handleResponse(target, newImage, timer) {
        if (timer) {
            clearTimeout(timer);
        }
        target.innerHTML = 'Here is your custom image <br/>';
        target.appendChild(newImage);
    }

    function getImage(username) {
        var url = 'imagegenerator.php';
        var timeStamp = (new Date()).getTime();
        var timeout = 5;
        var payload = 'username=' + encodeURIComponent(username);
        payload += "&timestamp=" + encodeURIComponent(timeStamp);

        var target = document.querySelector('#result');
        target.innerHTML = '&nbsp';
        target.style.display = "block";


        var status = document.createElement('img');
        status.id = 'progressBar';
        status.width = "80";
        status.height = "80";
        status.src = 'progress.gif';
        target.appendChild(status);

        sendRequest(url, payload, target, timeout);
        return false;

    }
    document.imageForm.onsubmit = function() {
        return getImage(this.username.value);
    };
}());
