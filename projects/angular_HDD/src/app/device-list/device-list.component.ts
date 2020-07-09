import { Component, OnInit, ViewChild } from '@angular/core';
import { UserDetailsService } from './../user-details.service';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import { Router } from '@angular/router';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'device-list',
  templateUrl: './device-list.component.html',
  styleUrls: ['./device-list.component.css']
})
export class DeviceListComponent implements OnInit {
  loggedInUser: string;
  disable = true;

  searchText: any;
  searchTextType: any;
  searchTextFirmware: any;

  devices: any;
  devicePerformance: any;
  deviceNames: any;
  deviceInfo: any;
  page: any;
  showEditModalPopup: boolean = false;
// tslint:disable-next-line: ban-types
totalRecords: any;
rowsPerPage: number = 3;

selectedDeviceName : any;
selectedDeviceType: any;
selectedDeviceFirmware: any;
closeResult = '';
saveSuccess = false;
deleteSuccess = false;

userNotExist= false;
    passwordMismatch= false;
  

  listData: MatTableDataSource<any>;
@ViewChild(MatPaginator) paginator: MatPaginator;

  constructor( private userDetServ: UserDetailsService,private router: Router, private modalService: NgbModal) { }

  open(content) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
      console.log(this.closeResult);
    }, (reason) => {
      this.saveSuccess = false;
      this.deleteSuccess=false;
      // this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  // private getDismissReason(reason: any): string {
  //   if (reason === ModalDismissReasons.ESC) {
  //     return 'by pressing ESC';
  //   } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
  //     return 'by clicking on a backdrop';
  //   } else {
  //     return `with: ${reason}`;
  //   }
  // }

  enableData(){
    this.disable = false;
  }

  ngOnInit(): void {

  this.loggedInUser = window.localStorage.getItem('loggedinUser');
    this.fetchData();
  }

  fetchData(){
    this.userDetServ.fetchDevicesInfo().subscribe(data => { 
    
      this.deviceNames = Object.keys(data);
      this.deviceInfo = data;
      console.log("Devices:", data);
      // this.listData.paginator = this.paginator;
    });
  }

  handleRowsPerPage(event: any){
    this.rowsPerPage = event.target.value;
  }

  handleEdit(event){
    console.log("handleEdit:", event);
    this.showEditModalPopup = true;
  }

  handleSelectedDeviceName({target}){
    this.selectedDeviceName = target.value;
  
    const usersList = Object.keys(this.devices);
  
    if(usersList.findIndex(user => user === this.selectedDeviceName) < 0){
      this.devices = true;
    }else this.devices = false;
  }
  
  handleSelectedDeviceType({target}){
    this.selectedDeviceType = target.value;
  }
  
  handleSelectedDeviceFirmware({target}){
    this.selectedDeviceFirmware = target.value;
  }

  handleEditSubmit(e) { //editDeviceInfo
    console.log(e);
    const selectedDeviceName = e.target.elements[0].value;
    const selectedDeviceType = e.target.elements[1].value;
    const selectedDeviceFirmware = e.target.elements[2].value;
    console.log("Values:", {selectedDeviceName, selectedDeviceType, selectedDeviceFirmware});
    this.userDetServ.editDeviceInfo({selectedDeviceName, selectedDeviceType, selectedDeviceFirmware})
      .subscribe(data => {
        console.log("Return Data:", data);
        this.saveSuccess = true;
        this.fetchData();
      },(error)=> {
        this.saveSuccess = false;
      });
  }

  handleDeleteSubmit(e){
    console.log(e);   
    const selectedDeviceName = e.target.elements[0].value;
    this.userDetServ.deleteDeviceInfo({selectedDeviceName})
      .subscribe(data => {
        console.log("Return Data:", data);
        this.deleteSuccess = true;
        this.fetchData();
      },(error)=> {
        this.deleteSuccess = false;
      });
  }


  getSelectedDevice(event){
    console.log("Selected device:", event.target.value);
    let data= JSON.parse(event.target.value);
    console.log("DATA:", data);
    this.selectedDeviceName = data.key
    this.selectedDeviceType = data.value.device_type
    this.selectedDeviceFirmware = data.value.firmware
  }

  // handleEditSubmit(event){
  //   console.log("EDIT Submit:", event.target.value);
  // }

  handleDeviceTypeChange(event){
    console.log("Change in  device type:", event.target.value);
  }

  handleDeviceFirmwareChange(event){
    console.log("Change in  device fw:", event.target.value);

  }
}




