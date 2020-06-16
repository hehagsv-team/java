import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, CanActivate } from '@angular/router';

@Component({
  // tslint:disable-next-line: component-selector
  selector: 'bs-navbar',
  templateUrl: './bs-navbar.component.html',
  styleUrls: ['./bs-navbar.component.css']
})
export class BsNavbarComponent implements CanActivate {

  constructor(private router: Router, private  route: ActivatedRoute
    ) { }

  canActivate(){
    return true;

  }


}
