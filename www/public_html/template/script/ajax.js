// Ajax Example
(function() {
    window.onload = function() {
        document.getElementById("helloButton").addEventListener("click", sendRequest, false);
    };

    function createXHR() {
        try {
            return new XMLHttpRequest(); } catch (e) {
            console.log(e);
        }
        try {
            return new ActiveXObject("Msxml2.XMLHTTP.6.0"); } catch (e) {
            console.log(e);
        }
        try {
            return new ActiveXObject("Msxml2.XMLHTTP.3.0"); } catch (e) {
            console.log(e);
        }
        try {
            return new ActiveXObject("Msxml2.XMLHTTP"); } catch (e) {
            console.log(e);
        }
        try {
            return new ActiveXObject("Microsoft.XMLHTTP"); } catch (e) {
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
