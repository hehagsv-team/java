import { UserDetailsService } from './../user-details.service';
import { Component } from '@angular/core';
import { ChartType, ChartOptions} from 'chart.js';
import { SingleDataSet, Label, monkeyPatchChartJsLegend, monkeyPatchChartJsTooltip } from 'ng2-charts';
import * as pluginDataLabels from 'chartjs-plugin-datalabels';
import * as Chart from 'chart.js';
import { ChartDataSets} from 'chart.js';
import { NgxSpinnerService } from 'ngx-spinner';
@Component({
  // tslint:disable-next-line: component-selector
  selector: 'pie-chart',
  templateUrl: './pie-chart.component.html',
  styleUrls: ['./pie-chart.component.css']
})
export class PieChartComponent {
  devicePerformance: any;
  deviceNames: any;

  HddPieChart: any = [];
  HddBarChart: any = [];
show = true;
  constructor(private userDetailServ: UserDetailsService, private spinner: NgxSpinnerService) {
    monkeyPatchChartJsTooltip();
    monkeyPatchChartJsLegend();
  }
   // tslint:disable-next-line: use-lifecycle-interface
   ngOnInit() {
    this.show = true;

    setTimeout(() => {
    this.show = false;
    }, 2000);
    this.userDetailServ.fetchDevicePerformance().subscribe( deviceData => {
      console.log('dev deviceData:', deviceData);
      this.devicePerformance = Object.values(deviceData);
      this.deviceNames = Object.keys(deviceData);

      this.HddPieChart = new Chart('hddpiechart', {
      type: 'pie',
      data: {
        labels: this.deviceNames,

        datasets: [
          {
            data: this.devicePerformance,
            borderColor: '#3cb371',
            // padding: '#region',
            backgroundColor: ['#004c6d', '#317190', '#5797b4', '#7dc0d9', '#a4eaff'],
          }
        ]
    }, options: {
      legend: {
        position: 'top',
        labels: {
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

      this.HddBarChart = new Chart('hddbarchart', {
      type: 'bar',
      data: {
        labels: this.deviceNames,
        datasets: [
          {
            data: this.devicePerformance,
            borderColor: '#3cb371',
            backgroundColor: ['#004c6d', '#317190', '#5797b4', '#7dc0d9', '#a4eaff'],
          }
        ]
    }, options: {
      legend: {
        display: false
      },
      scales: {
        xAxes: [{
          // tslint:disable-next-line: whitespace
          display: true,id: 'devices',
          ticks: {
            fontColor: 'black',
            fontSize: 13
          }
        }],
        yAxes: [{
          display: true , id: 'count',
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


