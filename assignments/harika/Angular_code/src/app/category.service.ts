import { Observable } from 'rxjs';
import { Injectable, Input } from '@angular/core';
import { AngularFireDatabase, AngularFireObject, AngularFireList } from 'angularfire2/database';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  // @Input('category') category: true;
  // private dbPath = '/categories';

  // categories: Observable<any[]>

  constructor(private db: AngularFireDatabase) { }

  // ngOnInit() {
  //   this.getCategories();
  // }

  getCategories() {
    return this.db.list('/categories');
      // console.log('categories$');
      // this.categories = db.list('categories').valueChanges();
  }

  // getCategories(){
  //    return this.db.list('https://oshop-demo-48d96.firebaseio.com/categories.json');
  //  }

}

