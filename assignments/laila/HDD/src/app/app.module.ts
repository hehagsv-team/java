import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ChartsModule } from 'ng2-charts';
import { GoogleChartsModule } from 'angular-google-charts';
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
import { HttpClientModule} from '@angular/common/http';

const appRoutes: Routes = [
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
    FooterComponent

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    RouterModule.forRoot(appRoutes),
    ChartsModule,
    GoogleChartsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
