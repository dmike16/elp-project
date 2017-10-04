import { Component } from '@angular/core';
import { AngularFireDatabase } from 'angularfire2/database';

import '../assets/css/styles.css';

@Component({
  selector: 'my-app',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  pageTitle: string = "Angular2 Firebase";
  canzoni: any[] = [];
  _canzone: string;

  push(): void{
    this.db.list('/Canzoni').push(this.canzone);
  }

  get canzone():string{
    return this._canzone;
  }

  set canzone(value:string){
    this._canzone = value;
  }

  constructor(public db: AngularFireDatabase){
    db.list('/Canzoni').snapshotChanges().subscribe(
      (shaps) =>{
        shaps.forEach((shap)=>{
          this.canzoni.push({
            name : shap.payload.val(),
            key: shap.key
          });
        });

        console.log(this.canzoni);
      }
    );
  }
}
