import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/map';

import { IOffer } from './offer';

@Injectable()
export class OfferService {
  private _jsonurl = './src/assets/json/offers.json';

  constructor(private _http: Http) { }

  getOffers(): Observable<IOffer[]> {
    return this._http.get(this._jsonurl)
      .map((resp: Response) => <IOffer[]>resp.json())
      .do((data) => {
        console.log('Offer : ', data);
      })
      .catch((error) => {
        console.error(error);
        return Observable.throw(error.json().error || 'Internal Server Error');
      });
  }
}
