import { Component, OnInit } from '@angular/core';
import { IProduct } from './product';
import { ProductService } from './product.service';


@Component({
  selector: 'app-pm-products',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})

export class ProductListComponent implements OnInit {
  pageTitle: string = 'Lista Prodotti';
  showImage: boolean = false;
  btnText: string = 'Mostra Immagine';
  imageWidth: number = 50;
  imageMargin: number = 0;
  _listFilter: string = '';
  products: IProduct[];
  errorMessage: any;
  //Array of filteres Products
  filteredProducts: IProduct[] = [];
  //Constructor
  constructor(private _productService: ProductService) {
    //If we put a provider as a dep in the Constructor then angular inject it as
    // a singleton
  }

  get listFilter(): string {
    return this._listFilter;
  }

  set listFilter(value: string) {
    this._listFilter = value;
    this.filteredProducts = this._listFilter ? this.performFilter(this._listFilter) :
      this.products;
  }

  performFilter(filterBy: string): IProduct[] {
    filterBy = filterBy.toLocaleLowerCase();
    return this.products.filter((prod: IProduct) => {
      return prod.productName.toLocaleLowerCase().indexOf(filterBy) >= 0;
    });
  }

  toggleImage(): void {
    this.showImage = !this.showImage;
    if (this.showImage) {
      this.btnText = 'Nascondi Immagine';
    } else {
      this.btnText = 'Mostra Immagine';
    }
  }

  ngOnInit(): void {
    this._productService.getProducts()
      .subscribe((products) => this.filteredProducts = this.products = products,
      (error) => this.errorMessage = <any>error);

  }

  onRatingClicked(message: string): void {
    console.log('%c' + message, 'color: #0147A7;');
  }
}
