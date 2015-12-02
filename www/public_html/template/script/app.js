(function(){
  var app = angular.module('gemStore', []);

  app.controller('StoreController', function(){
    this.products = gems;
  });
  var gems = [
    {
      name: 'Dodecahedron',
      price: 112.95,
      description: 'Something Special',
      canPurchase: false,
      soldOut: false,
      images:[
        'ddmLogo.svg',
        'ddmLogo.svg'
      ]
    },
    {
      name: 'Azurite',
      price: 32,
      description: 'Something Special',
      canPurchase: true,
      soldOut: false,
      images:[
        'ddmLogo.svg',
        'ddmLogo.svg'
      ]
    },
    {
      name: 'Zircon',
      price: 1233,
      description: 'Something Special',
      canPurchase: false,
      soldOut: false,
      images:[
        'ddmLogo.svg',
        'ddmLogo.svg'
      ]
    }
  ];
}());
