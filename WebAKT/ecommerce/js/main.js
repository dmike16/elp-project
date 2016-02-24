// Implementin and server asyncr call with jQuery
(function() {
    "use strict";
    var lib = new localStorageDB("library",localStorage);

    lib.drop();
    if(lib.isNew()){
    	lib.createTable("cart",["sku","titolo","prezzo","sconto","qt"]);

    	lib.commit();
    }
    
    
    jQuery(document).ready(function($) {

        var magazzino = "magazzino.xml";
        $.ajax({
            type: "GET",
            url: magazzino,
            dataType: "xml",
            success: function(xml) {
                var i = 0;
                $(xml).find("prodotto").each(function() {

                    // Data fetch from the server
                    var $xml = $(this);
                    var sku = $xml.attr("sku");
                    var $descr = $xml.find("descrizione");
                    var descr = $descr.text();
                    var nome = $descr.attr("nome");
                    var imageSrc = $xml.find("imagine").text();
                    var $prezzo = $xml.find("prezzo");
                    var prezzo = parseFloat($prezzo.text());
                    var sconto = parseInt($prezzo.attr('sconto'));

                    //New Html Element
                    var html = ['<div class="col-xs-12 col-sm-6 col-md-4">',
                        '<section id="sku-'+sku+'" class="item" itemscope itemtype="http://schema.org/Product">',
                        '<div class="image center" itemprop="image">',
                        '<img src="' + imageSrc + '" alt="Chitarra Classica"/>',
                        '</div>',
                        '<h2 itemprop="name">' + nome + '</h2>',
                        '<p itemprop="description">' + descr + '</p>',
                        '<p itemprop="offer" itemscope itemtype="http://schema.org/Offer">Prezzo <span itemprop="price" class="strike">' + prezzo,
                        '</span><span itemprop="priceCurrency" content="EUR">€</span> - ' + sconto + '% : <strong>' + (prezzo - (prezzo * sconto / 100)) + '€</strong></p>',
                        '<label for="qty-1">',
                        '<input itemprop="weight" id="qty-1" name="quantita" type="text" placeholder="Quatità" pattern="/\d+/"/>',
                        '</label>',
                        '<button class="btn-rb add-to-cart" type="submit">Acquista</button>',
                        '</section></div>'
                    ];
                    i++;
                    if (i!== 0 && i%3 === 0){
                      html.push('<div class="clearfix hidden-sm"></div>');
                    }
                    $("#central-row").append(html.join(" "));
                });
                $('.add-to-cart').on('click', function() {
                	$('html').addClass('modal-open');
                	var id = $(this).parent('.item').attr('id');
                	var $container = $('#'+id);
                   	var srcImage = $container.find('img').attr("src");
                   	var nome = $container.find('h2[itemprop="name"]').text();
                   	var price = $container.find('p[itemprop="offer"] strong').text();
                   	var qty = $container.find('input[itemprop="weight"]').val();
                   	console.log(qty);
                   	var $modal = $('#myModal');
                   	var $modal_header = $modal.find('h4');
                   	$modal_header.text('Carrello');
                   	var $modal_body = $modal.find('.modal-body');
                   	$modal_body.empty();
                   	var html = ['<h4>',nome,'</h4>','<img src="',srcImage,
                   	'" style="width:120px;height:200px"/>',
                   	'<p>Prezzo: ',
                   	price,'</p>'];
                   	$modal_body.append(html.join(""));
                   	$.cookie("sku001",id,{expires: 30, path: '/'});
                   	lib.insertOrUpdate("cart",{sku: id},{
                   		sku: id,
                   		titolo: nome,
                   		sconto: 20,
                   		prezzo: parseFloat(price),
                   		qt: (qty === ' ')? 1: parseInt(qty)
                   	});
                   	lib.commit();
                   	$modal.modal({
                   		backdrop:'static'
                   	});
                });
                $('button[data-dismiss="modal"]').on('click',function(){
                	$('html').removeClass('modal-open');
                });

            },
            error: function() {
                console.error("Somthing when wrong");
            }
        });


    });
}());

// Cokies examples
(function(doc){
	//The cokies are in one document prop of the BOM
	// cookies ora couple of value=anothervalue
	var cookies = {
		set: function setCookie(name,value,expire,ppath,ddomain,secure){
			var cookie = name + '=' + encodeURIComponent(value);

			if(expire){
				cookie += '; expires=' + expire.toUTCString();
			} 
			if (ppath) {
				cookie += '; path='+ppath;
			}
			if(ddomain){
				cookie += '; domain='+ ddomain;
			}
			if(secure){
				cookie += '; secure';
			}
			doc.cookie = cookie;
		},
		get: function getCookie(name){
			var s = "(?:;\\s*)?" + name + "=([^;]*);?";
			var reg = new RegExp(s);

			if(reg.test(doc.cookie)){
				return decodeURIComponent(RegExp.$1);
			}else{
				return null;
			}
		},
		cancel: function cancelCookie(name,pth,dmn){
			console.log(name);
			this.set(name,"",new Date(0),pth,dmn);
		},
		cancelAll: function cancelAll(){
			var cookie = doc.cookie;
			var reg = /(?:;\s*)?(?:[^;][a-z]+)=/g;
			var temp = cookie.match(reg);

			reg.compile("[^;=\\s]+","g");
			temp = temp.join(' ').match(reg);
			for(var i = temp.length -1; i >= 0; i--){
				this.cancel(temp[i]);
			}
		}
	};

	/*
	cookies.set("name","Michele Cipolla");
	cookies.set("message","Hello World",new Date(Date.parse('Jan 1, 2017')));
	console.log(doc.cookie);
	console.log(cookies.get('name'));
	console.log(doc.cookie);
	cookies.cancelAll();
	console.log(doc.cookie);*/
}(document));