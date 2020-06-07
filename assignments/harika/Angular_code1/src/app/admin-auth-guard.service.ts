
import {map} from 'rxjs/operators';
import { AppUser } from './models/app-user'


import { Observable } from 'rxjs';
import { AuthService } from './auth.service';
import { UserService } from './user.service';
import { Injectable } from '@angular/core';
import { CanActivate } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AdminAuthGuard implements CanActivate {

  constructor(private auth: AuthService, private userService: UserService) { }

  canActivate(): Observable<boolean> {
   return this.auth.appUser$.pipe(
    map(appUser => appUser.isAdmin));
    }   
}
  //   return this.auth.user$
  //   .switchMap(user => {
  //    return this.userService.get(user.uid);
  //   })
  //     .map(appUser => appUser.isAdmin);
    
    
 
