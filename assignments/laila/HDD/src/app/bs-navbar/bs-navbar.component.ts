import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  // tslint:disable-next-line: component-selector
  selector: 'bs-navbar',
  templateUrl: './bs-navbar.component.html',
  styleUrls: ['./bs-navbar.component.css']
})
export class BsNavbarComponent implements OnInit {

  constructor(private router: Router, private  route: ActivatedRoute
    ) { }

  ngOnInit(): void {

  }
  // deviceUsers(){
  //   this.router.navigate(['device-list']);
  // }
  // deviceUsers(e) {

  //   if (){
  //     this.router.navigate(['device-list']);
  //   }

  //   else
  //   {
  //     this.router.navigate(['home']);
  //   }

  // }

}
