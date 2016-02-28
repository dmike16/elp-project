(function(exports) {
	"use strict";
	
    if (!("geolocation" in navigator)) {
        throw new Error("Your Broswer doesn't support HTML5 geolocation");
    }
    exports.location = function location(config) {
        if (arguments.length > 1) {
            throw new Error("Invalid argument");
        }

        if (typeof arguments[0] === 'object') {

            var use = 0;

            var options = config.options || null,
                success = config.success || function(pos) {},
                error = config.error || function(error) {

                    switch (error) {
                        case 'PERMISSION_DENIED':
                            console.log("Position not enabled");
                            break;
                        case 'POSITION_UNAVAIBLE':
                            console.log("Acquisition failed");
                            break;
                        case 'TIMEOUT':
                            console.log("Timeout has expired");
                            break;
                        default:
                            console.log("Error In get Location");
                            break;
                    }
                };
            if (config.watchPosition === true) {
                return navigator.geolocation.watchPosition(success, error, options);
            }
            return navigator.geolocation.getCurrentPosition(success, error, options);

        } else if (Number.isInteger(arguments[0])) {
            return geoloc.clearWatch(config);
        } else {
            throw new Error("Type not supported");
        }

    };
}(dutils));
