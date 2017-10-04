import { Component } from '@angular/core';
import { IonicPage, NavController } from 'ionic-angular';
import { DataProvider } from '../../providers/data/data';

class Post{
  title: string;
  body:string;
  id:string;

  constructor(){}
}

@IonicPage()
@Component({
  selector: 'page-post',
  templateUrl: 'post.html',
})
export class PostPage {
  post: Post = new Post();

  submit(){
    this._data.addPost({title:this.post.title,body:this.post.body});
    this.post.body = '';
    this.post.title = '';
    this.navCtrl.parent.select(0);
  }

  constructor(public navCtrl: NavController, public _data: DataProvider) {

  }

}
