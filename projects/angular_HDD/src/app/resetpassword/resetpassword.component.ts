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
  
    userNotExist= false;
    passwordMismatch= false;
  

  constructor(private router: Router,
    private userDetails: UserDetailsService,
    ) { }

  ngOnInit(){
    this.userDetails.fetchFireBaseUsers().subscribe(userDetails => this.credentials = userDetails);
  }
    
  
  checkPasswordMatch(newPassword: string, confirmPassword: string){
    if(newPassword !== confirmPassword){
      this.passwordMismatch = true;
      return false;
    } else {
       this.passwordMismatch = false,
       this.userNotExist = false;
      }
    return true;
    }


  passwordReset(e) {
    console.log(e);
    const username = e.target.elements[0].value;
    const newPassword = e.target.elements[1].value;
    const confirmPassword = e.target.elements[2].value;

    const users = Object.keys(this.credentials);

    const matchedUser = users.find(user => user ===username);

    if (matchedUser !== undefined) {
      if(this.checkPasswordMatch(newPassword, confirmPassword)){
        this.userDetails.resetUserPassword(matchedUser, newPassword)
          .subscribe(returnValue =>{ 
            console.log("Return value:", returnValue);
           if( returnValue[matchedUser] === newPassword){
             this.router.navigate(['login']);
           }
      })
    }
    }
    else
    {
      this.userNotExist = true;
    }

  }



  }



