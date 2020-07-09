import { UserDetailsService } from './../user-details.service';
import { Component } from '@angular/core';
import { ChartType, ChartOptions, ChartDataSets } from 'chart.js';
import { SingleDataSet, Label, monkeyPatchChartJsLegend, monkeyPatchChartJsTooltip } from 'ng2-charts';
import * as pluginDataLabels from 'chartjs-plugin-datalabels';
import * as Chart from 'chart.js';

@Component({
  selector: 'pie-chart',
  templateUrl: './pie-chart.component.html',
  styleUrls: ['./pie-chart.component.css']
})
export class PieChartComponent {
  devicePerformance: any;
  deviceNames: any;
  
  HddPieChart: any = [];
  HddBarChart: any = [];
  
  constructor(private userDetailServ: UserDetailsService) {
    monkeyPatchChartJsTooltip();
    monkeyPatchChartJsLegend();
  }
   ngOnInit() {
    this.userDetailServ.fetchDevicePerformance().subscribe( deviceData => {
      console.log("dev deviceData:", deviceData);
      this.devicePerformance = Object.values(deviceData);
      this.deviceNames = Object.keys(deviceData);
 
    this.HddPieChart = new Chart("hddpiechart", {
      type: 'pie',  
      data: {  
        labels: this.deviceNames,  
        
        datasets: [  
          {  
            data: this.devicePerformance,  
            borderColor: '#3cb371',  
            backgroundColor: ['#004c6d','#317190','#5797b4','#7dc0d9','#a4eaff'],  
          }  
        ] 
    },options: {  
      legend: {
        position: 'top',
        labels:{
          fontColor: 'black',
          fontSize: 13
        }
      },  
      scales: {  
        xAxes: [{  
          display: false  
        }],  
        yAxes: [{  
          display: false  
        }],  
      }  
    } });

    this.HddBarChart = new Chart("hddbarchart", {
      type: 'bar',  
      data: {  
        labels: this.deviceNames,  
        datasets: [  
          {  
            data: this.devicePerformance,  
            borderColor: '#3cb371',  
            backgroundColor: ['#004c6d','#317190','#5797b4','#7dc0d9','#a4eaff'],  
          }  
        ] 
    },options: {  
      legend: {  
        display: false
      },  
      scales: {  
        xAxes: [{  
          display: true,id: "devices",
          ticks: {
            fontColor: 'black',
            fontSize: 13
          }
        }],  
        yAxes: [{  
          display: true ,id: "count",
          ticks: {
            fontColor: 'black',
            fontSize: 13
          } 
        }],  
      }  
    } });
  });
  }
}


