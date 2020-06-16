import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'device-list',
  templateUrl: './device-list.component.html',
  styleUrls: ['./device-list.component.css']
})
export class DeviceListComponent implements OnInit {
  loggedInUser: string;
  
  constructor() { }

  ngOnInit(): void {
    this.loggedInUser = window.localStorage.getItem("loggedinUser");
  }

}
