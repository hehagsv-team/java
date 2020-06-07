import { ProductService } from './../../product.service';
import { Component, OnInit } from '@angular/core';
import { AngularFireDatabase, AngularFireObject, AngularFireList } from 'angularfire2/database';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-admin-products',
  templateUrl: './admin-products.component.html',
  styleUrls: ['./admin-products.component.css']
})
export class AdminProductsComponent implements OnInit {
  // products$;
  products$: Observable<any[]>;

  constructor(private productService: ProductService, db : AngularFireDatabase) {
    // this.products$ = this.productService.getAll();
    this.products$= this.productService.getAll().valueChanges();
    // this.products = db.list('products').valueChanges();
   }

  ngOnInit() {
  }

}
