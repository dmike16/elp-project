import { Component } from '@angular/core';
import { OfferService } from './offers/offer.service';

import '../assets/css/styles.css';

@Component({
  selector: 'my-app',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [OfferService]
})
export class AppComponent {
  pageTitle: string = "Angular2 Webpack";
}
