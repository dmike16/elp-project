import { Injectable } from '@angular/core';
import { AngularFireDatabase } from 'angularfire2/database';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class DataProvider {
  posts: Observable<any[]>;

  get Posts(){
    return this._db.list('/songs').snapshotChanges();
  }

  addPost(post){
    this._db.list('/songs').push(post);
  }

  rmPost(key:string):void{
    this._db.list('/songs').remove(key);
  }

  constructor(private _db: AngularFireDatabase) {
  }

}
