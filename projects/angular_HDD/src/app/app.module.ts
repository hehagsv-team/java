import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ChartsModule } from 'ng2-charts';
import { GoogleChartsModule } from 'angular-google-charts';
import * as pluginDataLabels from 'chartjs-plugin-datalabels';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PieChartComponent } from './pie-chart/pie-chart.component';
import { BsNavbarComponent } from './bs-navbar/bs-navbar.component';


@NgModule({
  declarations: [
    AppComponent,
    PieChartComponent,
    BsNavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ChartsModule,
    GoogleChartsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
