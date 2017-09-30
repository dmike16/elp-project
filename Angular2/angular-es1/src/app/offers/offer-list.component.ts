import { Component,OnInit } from '@angular/core';

import { OfferService } from './offer.service';
import { IOffer } from './offer';

@Component({
  selector: 'offer-list',
  templateUrl: './offer-list.component.html',
  styleUrls: ['./offer-list.component.css']
})
export class OfferListComponent implements OnInit{
  offers: IOffer[];
  errorMessage: any;
  modalClass: string = "modal";

  constructor(private _offerService: OfferService){}

  onClick():void{
    this.modalClass = "modal-offer modal";
  }

  ngOnInit():void{
    this._offerService.getOffers().subscribe((results)=>{
      this.offers = results;
    },(error)=>{
      this.errorMessage = error;
    })
  }
}
