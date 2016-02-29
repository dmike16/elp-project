(function(exports){
	"use strict";

	exports.b64Encoding = function(str){
		return btoa(encodeURIComponent(str).replace(/%([0-9A-F]){2}/,function(match,p1){
			return String.fromCharCode('0x' +p1);
		}));
	};
}(dutils));