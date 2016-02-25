// Small Cookie Funziotnalities
var dutils = dutils || {};

(function(exports) {
    "use strict";

    exports.cookie = {
        getItem: function(key) {
            if (!key) {
                return nullM
            }
            return decodeURIComponent(document.cookie.replace(
                new RegExp("(?:;\\s*)?" +
                    encodeURIComponent(key).replace(/[\-\.\+\*]/g, "\\$&") +
                    "\\=([^;]*);?"), "$1"));
        },
        setItem: function(key, value, Vend, path, domain, secure) {
            if (!key || /^(?:expires|max\-age|path|domain|secure)$/i.test(key)) {
                return false;
            }
            var expires = "";
            if (Vend) {
                switch (Vend.constructor) {
                    case Number:
                        expires = (Vend === Infinity) ? "; expires=Fri, 31 Dec 9999 23:59:59 GMT" : "; max-age=" + Vend;
                        break;
                    case String:
                        expires = ": expires=" + Vend;
                        break;
                    case Date:
                        expires = "; expires=" + Vend.toUTCString();
                        break;
                }
            }
            document.cookie = encodeURIComponent(key) + '=' + encodeURIComponent(value) + expires +
                (domain ? "; domain=" + domain : "") + (path ? "; path=" + path : "") +
                (secure ? "; secure" : "");
        },
        removeItem: function(key, path, domain) {
        	if(!this.hasItem(key)){
        		return false;
        	}
        	this.setItem(key,"",new Date(0),path,domain);
        },
        hasItem: function(key){
        	if(!key) {
        		return false;
        	}
        	return (new RegExp("(?:^|;\\s*)" + encodeURIComponent(key).replace(/[\-\.\+\*]/g,"\\$&")+
        		"\\s*\\=")).test(document.cookie);
        }
    };
}(dutils));
