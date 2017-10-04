import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { DataProvider } from '../../providers/data/data';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {
  posts: any = [];

  delete(key:string){
    this._data.rmPost(key);
  }
  
  constructor(public navCtrl: NavController,public _data: DataProvider) {
    this._data.Posts.subscribe((posts)=>{
      this.posts = [];
      posts.forEach((post)=>{
        this.posts.push({
          key: post.key,
          data: post.payload.val()
        });
      });

    });
  }

}
