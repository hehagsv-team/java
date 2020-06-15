import { User } from './user.model';

import * as pluginDataLabels from 'chartjs-plugin-datalabels';
import { Component, OnInit } from '@angular/core';
import { ChartType, ChartOptions, ChartDataSets } from 'chart.js';
import { SingleDataSet, Label, monkeyPatchChartJsLegend, monkeyPatchChartJsTooltip } from 'ng2-charts';
import { HttpClient } from '@angular/common/http';
import { HttpClientModule} from '@angular/common/http';
import {  map } from 'rxjs/operators';
import { AngularFireDatabase, AngularFireObject, AngularFireList } from 'angularfire2/database';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'HDD';
  loadedUsers = [];
  creds: object = {};

constructor(private http: HttpClient){

}
ngOnInit(){
  this.fetchUsers();
}
onCreateUser(postData: User){
  this.http.post<{ username: string}>
  ('https://hdd-ang-proj-01.firebaseio.com/users.json',
  postData
  ).subscribe(responseData => {
    console.log(responseData);
  });
}
private fetchUsers(){
  this.http
  .get<{ [key: string]: User }>(
    'https://hdd-ang-proj-01.firebaseio.com/users.json')
  .pipe(
    map(respopnseData => {
      console.log("Resp:",respopnseData);
      this.creds = respopnseData;
    // const usersArray : User [] = [];
    // for (const key in respopnseData) {
    //   if(respopnseData.hasOwnProperty(key)){
    //   usersArray.push({...respopnseData[key], id: key })
    // }
    // }
    // return usersArray;
    
  })
  )
  .subscribe(users => {
    console.log(users);
  });
}


}


