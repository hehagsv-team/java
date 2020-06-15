import { UserDetailsService } from './../user-details.service';
// import { UserService } from './../user.service';
import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, BehaviorSubject } from 'rxjs';
import { AngularFireDatabase, AngularFireObject, AngularFireList } from 'angularfire2/database';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  users$: Observable<any[]>;

  credentials: any;
  userAndPasswordMismatch: boolean;


  // @Input() credentials: object;

  constructor(
    private router: Router,
    private http: HttpClient,
    private userDetails: UserDetailsService,
    db : AngularFireDatabase) { }

  ngOnInit(): void {
    this.userDetails.fetchFireBaseUsers().subscribe(userDetails => this.credentials = userDetails);;
    this.userAndPasswordMismatch = false;
  }
 

  
  fetchUsers(e) {
  e.preventDefault();
  console.log(e);
  const username = e.target.elements[0].value;
  const password = e.target.elements[1].value;
  //question 1
    console.log("[Form Input] username:",  username);
    console.log("[Form Input] pwd:", password);
  let userIndex = Object.keys(this.credentials).findIndex(item => item === username);
  // question 3
  if (userIndex>=0 && password === this.credentials[username]) {
    // question 4
    this.userAndPasswordMismatch = false;
    window.localStorage.setItem("loggedinUser", Object.keys(this.credentials)[userIndex]);
    this.router.navigate(['home']);
  }
  // else if (username === 'users.username' && password === 'users.password') {
  //   this.router.navigate(['home']);
  // }
  // else if (username === 'laila' && password !== 'laila')
  // {
  //   this.router.navigate(['']);
  // }

  else
  {
    this.userAndPasswordMismatch = true;
    // this.router.navigate(['']);
    // console.log("password failure");
  }

}


}
