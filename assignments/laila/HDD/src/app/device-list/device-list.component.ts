import {  User } from './../user.model';
import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { UserDetailsService } from './../user-details.service';
import {MatPaginator} from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';
import { OrderPipe } from 'ngx-order-pipe';
import { NgxSpinnerService } from 'ngx-spinner';

@Component({
  // tslint:disable-next-line: component-selector
  selector: 'device-list',
  templateUrl: './device-list.component.html',
  styleUrls: ['./device-list.component.css']
})

export class DeviceListComponent implements OnInit {

  loggedInUser: string;
  disable = true;
  order = 'deciceNames';
  array: any[];

  devices: any;
  devicePerformance: any;
  deviceNames: any;
  deviceInfo: any;
  page: any;
  sorting: any;
  searchText: any;
  searchTextType: any;
  searchTextFirmware: any;
  showEditModalPopup = false;
totalRecords: any;
rowsPerPage = 3;
sortItem: any;
selectedDeviceName: any;
selectedDeviceType: any;
selectedDeviceFirmware: any;
show = true;

  listData: MatTableDataSource<any>;
@ViewChild(MatPaginator) paginator: MatPaginator;
@ViewChild(MatSort) sort: MatSort;
  data: any;

  constructor( private userDetServ: UserDetailsService,
               private orderPipe: OrderPipe,
               private spinner: NgxSpinnerService ) {}


  ngOnInit(){

    // this.show = true;

    // setTimeout(() => {
    //   this.show = false;
    //   }, 2000);

    this.loggedInUser = window.localStorage.getItem('loggedinUser');
    this.userDetServ.fetchDevicesInfo().subscribe(data => {
          this.deviceNames = Object.keys(data);
          this.deviceInfo = data;
          console.log('Devices:', data);

        });
  }

  handleRowsPerPage(event: any){
    this.rowsPerPage = event.target.value;
  }

  handleEdit(event){
    this.showEditModalPopup = true;
  }

  getSelectedDevice(event){
    console.log('Selected device:', event.target.value);
    const data = event.target.value;
    this.selectedDeviceName = data.key;
    this.selectedDeviceType = data.value.device_type;
    this.selectedDeviceFirmware = data.value.firmware;
  }

}



