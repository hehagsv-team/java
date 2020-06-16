import { environment } from './../environments/environment';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ChartsModule } from 'ng2-charts';
import { GoogleChartsModule } from 'angular-google-charts';
import { AngularFireModule } from 'angularfire2';
import { FormsModule } from '@angular/forms';
import { AngularFireDatabaseModule } from 'angularfire2/database';
import { AngularFireAuthModule } from 'angularfire2/auth';
import { AngularFirestoreModule } from '@angular/fire/firestore';
// import * as pluginDataLabels from 'chartjs-plugin-datalabels';
import {HttpClient, HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PieChartComponent } from './pie-chart/pie-chart.component';
import { BsNavbarComponent } from './bs-navbar/bs-navbar.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { ResetpasswordComponent } from './resetpassword/resetpassword.component';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { DeviceListComponent } from './device-list/device-list.component';

const routes: Routes = [
  {
    path: '',
    component: LoginFormComponent
  },
  {
    path: 'resetpassword',
    component: ResetpasswordComponent
  },
  {
    path: 'home',
    component: HomeComponent
  },
  // {
  //   path: '*',
  //   component: LoginFormComponent
  // },
  {
    path: 'device-list',
    component: DeviceListComponent
  }

];
@NgModule({
  declarations: [
    AppComponent,
    LoginFormComponent,
    ResetpasswordComponent,
    BsNavbarComponent,
    PieChartComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    DeviceListComponent,


  ],
  imports: [
    BrowserModule,
    FormsModule,
    AngularFireModule.initializeApp(environment.firebase),
    AngularFireDatabaseModule,
    AngularFireAuthModule,
    AngularFirestoreModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    ChartsModule,
    GoogleChartsModule
  ],
  providers: [

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
