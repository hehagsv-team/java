import { UserDetailsService } from './user-details.service';
import { environment } from './../environments/environment';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';
import { ChartsModule } from 'ng2-charts';
import { GoogleChartsModule } from 'angular-google-charts';
import { AngularFireModule } from 'angularfire2';
import { FormsModule } from '@angular/forms';
import { AngularFireDatabaseModule } from 'angularfire2/database';
import { AngularFireAuthModule } from 'angularfire2/auth';
import { AngularFirestoreModule } from '@angular/fire/firestore';
import * as pluginDataLabels from 'chartjs-plugin-datalabels';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import { NgxPaginationModule} from 'ngx-pagination';
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
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTableModule } from '@angular/material/table';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule} from '@angular/material/input';
import { MatSortModule } from '@angular/material/sort';
import { Ng2SearchPipeModule} from 'ng2-search-filter';
import { OrderModule} from 'ngx-order-pipe';
import { MenuListComponent } from './menu-list/menu-list.component';
import { NgxSpinnerModule } from 'ngx-spinner';
import { MatProgressSpinnerModule} from '@angular/material/progress-spinner';
const appRoutes: Routes = [
  {
    path: '',
    component: LoginFormComponent
  },
  {
    path: 'login',
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
  {
    path: 'device-list',
    component: DeviceListComponent
  },
  {
    path: 'menu-list',
    component: MenuListComponent
  },
  {
    path: '**',
    component: LoginFormComponent
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
    MenuListComponent

  ],
  imports: [
    BrowserModule,
    Ng2SearchPipeModule,
    MatProgressSpinnerModule,
    OrderModule,
    FormsModule,
    NgxSpinnerModule,
    AngularFireModule.initializeApp(environment.firebase),
    AngularFireDatabaseModule,
    AngularFireAuthModule,
    AngularFirestoreModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    ChartsModule,
    MatTableModule,
    MatFormFieldModule,
    MatInputModule,
    MatSortModule,
    GoogleChartsModule,
    BrowserAnimationsModule,
    NgxPaginationModule
  ],
  providers: [UserDetailsService],
  bootstrap: [AppComponent],
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA,
    NO_ERRORS_SCHEMA
  ]
})
export class AppModule { }
