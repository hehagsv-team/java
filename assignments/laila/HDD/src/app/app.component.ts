import { Component, OnInit } from '@angular/core';
import { ChartType, ChartOptions, ChartDataSets } from 'chart.js';
import { SingleDataSet, Label, monkeyPatchChartJsLegend, monkeyPatchChartJsTooltip } from 'ng2-charts';
import { HttpClient } from '@angular/common/http';
import { HttpClientModule} from '@angular/common/http';

// import * as pluginDataLabels from 'chartjs-plugin-datalabels';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit  {
  title = 'HDD';
  loadedUsers = [];

constructor(private http: HttpClient){

}
ngOnInit(){
  this.fetchUser();
}
// onFetchUser(postData: {
//   username: string;
//   password: string
// }){
//   this.http.post('https://hdd-ang-proj-01.firebaseio.com/users.json',
//   postData
//   ).subscribe(responseData => {
//     console.log(responseData);
//   });
// }
private fetchUser(){
  this.http.get('https://hdd-ang-proj-01.firebaseio.com/users.json')
  .subscribe(users => {
    console.log(users);
  });
}

}

