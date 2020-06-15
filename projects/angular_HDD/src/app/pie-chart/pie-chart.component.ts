import { Component } from '@angular/core';
import { ChartType, ChartOptions, ChartDataSets } from 'chart.js';
import { SingleDataSet, Label, monkeyPatchChartJsLegend, monkeyPatchChartJsTooltip } from 'ng2-charts';
import * as pluginDataLabels from 'chartjs-plugin-datalabels';

@Component({
  selector: 'pie-chart',
  templateUrl: './pie-chart.component.html',
  styleUrls: ['./pie-chart.component.css']
})
export class PieChartComponent {

  public pieChartOptions: ChartOptions = {
    responsive: true,
    legend: {
      position: 'top',
    },
    plugins: {
      datalabels: {
        formatter: (value, ctx) => {
          const label =ctx.chart.data.labels[ctx.dataIndex];
          return label;
        },
      },
    }
  };

  public pieChartLabels: Label[] =['device3','device2','device1','device5','device4'];
  public pieChartPlugins = [pluginDataLabels]; 
 public Data:any =[30, 13, 27, 8, 22];
 public pieChartType:string = 'pie';
  public Colors:any = [
{
  backgroundColor: ['blue','red','orange','green','skyblue']
  }
]; 
barChartOptions: ChartOptions = {
  responsive: true,
};
barChartLabels: Label[] = ['Device3', 'Device2', 'Device1', 'Device5', 'Device4'];

barChartType: ChartType = 'bar';
barChartLegend = true;
barChartPlugins = [];
barWidth: 5;
barChartData: ChartDataSets[] = [
  { data: [30, 13, 27, 8, 22], 
    backgroundColor:['blue','red','orange','green','skyblue'],  
   }
];
  constructor() {
    monkeyPatchChartJsTooltip();
    monkeyPatchChartJsLegend();
  }

}


