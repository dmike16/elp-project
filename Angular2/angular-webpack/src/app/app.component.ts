import { Component } from '@angular/core';
import { ProductService } from './products/product.service';

import '../assets/css/styles.css';

@Component({
  selector: 'my-app',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [ProductService]
})
export class AppComponent {
  pageTitle: string = "Angular2 Webpack";
}
