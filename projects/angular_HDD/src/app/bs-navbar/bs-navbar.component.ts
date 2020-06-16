import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { AngularFireAuth } from 'angularfire2/auth';
import * as firebase from 'firebase';

@Component({
  selector: 'bs-navbar',
  templateUrl: './bs-navbar.component.html',
  styleUrls: ['./bs-navbar.component.css']
})
export class BsNavbarComponent implements OnInit {
  user: firebase.User;
  loggedInUser: string;

  constructor(private afAuth: AngularFireAuth,
    private router: Router) { 
    afAuth.authState.subscribe(user => this.user = user);
  }

  ngOnInit(): void {
    this.loggedInUser = window.localStorage.getItem("loggedinUser");
  }

  logout(){
    this.router.navigate(['']);
  }

}
