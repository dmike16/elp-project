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
;(function(exports) {
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
;(function() {
    "use strict";

    function initStoreDB(name) {
        var db = new localStorageDB(name, localStorage);

        if (db.isNew()) {
            db.createTable('instore', ['sku', 'title', 'descr', 'offer', 'image', 'qty']);
            db.createTable('users', ['name', 'last_name', 'passwd', 'email', 'code', 'date', 'address']);
            db.insert('users', {
                name: 'Michele',
                last_name: 'Cipolla',
                passwd: 'return',
                email: 'cipmiky@gmail.com',
                code: 'xxxx',
                date: 'xxxx',
                address: 'xxxx'
            });
            db.commit();
        }

        return db;
    }

    function injectProduct(db, db_name, $ele, html, query) {
        // Chech if the appendTo element it's defined
        if (typeof $ele === 'undefined' || $ele === null) {
            $ele = $("#central-row");
        }
        var rows;
        /// Check if a query object it's passed
        if (query === null) {
            rows = db.queryAll(db_name);
        } else if ($.isArray(query)) {
            rows = query;
        } else {
            rows = db.queryAll(db_name, query);
        }

        if (rows.length !== 0) {
            if (typeof html === 'function') {
                rows.forEach(html, $ele || undefined);
            } else {
                console.log("Query Null");
                return;
            }

        }
    }

    function signIn(db, user_name, passwd) {
        var rows = db.queryAll('users', {
            query: {
                email: user_name,
                passwd: passwd
            }
        });

        if (rows.length === 1) {
            return true;
        }

        return false;
    }

    var cart = {
        cached: {},
        deactive: function deactive($btn) {
            $btn.toggleClass('disabled z1');
        },
        active: function activeCart($btn, db) {
            if ($btn.hasClass('disabled')) {
                var ck = $.cookie();
                for (var key in ck) {

                    if (/^sku-\d+$/.test(key)) {
                        $btn.on('click', function() {
                            cart.open(db);
                        });
                        $btn.toggleClass('disabled z1');
                        return;
                    }
                }
            }
            return;
        },
        open: function openCart(db) {
            var $modal = $('#cartModal');

            var $container = $modal.find('#cart-ele'),
                html = function html(ele) {
                    var _html = [
                        '<div class="flex-010 layout inline relative" data-sku="',
                        ele.sku,
                        '" style="width:100%;">',
                        '<div class="close" role="button" style="font-family:inherit;">&times;</div>', , '<div class="badge" style="bottom:0;right:0;position:absolute;"></div>',
                        '<h3>',
                        ele.title,
                        '</h3>',
                        '<img src="',
                        ele.image.src,
                        '" alt="',
                        ele.image.alt,
                        '" style="width:120px;height:200px"/>',
                        '</div>'
                    ];

                    this.append(_html.join(""));
                };

            var ck = $.cookie();

            var i = 0,
                index = [];

            for (var key in ck) {
                if (!(/^sku-\d+$/.test(key))) {
                    continue;
                } else if (typeof this.cached[key] !== 'undefined') {
                    var oqty = parseInt(ck[key]);
                    if (oqty !== this.cached[key].qty) {
                        this.cached[key].qty = oqty;
                        var $times = $container.find('div[data-sku="' + key + '"] .badge');
                        $times.text(oqty);
                    }
                    i++;
                    continue;
                }
                var dml = {
                    sku: key
                };
                var row = db.queryAll('instore', {
                    query: dml
                });

                this.cached[key] = {
                    qty: parseInt(ck[key]),
                    price: (row[0].offer.price - row[0].offer.price * row[0].offer.discount / 100)
                };
                injectProduct(db, 'instore', $container, html, row);
                index.push(i++);
                var $times = $container.find('div[data-sku="' + key + '"] .badge');
                $times.text(ck[key]);
            }
            var $close = $container.find('.close');

            for (var k = 0, len = index.length; k < len; k++) {
                $close.eq(index[k]).on('click', this.cached, function(e) {
                    var $div = $(this).closest('div[data-sku]');
                    var key = $div.attr('data-sku');

                    var _row = db.queryAll('instore', {
                        query: {
                            sku: key
                        }
                    });

                    var qty = e.data[key].qty;

                    db.update('instore', dml, function(row) {
                        row.qty += qty;

                        return row;
                    });
                    db.commit();

                    e.data[key] = null;
                    delete e.data[key];
                    $.removeCookie(key);

                    var $parent = $div.parent('div');
                    $div.remove();

                    if ($parent.children().length === 0) {
                        cart.deactive($('aside .center #cart'));
                    }


                });
            }
            $modal.modal({
                backdrop: 'static'
            });
            i++;
        },
        close: function closeModal($modal) {
            $modal.modal('hide');
        },
        link: function linkButton(db) {
            var $btns = $('.add-to-cart.disabled');

            $btns.on('click', function(e) {

                var $pnt = $(this).parent('.item'),
                    $input = $pnt.find('input');

                var dml = {
                    sku: $pnt.attr('id')
                };
                var rows = db.queryAll("instore", {
                    query: dml
                })[0];

                var qty = $input.val();
                if (!(/^\d+$/.test(qty))) {
                    console.error("Not a number");
                    return;
                }

                var $modal = $('#myModal'),
                    $modalBody = $modal.find('.modal-body');

                $modal.find('h4').text('Oggetto Selezionato');

                var $bnts = $modal.find('.modal-footer button');

                $bnts.eq(1).text("Carrello");

                $modalBody.empty();
                qty = parseInt(qty);
                if (qty === 0) {
                    $modalBody.append("<h4>Qunatià Pari a zero!!! OPS</h4>");
                    $modal.find('.modal-footer button').eq(1).addClass("disabled");
                } else if (qty <= rows.qty) {
                    // Calculate the real Price
                    var realPrice = (rows.offer.price - (rows.offer.price * rows.offer.discount / 100));

                    //Populate the modal body
                    var html = ['<h4>', rows.title, '</h4>', '<img src="', rows.image.src, '" alt="', rows.image.alt, '" ', 'style="width:120px;height:200px"/>', '<p>Prezzo: ', realPrice, '&times;',
                        qty,
                        '</p>'
                    ];
                    $modalBody.append(html.join(""));

                    // Active go to cart                    
                    var $btnc = $modal.find('.modal-footer button').eq(1);
                    if ($btnc.hasClass('disabled')) {
                        $btnc.removeClass('disabled');
                    }

                    // Cached product in cookie
                    //Check if it's already cached
                    var nqty = $.cookie(dml.sku);

                    if (typeof nqty !== 'undefined') {
                        $.cookie(dml.sku, (qty + parseInt(nqty)), { expires: 30 });
                    } else {
                        $.cookie(dml.sku, qty, { expires: 30 });
                    }
                    // Update the qty in db
                    db.update('instore', dml, function(row) {
                        row.qty -= qty;
                        //    console.log(row.qty);
                        return row;
                    });
                    db.commit();
                    // Active the cart Button
                    cart.active($('aside .center #cart'), db);

                    //console.log($.cookie());
                } else {
                    $modalBody.append("<h4>Qunatià non Disponibile</h4>");
                    $modal.find('.modal-footer button').eq(1).addClass("disabled");
                }

                $modal.modal({
                    backdrop: 'static'
                });

                $('html').addClass('modal-open');

            });
            $btns.removeClass('disabled');
            cart.active($('aside .center #cart'), db);
        },
        login: function registration($modal, db) {
            var log = [
                '<section> <h3 class="clickable" style="cursor:pointer;"> Login</h3>',
                '<form name="modal-login" id="modal-login" class="form-horizontal" action="#" method="post">',
                '<div class="form-group">',
                '<label for="mod-user" class="col-sm-4" >User Name</label>',
                '<div class="col-sm-8">',
                '<input id="mod-user" name="mod-user" class="form-control" type="text" required/>',
                '</div></div>',
                '<div class="form-group"><label for="mod-passw" class="col-sm-4">Password</label>',
                '<div class="col-sm-8">',
                '<input id="mod-passw" name="mod-passw" class="form-control" type="password" required/></div></div>',
                '<div class="form-group">',
                '<div class="col-sm-offset-10 col-sm-2">',
                '<button type="submit" class="btn-rb"> login </button></div></form>',
                '</section>'
            ];
            var reg = [
                '<section> <h3 class="clickable" style="cursor:pointer;"> Registrazione</h3>',
                '<form class="form-horizontal" name="modal-reg" id="modal-reg"style="display:none;" action="#" method="post">',
                '<div class="row"><div class="has-feedback col-sm-6"><label for="reg-name" class="sr-only">Nome</label><input id="reg-name" name="reg-name" class="form-control" type="text" required placeholder="Nome"/>',
                '<span class="glyphicon glyphicon-ok form-control-feedback sr-only" aria-hidden="true"></span></div>',
                '<div class="has-feedback col-sm-6"><label for="reg-surname" class="sr-only">Cognome</label><input id="reg-surname" name="reg-surname" class="form-control" type="text" required placeholder="Cognome"/>',
                '<span class="glyphicon glyphicon-ok form-control-feedback sr-only" aria-hidden="true"></span></div></div>',
                '<div class="row"><div class="has-feedback col-sm-6"><label for="reg-email" class="sr-only">Email</label><input id="reg-email" name="reg-email" class="form-control" type="email" required placeholder="Email"/>',
                '<span class="glyphicon glyphicon-ok form-control-feedback sr-only" aria-hidden="true"></span></div>',
                '<div class="has-feedback col-sm-6"><label for="reg-passw" class="sr-only">Password</label><input id="reg-passw" name="reg-passw" class="form-control" type="password" required placeholder="Password"/>',
                '<span class="glyphicon glyphicon-ok form-control-feedback sr-only" aria-hidden="true"></span></div></div>',
                '<div class="row"><div class="col-sm-6"><label for="reg-birth" class="sr-only">Nascita</label><input id="reg-birth" name="reg-birth" class="form-control" type="date" placeholder="Data Nascita"/>',
                '</div>',
                '<div class="has-feedback col-sm-6"><div class="input-group"><label for="reg-ind" class="sr-only">Indirizzo</label><i class="input-group-addon" style="cursor:pointer;"><i class="fa fa-compass"></i></i><input id="reg-ind" name="reg-ind" class="form-control" type="text" placeholder="Indirizzo"/>',
                '</div><span class="glyphicon glyphicon-ok form-control-feedback sr-only" aria-hidden="true"></span></div>',
                '</div><div class="row"><div class="has-feedback col-sm-3"><label for="reg-n" class="sr-only">N</label><input id="reg-n" name="reg-n" class="form-control" type="text" placeholder="Civico"/>',
                '<span class="glyphicon glyphicon-ok form-control-feedback sr-only" aria-hidden="true"></span></div><div class="has-feedback col-sm-3"><label for="reg-c" class="sr-only">Citta</label><input id="reg-c" name="reg-c" class="form-control" type="text" placeholder="Citta"/>',
                '<span class="glyphicon glyphicon-ok form-control-feedback sr-only" aria-hidden="true"></span></div><div class="has-feedback col-sm-3"><label for="reg-pr" class="sr-only">Provincia</label><input id="reg-pr" name="reg-pr" class="form-control" type="text" placeholder="Pr"/>',
                '<span class="glyphicon glyphicon-ok form-control-feedback sr-only" aria-hidden="true"></span></div><div class="has-feedback col-sm-3"><label for="reg-cap" class="sr-only">Cap</label><input id="reg-cap" name="reg-cap" class="form-control" type="text" placeholder="Cap"/>',
                '<span class="glyphicon glyphicon-ok form-control-feedback sr-only" aria-hidden="true"></span></div></div>',
                '<div class="row"><div class="col-sm-offset-6 col-sm-6">',
                '<button type="submit" class="btn-rb"> Invia </button></div>',
                '</form>'
            ];
            var $body = $modal.find('.modal-body');
            $body.empty();
            var html = log.concat(reg);
            $body.html(html.join(" "));
            $body.find('section h3').on('click', function() {
                $(this).parent('section').find('form').toggle('slow');
            });
            $body.find('section #modal-reg button').on('click', function(e) {
                e.preventDefault();

                var $body = $('#myModal .modal-body');
                var $inputs = $body.find('section #modal-reg input');
                var row = {
                    name: $inputs.eq(0).val(),
                    last_name: $inputs.eq(1).val(),
                    email: $inputs.eq(2).val(),
                    passwd: $inputs.eq(3).val(),
                    code: 'xxxx',
                    date: $inputs.eq(4).val(),
                    address: [$inputs.eq(5).val(), $inputs.eq(6).val(), $inputs.eq(7).val(), $inputs.eq(8).val(), $inputs.eq(9).val()].join(",")
                };
                if ((db.queryAll('users', { query: { email: row.email } })).length !== 0) {
                    $body.append('<div class="alert alert-warning">Utente gia registrato. Fai il Login</div>');
                    return;
                }
                $body.find('.alert.alert-warning').remove();
                db.insert('users', row);

            });

            var $inputs = $body.find('section #modal-reg input');
            $inputs.on('focus', function(e) {
                var $span = $(this).parent().find('span');
                if ($span.hasClass('sr-only')) {
                    return;
                }
                $span.addClass('sr-only');
            });
            $inputs.on('blur', function(e) {
                var $span = $(this).parent().find('span');
                if ($span.parent().hasClass('has-success')) {
                    $span.removeClass('sr-only');
                }
                return;
            })
            $inputs.eq(0).on('keyup', function() {
                var $this = $(this);
                var $parent = $(this).parent();

                if ($this.val().length < 3) {
                    if ($parent.hasClass('has-error')) {
                        return;
                    }
                    $parent.addClass('has-error');
                    $parent.removeClass('has-success');
                } else {
                    if ($parent.hasClass('has-success')) {
                        return;
                    }
                    $parent.removeClass('has-error');
                    $parent.addClass('has-success');
                }
            });
            $inputs.eq(1).on('keyup', function() {
                var $this = $(this);
                var $parent = $(this).parent();

                if ($this.val().length < 3) {
                    if ($parent.hasClass('has-error')) {
                        return;
                    }
                    $parent.addClass('has-error');
                    $parent.removeClass('has-success');
                } else {
                    if ($parent.hasClass('has-success')) {
                        return;
                    }
                    $parent.removeClass('has-error');
                    $parent.addClass('has-success');
                }
            });
            $inputs.eq(2).on('keyup', function() {
                var $parent = $(this).parent();

                if (this.validity.typeMismatch) {
                    if ($parent.hasClass('has-error')) {
                        return;
                    }
                    $parent.addClass('has-error');
                    $parent.removeClass('has-success');
                } else {
                    if ($parent.hasClass('has-success')) {
                        return;
                    }
                    $parent.removeClass('has-error');
                    $parent.addClass('has-success');
                }
            });
            $inputs.eq(3).on('keyup', function() {
                var $this = $(this);
                var $parent = $(this).parent();

                if ($this.val().length === 0) {
                    if ($parent.hasClass('has-error')) {
                        return;
                    }
                    $parent.addClass('has-error');
                    $parent.removeClass('has-success');
                } else {
                    if ($parent.hasClass('has-success')) {
                        return;
                    }
                    $parent.removeClass('has-error');
                    $parent.addClass('has-success');
                }
            });
            $inputs.eq(4).on('keyup', function() {
                var $this = $(this);
                var $parent = $(this).parent();

                if ($this.val().length === 0) {
                    if ($parent.hasClass('has-error')) {
                        return;
                    }
                    $parent.addClass('has-error');
                    $parent.removeClass('has-success');
                } else {
                    if ($parent.hasClass('has-success')) {
                        return;
                    }
                    $parent.removeClass('has-error');
                    $parent.addClass('has-success');
                }
            });
            $inputs.eq(5).on('keyup', function() {
                var $this = $(this);
                var $parent = $(this).parent();

                if ($this.val().length === 0) {
                    if ($parent.hasClass('has-error')) {
                        return;
                    }
                    $parent.addClass('has-error');
                    $parent.removeClass('has-success');
                } else {
                    if ($parent.hasClass('has-success')) {
                        return;
                    }
                    $parent.removeClass('has-error');
                    $parent.addClass('has-success');
                }
            });
            $inputs.eq(6).on('keyup', function() {
                var $this = $(this);
                var $parent = $(this).parent();

                if ($this.val().length === 0) {
                    if ($parent.hasClass('has-error')) {
                        return;
                    }
                    $parent.addClass('has-error');
                    $parent.removeClass('has-success');
                } else {
                    if ($parent.hasClass('has-success')) {
                        return;
                    }
                    $parent.removeClass('has-error');
                    $parent.addClass('has-success');
                }
            });
            $inputs.eq(7).on('keyup', function() {
                var $this = $(this);
                var $parent = $(this).parent();

                if ($this.val().length === 0) {
                    if ($parent.hasClass('has-error')) {
                        return;
                    }
                    $parent.addClass('has-error');
                    $parent.removeClass('has-success');
                } else {
                    if ($parent.hasClass('has-success')) {
                        return;
                    }
                    $parent.removeClass('has-error');
                    $parent.addClass('has-success');
                }
            });
            $inputs.eq(8).on('keyup', function() {
                var $this = $(this);
                var $parent = $(this).parent();

                if ($this.val().length === 0) {
                    if ($parent.hasClass('has-error')) {
                        return;
                    }
                    $parent.addClass('has-error');
                    $parent.removeClass('has-success');
                } else {
                    if ($parent.hasClass('has-success')) {
                        return;
                    }
                    $parent.removeClass('has-error');
                    $parent.addClass('has-success');
                }
            });
            $inputs.eq(9).on('keyup', function() {
                var $this = $(this);
                var $parent = $(this).parent();

                if ($this.val().length === 0) {
                    if ($parent.hasClass('has-error')) {
                        return;
                    }
                    $parent.addClass('has-error');
                    $parent.removeClass('has-success');
                } else {
                    if ($parent.hasClass('has-success')) {
                        return;
                    }
                    $parent.removeClass('has-error');
                    $parent.addClass('has-success');
                }
            });

            $body.find('section #modal-reg .input-group i.input-group-addon').on('click', function() {

                dutils.location({
                    success: function(pos) {
                        var geocader = new google.maps.Geocoder();
                        var latlng = new google.maps.LatLng(pos.coords.latitude, pos.coords.longitude);


                        geocader.geocode({
                            'location': latlng
                        }, function(resutl, status) {
                            if (status == google.maps.GeocoderStatus.OK) {
                                if (resutl[0]) {
                                    if (resutl[0].types.indexOf('street_address') > -1) {
                                        console.log(resutl[0].address_components);
                                        var $form = $('#myModal #modal-reg');
                                        for (var i = 0, len = resutl[0].address_components.length; i < len; i++) {
                                            switch (resutl[0].address_components[i].types[0]) {
                                                case 'route':

                                                    $form.find('#reg-ind').val(resutl[0].address_components[i].long_name);
                                                    break;
                                                case 'street_number':
                                                    $form.find('#reg-n').val(resutl[0].address_components[i].long_name);
                                                    break;
                                                case 'locality':
                                                    $form.find('#reg-c').val(resutl[0].address_components[i].long_name);
                                                    break;
                                                case 'administrative_area_level_2':
                                                    $form.find('#reg-pr').val(resutl[0].address_components[i].short_name);
                                                    break;
                                                case 'postal_code':
                                                    $form.find('#reg-cap').val(resutl[0].address_components[i].long_name);
                                                    break;
                                                default:
                                                    break;
                                            }
                                        }
                                    }
                                }
                            } else {
                                console.log(error);
                            }
                        });
                    },
                    options: {
                        enableHighAccuracy: false,
                        maximumAge: 3000,
                        timeout: 27000
                    }
                });
            });

            $modal.modal({
                backdrop: 'static'
            });

        }
    };
    jQuery(document).ready(
        function($) {
            // Create a dataBase local with two tables
            var db = initStoreDB('store');

            // Ajax Request
            var magazzino = 'magazzino';
            $('aside .center #fill-db').on('click', function() {
                //db.drop();
                //return;
                $.ajax({
                    trype: 'GET',
                    dataType: 'xml',
                    url: magazzino,
                    success: function onSuccess(response) {
                        var rows = db.queryAll('instore');

                        var sku = [],
                            i = 0;
                        $(response).find("prodotto").each(function() {
                            var $prod = $(this),
                                $descr = $prod.find('descrizione'),
                                $prc = $prod.find('prezzo'),
                                $img = $prod.find('imagine');

                            var row = {
                                sku: 'sku-' + $prod.attr('sku'),
                                title: $descr.attr('nome'),
                                descr: $descr.text(),
                                offer: {
                                    price: parseFloat($prc.text()),
                                    discount: parseInt($prc.attr('sconto'))
                                },
                                image: {
                                    src: $img.text(),
                                    alt: $img.attr('alt')
                                },
                                qty: parseInt($prod.find('quantita').attr('qty'))
                            };
                            db.insertOrUpdate('instore', { sku: row.sku }, row);
                            db.commit();
                            if (rows.length === 0 || rows[i++].sku !== row.sku) {
                                sku.push(row.sku);
                            }
                            //Clear Unsufull variable
                            $img = null;
                            $descr = null;
                            $prc = null;
                            $prod = null;
                        });
                        console.log(sku);

                        for (var i = 0, len = sku.length; i < len; i++) {

                            injectProduct(db, 'instore',
                                $("#central-row"), html, { query: { sku: sku[i] } });
                        }
                        cart.link(db);
                    },
                    error: function onError(response, status, err) {
                        console.log("Error occurred while Ajax Request");
                        console.log("Specific Error : " + err);
                        console.log("Status : " + status);
                        console.dir(response);
                    }
                });
            });
            var html = function html(ele, index) {
                var _html = ['<div class="col-xs-12 col-sm-6 col-md-4">',
                    '<section id="' + ele.sku + '" class="item" itemscope itemtype="http://schema.org/Product">',
                    '<div class="image center" itemprop="image">',
                    '<img src="' + ele.image.src + '" alt="' + ele.image.alt + '"/>',
                    '</div>',
                    '<h2 itemprop="name">' + ele.title + '</h2>',
                    '<p itemprop="description">' + ele.descr + '</p>',
                    '<p itemprop="offer" itemscope itemtype="http://schema.org/Offer">Prezzo <span itemprop="price" class="strike">' + ele.offer.price,
                    '</span><span itemprop="priceCurrency" content="EUR">€</span> - ' + ele.offer.discount + '% : <strong>' + (ele.offer.price - (ele.offer.price * ele.offer.discount / 100)) + '€</strong></p>',
                    '<label for="qty-"' + ele.sku + '>',
                    '<input itemprop="weight" id="qty-' + ele.sku + '" name="quantita" type="text" placeholder="Quatità"/>',
                    '</label>',
                    '<button class="btn-rb add-to-cart disabled" type="submit">Acquista</button>',
                    '</section></div>'
                ];
                if ((index + 1) % 3 === 0) {
                    _html.push('<div class="clearfix hidden-sm"></div>');
                }
                this.append(_html.join(" "));
            };

            injectProduct(db, 'instore', $("#central-row"), html);
            cart.link(db);

            $('#myModal .modal-footer button').eq(0).on('click', function() {
                $('html').removeClass('modal-open');
                cart.close($('#myModal'));
            });
            $('#cartModal .modal-footer button').eq(0).on('click', function() {
                $('html').removeClass('modal-open');
                cart.close($('#cartModal'));
            });
            $('#cartModal .modal-footer button').eq(1).on('click', function() {
                $('html').addClass('modal-open');
                $('#cartModal').modal('hide');
                if ($.cookie('sigin')) {
                    console.log('Open Summary');
                } else {
                    cart.login($('#myModal'), db);
                }
            });
            $('#myModal .modal-footer button').eq(1).on('click', function() {
                $('#myModal').modal('hide');
                cart.open(db);
            });
            $('form[name="login"] button').on('click', function(e) {
                e.preventDefault();

                var $form = $('form[name="login"]');
                var $inputs = $form.find('input');

                if (signIn(db, $inputs.eq(0).val(), $inputs.eq(1).val())) {
                    $form.css('display', 'none');
                    $('#logOut').css('display', 'block');
                    $.cookie('sigin', 'true');
                }
            });

            $('#logOut').on('click', function() {
                $(this).css('display', 'none');
                $('form[name="login"]').css('display', 'block');
                $.removeCookie('sigin');
            });

            if($.cookie('sigin')){
                $('form[name="login"]').css('display','none');
                $('#logOut').css('display', 'block');
            }
        }
    );
}());
