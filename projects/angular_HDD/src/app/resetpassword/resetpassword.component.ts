import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-resetpassword',
  templateUrl: './resetpassword.component.html',
  styleUrls: ['./resetpassword.component.css']
})
export class ResetpasswordComponent implements OnInit {

  constructor(private router: Router) { }
    // else if (username === 'laila' && password !== 'laila')
    // {
    //   this.router.navigate(['']);
    // }

  ngOnInit(): void {
  }
  User(e) {
    // e.preventDefault();
    console.log(e);
    const username = e.target.elements[0].value;
    const newPassword = e.target.elements[1].value;

    const renterPassword = e.target.elements[2].value;

    if (username === 'laila' && newPassword === 'harika' && renterPassword === 'harika') {
      this.router.navigate(['']);
    }
    else
    {
      this.router.navigate(['resetpassword']);
    }

  }

  }



