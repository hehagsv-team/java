
import { Component, OnInit } from '@angular/core';
import { UserDetailsService } from './../user-details.service';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
@Component({
  // tslint:disable-next-line: component-selector
  selector: 'device-list',
  templateUrl: './device-list.component.html',
  styleUrls: ['./device-list.component.css']
})
export class DeviceListComponent implements OnInit {
  loggedInUser: string;
  devices: any;
  disable = true;

  constructor(private userDetServ: UserDetailsService) { }
  enableData(){
    this.disable = false;
  }

  ngOnInit(): void {
    this.loggedInUser = window.localStorage.getItem('loggedinUser');
    this.userDetServ.fetchDevices().subscribe(data => {
      this.devices = data;
      console.log('Devices:', data);
    });
  }

}
