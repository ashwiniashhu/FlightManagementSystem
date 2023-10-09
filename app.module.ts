import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FlightListComponent } from './flight-list/flight-list.component';
import { CreateFlightComponent } from './create-flight/create-flight.component';
import { UpdateFlightComponent } from './update-flight/update-flight.component';
import { ViewFlightComponent } from './view-flight/view-flight.component';
//import { FlightComponent } from './flight.component';
import {FormsModule} from '@angular/forms';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { LogOutComponent } from './log-out/log-out.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { FlightCompanyListComponent } from './flight-company-list/flight-company-list.component';
import { ViewFlightCompanyComponent } from './view-flight-company/view-flight-company.component';
import { UpdateFlightCompanyComponent } from './update-flight-company/update-flight-company.component';
import { UpdateAirportComponent } from './update-airport/update-airport.component';
import { ViewAirportComponent } from './view-airport/view-airport.component';
import { AirportListComponent } from './airport-list/airport-list.component';
import { CreateFlightCompanyComponent } from './create-flight-company/create-flight-company.component';
import { CreateAirportComponent } from './create-airport/create-airport.component';

@NgModule({
  declarations: [
    AppComponent,
    FlightListComponent,
    CreateFlightComponent,
    UpdateFlightComponent,
    ViewFlightComponent,
    SignInComponent,
    SignUpComponent,
    LogOutComponent,
    AboutUsComponent,
    FlightCompanyListComponent,
    ViewFlightCompanyComponent,
    UpdateFlightCompanyComponent,
    UpdateAirportComponent,
    ViewAirportComponent,
    AirportListComponent,
    CreateFlightCompanyComponent,
    CreateAirportComponent,
   
    
    
    
   // FlightComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
   // NgxPaginationModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
