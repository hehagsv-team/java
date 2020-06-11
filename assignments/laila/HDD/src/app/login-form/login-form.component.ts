import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AngularFirestore} from 'angularfire2/firestore';
import { FormGroup, FormBuilder, Validators, AbstractControl} from '@angular/forms';
import { map, take, debounceTime} from 'rxjs/operators';
@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent  {

// fetchUser: FormGroup;
  constructor(private router: Router) { }

  // ngOnInit() {
  //   this.fetchUser = this.fb.group({
  //     username: ['', [
  //       Validators.required,
  //       CustomValidator.username(this.afs)
  //     ]],
  //     password: ['',
  //   Validators.required,
  //   CustomValidator.password(this.afs)
  // ],
  //   });
  // }
  // get username(){
  //   return this.fetchUser.get('username');
  // }
  // get password(){
  //   return this.fetchUser.get('password');
  // }




// export class CustomValidator {
//     static username(afs: AngularFirestore): any {
//       throw new Error('Method not implemented.');
//     }
//     static password(afs: AngularFirestore) {


//     return(control: AbstractControl) => {

//     const password = control.value.toLowerCase();
//     // tslint:disable-next-line: whitespace
//     return afs.collection('users' ,ref => ref.where('password', '==',password))
//     .valueChanges().pipe(
//     debounceTime(500),
//     take(1),
//     map(arr => arr.length ? { usernameAvailable: false } : null ),
//     );
//     };
//     }

fetchUser(e) {
  e.preventDefault();
  console.log(e);
  const username = e.target.elements[0].value;
  const password = e.target.elements[1].value;

  if (username === 'laila' && password === 'laila') {
    this.router.navigate(['home']);
  }
  else if (username === 'laila' && password !== 'laila')
  {
    this.router.navigate(['']);
  }

  else
  {
    this.router.navigate(['resetpassword']);
  }
}



}
