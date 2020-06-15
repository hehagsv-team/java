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

  constructor(
    private router: Router,
    private http: HttpClient,
    db: AngularFireDatabase) { }

  ngOnInit(): void {
    this.fetchFireBaseUsers();
  }
  private fetchFireBaseUsers(){
    this.http
    .get<any>(
      'https://hdd-ang-proj-01.firebaseio.com/users.json')
    .subscribe(creds => {

      console.log('Credentials from firebase:', creds);
      this.credentials = creds;
    });
  }

  fetchUsers(e) {
  e.preventDefault();
  console.log(e);
  const username = e.target.elements[0].value;
  const password = e.target.elements[1].value;

  console.log('[Form Input] username:', username);
  console.log('[Form Input] pwd:', password);

  if (Object.keys(this.credentials).findIndex(item => item === username) >= 0 && password === this.credentials[username]) {

    this.router.navigate(['home']);
  }

  else
  {
    this.router.navigate(['']);
  }

}

}
