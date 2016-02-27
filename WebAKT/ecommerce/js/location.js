(function(exports) {
    var geoloc = null;
    if ("geolocation" in navigator) {
        geoloc = navigator.geolocation;
    } else {
        throw new Error("Your Broswer doesn't support HTML5 geolocation");
    }
    exports.location = function location(config) {
        if (arguments.length > 1) {
            throw new Error("Invalid argument");
        }
        if (typeof arguments[0] === 'Object') {
            var position = [geoloc.getCurrentPosition, geoloc.WatchPosition];
            var use = 0;

            if (config.watchPosition === true) {
                use = 1;
            }
            var options = config.options || null,
                success = config.success || function(pos) {},
                error = config.error || function(error) {
                    switch (error) {
                        case 'PERMISSION_DENIED':
                            console.error("Position not enabled");
                            break;
                        case 'POSITION_UNAVAIBLE':
                            console.error("Acquisition failed");
                            break;
                        case 'TIMEOUT':
                            console.error("Timeout has expired");
                            break;
                        default:
                            break;
                    }
                };
            return position[use](success, error, options);

        } else if (Number.isInteger(arguments[0])) {
            return geoloc.clearWatch(config);
        } else {
            throw new Error("Type not supported");
        }

    };
}(dutils));
