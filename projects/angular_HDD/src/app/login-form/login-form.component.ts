import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {
<<<<<<< HEAD

=======
  // [x: string]: any;
>>>>>>> 0bac229d2ba365719515d625a3182d89e8bf4669

  constructor(private router: Router) { }

  ngOnInit(): void {
  }
loginUser(e) {
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
<<<<<<< HEAD

=======
// get f(){
//   return this.form.controls;
// }
>>>>>>> 0bac229d2ba365719515d625a3182d89e8bf4669

}
