(function() {

    //**************************************************************
    //
    // Helper function to get the position coordinates
    //
    //**************************************************************

    function location(config) {
        if (arguments.length !== 1 || typeof config !== 'object') {
            throw new Error('Function not call correctily');
        }
        var success = config.success || function(pos) {},
            error = config.error || function(err) {
                var mesg = [];
                switch (err.code) {
                    case 'PERMISSION_DENIED':
                        mesg.push('Permission denied');
                        break;
                    case 'POSITION_UNAVAILABLE':
                        mesg.push('Location not avaliable');
                        break;
                    case 'TIMEOUT':
                        mesg.push('Server TIMEOUT');
                        break;
                    default:
                        mesg.push('Error on get position');
                        break;
                }
                mesg.push(err.mesg);
                console.lof(mesg.join(" "));
            },
            options = config.options || null,
            data = config.data || {};

        _success = function(pos) {
            success.call(this, pos, data);
        };

        return navigator.geolocation.getCurrentPosition(_success, error, options);
    }

    //**************************************************************
    //
    // Prepare the Ajax object  passed to the $.ajax jQuery fucntion
    //
    //**************************************************************

    var $ajax = {
        url: 'http://api.wunderground.com/api/eefc83bde158ccb1/forecast10day/lang:IT/q/',
        //url: 'forecast10.xml',
        type: 'GET',
        dataType: 'xml',
        success: function success(response) {
            var $txtForecasts = $(response).find('txt_forecast forecastdays forecastday'),
                $simpleForecast = $(response).find('simpleforecast forecastdays forecastday');

            var $placeholder = $('#placeHolder');


            // Begin Forecast container
            var html = ['<div id="forecast" class="row">'];

            for (var i = 0; i < 10; i++) {
                //Begin column forecast
                html.push('<div class="col-xs-12 col-md-4 col-sm-6">');

                //Begin panel forecast
                html.push('<div class="panel panel-primary">');
                //Begin panel heading
                html.push('<div class="panel-heading">');

                var $date = $simpleForecast.eq(i).find('date');
                var city = $date.find('tz_long').text().split('/')[1];

                html.push('<h3>' + city + '</h3>');
                //End panel heading
                html.push('</div>');
                //Begin panel body
                html.push('<div class="panel-body">');

                var p = $date.find('weekday').text() + " " + $date.find('day').text() + " " + $date.find('monthname').text();

                html.push('<p class="lead">' + p + '</p>');
                html.push('<div class="row"><div class="col-xs-3 col-sm-3">');

                var img = '<img class="img-responsive" src="' + $simpleForecast.eq(i).find('icon_url').text() +
                    '" alt="' + $simpleForecast.eq(i).find('icon').text() + '" />';

                html.push(img);
                html.push('</div>');

                html.push('<div class=" col-xs-9 col-sm-5">');
                var max = parseInt($simpleForecast.eq(i).find('high celsius').text());
                var min = parseInt($simpleForecast.eq(i).find('low celsius').text());
                var avg = Math.floor((max + min) / 2);

                html.push('<p class="lead text-center lead-add">' + avg + '&#8451</p>');
                html.push('</div>');

                html.push('<div class="col-xs-12 col-sm-4 divisor">');
                html.push('<p>min. ' + min + '&#8451</p>');
                html.push('<p>max. ' + max + '&#8451</p>');
                html.push('</div>');

                html.push('</div>');

                //Begin button collapse
                html.push('<button class="btn btn-default" type="button" data-toggle="collapse" data-target="#info-' + i + '" aria-expanded="false" aria-controls="info">Info</button>');

                //Begin list group
                html.push('<div class="collapse floating" id="info-' + i + '"><div class="well">');
                var description = $txtForecasts.eq(i).find('fcttext_metric').text();

                html.push('<p>' + description + '</p>');
                //End Collapse well + panel body + panel + column forecast
                html.push('</div></div></div></div></div>');
            }

            //End Foracast container
            html.push('</div>');

            $placeholder.removeClass('active');
            $placeholder.before(html.join(""));
            $('section #position').remove();

        },
        error: function error(xhr, status, errThrown) {
            console.log("Error in Server call");
            console.log("Error: " + errThrown);
            console.log("Status: " + status);
            console.dir(xhr);
        }
    }

    jQuery(document).ready(function($) {

        $('section #position').on('click', function(e) {
            $('#placeHolder').addClass('active');
            if (!($('footer').hasClass('active'))) {
                $('footer').addClass('active');
            }
            if($('#location-error').length !== 0){
            	$('#location-error').remove();
            }
            location({
                data: $ajax,
                success: function succ(position, data) {
                    
                    var query = [];
                    query.push(position.coords.latitude);
                    query.push(position.coords.longitude);
                    data.url += query.join(",");
                    data.url += '.xml';
                    $.ajax(data);
                    
                },
                error: function(err) {
                    var mesg = [];
                    switch (err.code) {
                        case 'PERMISSION_DENIED':
                            mesg.push('Permission denied');
                            break;
                        case 'POSITION_UNAVAILABLE':
                            mesg.push('Location not avaliable');
                            break;
                        case 'TIMEOUT':
                            mesg.push('Server TIMEOUT');
                            break;
                        default:
                            mesg.push('Error on get position');
                            break;
                    }
                    mesg.push(err.mesg);
                    var $placeholder = $('#placeHolder');
                    $placeholder.before('<div id="location-error" class="alert alert-danger"><p>'+mesg+'</p></div>');
                	$placeholder.removeClass('active');
                },
                options: {
                    enableHighAccuracy: false,
                    maximunAge: 30000,
                    timeout: 27000
                }
            });
       
        });
    });
}());
