import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AngularFireDatabase } from 'angularfire2/database';

@Injectable({
  providedIn: 'root'
})
export class UserDetailsService {
  credentials: object;
  constructor(private http: HttpClient,
    private db: AngularFireDatabase) { }

  fetchFireBaseUsers(){
    return this.http.get('https://hdd-ang-proj-01.firebaseio.com/users.json');
  }

  resetUserPassword(userName: string,newPassword: string){
    // console.log("USER", userName);
    // console.log("Password", newPassword);
    let body = {};
    body[userName] = newPassword;
    return this.http.patch('https://hdd-ang-proj-01.firebaseio.com/users.json',body);
  }

  fetchDeviceNames(){
    return this.http.get('https://hdd-ang-proj-01.firebaseio.com/device-names.json');
  }

  fetchDevicePerformance(){
    return this.http.get("https://hdd-ang-proj-01.firebaseio.com/device-performance.json");
  }
  

  // fetchDevices(){
  //   return this.http.get('https://hdd-ang-proj-01.firebaseio.com/devices.json');
  // }

  fetchDevicesInfo(){
    return this.http.get('https://hdd-ang-proj-01.firebaseio.com/devices.json');
  }

  editDeviceInfo(body: any){
    console.log("Body:", body);
    let {selectedDeviceName, selectedDeviceType, selectedDeviceFirmware} = body;
    let patchData = {};
    patchData[selectedDeviceName] = {
      "device_type": selectedDeviceType,
      "firmware": `${selectedDeviceFirmware}`
    }

    console.log("patch data", patchData);
    
    return this.http.patch('https://hdd-ang-proj-01.firebaseio.com/devices.json', patchData); 
  }

  deleteDeviceInfo(body: any){
    console.log("Body:", body);
    let {selectedDeviceName} = body;
    return this.http.patch('https://hdd-ang-proj-01.firebaseio.com/devices.json',body);   
  }
}
