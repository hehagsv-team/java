import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AngularFireDatabase } from 'angularfire2/database';

@Injectable({
  providedIn: 'root'
})
export class UserDetailsService {
  credentials: object;
  constructor(private http: HttpClient,
              private db: AngularFireDatabase) { }

  fetchFireBaseUsers(){
    return this.http.get('https://hdd-ang-proj-01.firebaseio.com/users.json');
  }

  resetUserPassword(userName: string, newPassword: string){

    const body = {};
    body[userName] = newPassword;
    return this.http.patch('https://hdd-ang-proj-01.firebaseio.com/users.json', body);
  }

  fetchDevices(){
    return this.http.get('https://hdd-ang-proj-01.firebaseio.com/devices.json');
  }

}
