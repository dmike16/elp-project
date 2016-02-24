(function() {
    "use strict";

    function initStoreDB(name) {
        var db = new localStorageDB(name, localStorage);

        if (db.isNew()) {
            db.createTable('instore', ['sku', 'title', 'descr', 'offer', 'image', 'qty']);
            db.createTable('cart', ['sku', 'title', 'offer', 'qty']);

            db.commit();
        }

        return db;
    }

    function injectProduct(db, $ele, store, query) {
        if (typeof query === 'undefined' || query == null) {
            var rows = db.queryAll('instore');

            if (store.size == 0 || store.size != rows.length) {
                store.size = rows.length;
                rows.forEach(function(ele, index) {
                    var html = ['<div class="col-xs-12 col-sm-6 col-md-4">',
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
                        '<button class="btn-rb add-to-cart" type="submit">Acquista</button>',
                        '</section></div>'
                    ];
                    if ((index + 1) % 3 === 0) {
                        html.push('<div class="clearfix hidden-sm"></div>');
                    }
                    this.append(html.join(' '));
                }, $ele);
                $ele.find('.add-to-cart').on('click', function(e) {
                    
                    var $pnt = $(this).parent('.item'),
                        $input = $pnt.find('input');

                    var dml = {
                        sku: $pnt.attr('id')
                    };
                    var row = db.queryAll("instore", {
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
                    $bnts.eq(0).text("Close");
                    $bnts.eq(1).text("Go To Cart");

                    $modalBody.empty();

                    if (qty == 0) {
                        $modalBody.append("<h4>Qunatià Pari a zero!!! OPS</h4>");
                        $modal.find('.modal-footer button').eq(1).addClass("disabled");
                    } else if (qty <= row.qty) {
                        var realPrice = (row.offer.price - (row.offer.price * row.offer.discount / 100));
                        var html = ['<h4>', row.title, '</h4>', '<img src="', row.image.src, '" alt="', row.image.alt, '" ', 'style="width:120px;height:200px"/>', '<p>Prezzo: ', realPrice, '</p>'];
                        $modalBody.append(html.join(""));
                        $modal.find('.modal-footer button').eq(1).removeClass('disabled');
                        
                    } else {
                        $modalBody.append("<h4>Qunatià non Disponibile</h4>");
                        $modal.find('.modal-footer button').eq(1).addClass("disabled");
                    }

                    $modal.modal({
                        backdrop: 'static'
                    });
                    
                    $('html').addClass('modal-open');

                });
            }
        }
    }

    jQuery(document).ready(
        function($) {
            // Create a dataBase local with two tables
            var db = initStoreDB('store');

            // Ajax Request
            var store = {
                location: 'magazzino.xml',
                size: 0,
            };

            $.ajax({
                trype: 'GET',
                dataType: 'xml',
                url: store.location,
                success: function onSuccess(response) {
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
                        injectProduct(db,
                            $("#central-row"),
                            store);
                        //Clear Unsufull variable
                        $img = null;
                        $descr = null;
                        $prc = null;
                        $prod = null;
                    });

                },
                error: function onError(response, status, err) {
                    console.log("Error occurred while Ajax Request");
                    console.log("Specific Error : " + err);
                    console.log("Status : " + status);
                    console.dir(response);
                }
            });

            $('#myModal .modal-footer button').eq(0).on('click', function() {
                $('html').removeClass('modal-open');
                $('#myModal').modal('hide');
            });
            
        }
    );
}());
