import { Router, ActivatedRoute } from '@angular/router';
import { ProductService } from './../../product.service';

import { CategoryService } from './../../category.service';
import { Component, OnInit } from '@angular/core';
import { AngularFireDatabase, AngularFireObject, AngularFireList } from 'angularfire2/database';
import { Observable } from 'rxjs';
// import 'rxjs/add/operator/take';
import { take } from "rxjs/operators";

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css']
})
export class ProductFormComponent implements OnInit {
  // categories$;
  
  categories$: Observable<any[]>;
  // product = {};
  product:any = {};
id;

  constructor(
    private router: Router,
    private categoryService: CategoryService,
    private route: ActivatedRoute,
     private productService: ProductService,
      db : AngularFireDatabase) {
    // this.categories$ = categoryService.getCategories();
    this.categories$ = db.list('categories').valueChanges();

    // let id = this.route.snapshot.paramMap.get('id');
    // if(id){
    
    //   this.productService.get(id).valueChanges().pipe(take(1)).subscribe(p => this.product = p);
    //   }   
    // }
    this.id = this.route.snapshot.paramMap.get('id');
if (this.id) {
this.productService.get(this.id).snapshotChanges().pipe(take(1)).subscribe((p) => (this.product = p));
}
}

   save(product) {
     this.productService.create(product);
     this.router.navigate(['/admin/products']);
   }

   ngOnInit() {  
    }


}
