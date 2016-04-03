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
// Ajaxk old Style
(function(){
    function sendRequest(url,payload){
        var img = new Image();
        img.src = url + '?' + payload;
    }

    function rate(rating){
        var transport = "image";
        var url = "setrating.php";
        var payload = 'rating='+encodeURIComponent(rating);
        payload += '&transport='+encodeURIComponent(transport);
        sendRequest(url,payload);
        var result = document.querySelector('#result');
        var ratingForm = document.querySelector('#ratingForm');
        ratingForm.style.display = "none";
        result.textContent = 'Thank for your voting';
        result.style.display = "block";
    }

    var input = document.querySelectorAll('input[name=rating]');
    for(var i = 0,len = input.length; i < len; i++){
        input[i].addEventListener('click',function(){
            rate(this.value);
        },false);
    }
}());