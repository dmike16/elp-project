import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/map';

import { IProduct } from './product';

@Injectable()
export class ProductService {
  private _productUrl = './src/assets/json/products.json';

  constructor(private _http: Http) {
    //Inject by Angular
  }

  private handleError(error: Response){
    console.error(error);
    return Observable.throw(error.json().error || 'Internal Server Error');
  }

  getProducts(): Observable<IProduct[]> {
    return this._http.get(this._productUrl)
      .map((response: Response) => {
        return <IProduct[]>response.json();
      })
      .do((data)=>{
        console.log('Products: ',JSON.stringify(data));
      })
      .catch(this.handleError);
  }
}
