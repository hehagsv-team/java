import { Injectable } from '@angular/core';
import { AngularFireDatabase, AngularFireObject, AngularFireList } from 'angularfire2/database';
import {map} from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class ProductService {
  // productObject: AngularFireObject<ProductService>


  constructor(private db: AngularFireDatabase) { }

  create(product) {
    return this.db.list('/products').push(product);
  }

  getAll() {
    return this.db.list('/products');
  }
  // getAll() {
  //   return this.db.list('/products').snapshotChanges()
  //   .pipe(
  //   map(a => a.map(
  //   ac =>{
  //   const data = ac.payload.val();
  //   const id = ac.payload.key;
  //   console.log(data);
  //   console.log(id)
  //   return {data,id};
    
  //       }
  //     ))
  //   )
  //   }

  get(productId){
    return this.db.object('/products/' +productId);
    }
}

