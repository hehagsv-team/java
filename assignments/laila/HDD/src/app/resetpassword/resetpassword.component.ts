import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserDetailsService } from '../user-details.service';
@Component({
  selector: 'app-resetpassword',
  templateUrl: './resetpassword.component.html',
  styleUrls: ['./resetpassword.component.css']
})
export class ResetpasswordComponent {
    credentials: object;

    userName: string;
    newPassword = '';
    confirmPassword = '';

    userNotExist = false;
    passwordMismatch = false;


  constructor(private router: Router,
              private userDetails: UserDetailsService,
    ) { }

  // tslint:disable-next-line: use-lifecycle-interface
  ngOnInit(){
    this.userDetails.fetchFireBaseUsers().subscribe(userDetails => this.credentials = userDetails);
  }


  checkPasswordMatch(newPassword: string, confirmPassword: string){
    if (newPassword !== confirmPassword){
      this.passwordMismatch = true;
      return false;
    } else {
       this.passwordMismatch = false,
       this.userNotExist = false;
      }
    return true;
    }
handleUserName({target}){
  this.userName = target.value;

  const usersList = Object.keys(this.credentials);

  if (usersList.findIndex(user => user === this.userName) < 0){
    this.userNotExist = true;
  }else { this.userNotExist = false; }
}

handleNewPassword({target}){
  this.newPassword = target.value;
  this.checkPasswordMatch(this.newPassword, this.confirmPassword);
}

handleConfirmPassword({target}){
  this.confirmPassword = target.value;
  this.checkPasswordMatch(this.newPassword, this.confirmPassword);
}


  passwordReset(e) {
    console.log(e);
    const username = e.target.elements[0].value;
    const newPassword = e.target.elements[1].value;
    const confirmPassword = e.target.elements[2].value;

    const users = Object.keys(this.credentials);

    const matchedUser = users.find(user => user === username);

    if (matchedUser !== undefined) {
      if (this.checkPasswordMatch(newPassword, confirmPassword)){
        this.userDetails.resetUserPassword(matchedUser, newPassword)
          .subscribe(returnValue => {
            console.log('Return value:', returnValue);
            if ( returnValue[matchedUser] === newPassword){
             this.router.navigate(['login']);
           }
      });
    }
    }
    else
    {
      this.userNotExist = true;
    }

  }



  }



