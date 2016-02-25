(function() {
    "use strict";

    function initStoreDB(name) {
        var db = new localStorageDB(name, localStorage);

        if (db.isNew()) {
            db.createTable('instore', ['sku', 'title', 'descr', 'offer', 'image', 'qty']);
//            db.createTable('cart', ['sku', 'title', 'offer', 'qty']);

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

    var cart = {
        cached: {},
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
                        '<div class="close"></div>',
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
                    if (ck[key] != this.cached[key].qty) {
                        var nqty = this.cached[key].qty + parseInt(ck[key]);
                        this.cached[key].qty = nqty;
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
                var $times = $container.find('div[data-sku="'+key+'"] .close');
                $times.text('x'+ck[key]);
            }
            var $close = $container.find('.close');

            for (var k = 0, len = index.length; k < len; k++) {
                $close.eq(index[k]).on('click', this.cached, function(e) {
                    var $div = $(this).closest('div[data-sku]');
                    var key = $div.attr('data-sku');
                    console.log($div);
                    var _row = db.queryAll('instore', {
                        query: {
                            sku: key
                        }
                    });
                    
                    var qty = _row[0].qty + e.data[key].qty; 
                    
                    db.update('instore', dml, function(row) {
                        row.qty = parseInt(qty);
                        
                        return row;
                    });
                    db.commit();

                    delete e.data[key];
                    $.removeCookie(key);

                    var $parent = $div.parent('div');
                    $div.remove();

                    if($parent.children().length === 0){
                        
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

                if (qty == 0) {
                    $modalBody.append("<h4>Qunatià Pari a zero!!! OPS</h4>");
                    $modal.find('.modal-footer button').eq(1).addClass("disabled");
                } else if (qty <= rows.qty) {
                    // Calculate the real Price
                    var realPrice = (rows.offer.price - (rows.offer.price * rows.offer.discount / 100));

                    //Populate the modal body
                    var html = ['<h4>', rows.title, '</h4>', '<img src="', rows.image.src, '" alt="', rows.image.alt, '" ', 'style="width:120px;height:200px"/>', '<p>Prezzo: ', realPrice, '&times;',
                    qty,
                    '</p>'];
                    $modalBody.append(html.join(""));

                    // Active go to cart                    
                    $modal.find('.modal-footer button').eq(1).removeClass('disabled');

                    // Cached product in cookie
                    $.cookie(dml.sku, qty, { expires: 30 });

                    // Update the qty in db
                    db.update('instore', dml, function(row) {
                        row.qty -= parseInt(qty);
                        console.log(row.qty);    
                        return row;
                    });
                    db.commit();
                    // Active the cart Button
                    cart.active($('aside .center #cart'),db);

                    console.log($.cookie());
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
            $('#myModal .modal-footer button').eq(1).on('click', function() {
                $('#myModal').modal('hide');
                cart.open(db);
            });

        }
    );
}());
