import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FlightListComponent } from './flight-list/flight-list.component';
import { CreateFlightComponent } from './create-flight/create-flight.component';
import { ViewFlightComponent } from './view-flight/view-flight.component';
import {UpdateFlightComponent} from'./update-flight/update-flight.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { AuthGaurdService } from './auth-gaurd.service';
import { LogOutComponent } from './log-out/log-out.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { FlightCompanyListComponent } from './flight-company-list/flight-company-list.component';
import { UpdateFlightCompanyComponent } from './update-flight-company/update-flight-company.component';
import { ViewFlightCompanyComponent } from './view-flight-company/view-flight-company.component';
import { UpdateAirportComponent } from './update-airport/update-airport.component';
import { ViewAirportComponent } from './view-airport/view-airport.component';
import { AirportListComponent } from './airport-list/airport-list.component';
import { CreateFlightCompanyComponent } from './create-flight-company/create-flight-company.component';
import { CreateAirportComponent } from './create-airport/create-airport.component';


const routes: Routes = [
  {path: 'see-all-flights', component: FlightListComponent,canActivate: [AuthGaurdService]},
  {path: 'create-flight', component: CreateFlightComponent,canActivate: [AuthGaurdService]},
  {path: '', redirectTo: 'signin', pathMatch: 'full'},
  {path: 'update-flight/:flightId', component: UpdateFlightComponent,canActivate: [AuthGaurdService]},
  {path: 'view-flight-details/:flightId', component: ViewFlightComponent, canActivate: [AuthGaurdService]},
  {path:'sign-in', component: SignInComponent},
  {path:'sign-up', component: SignUpComponent},
  { path: 'log-out', component: LogOutComponent },
  { path: 'about-us', component: AboutUsComponent },
  {path: 'flight-company-list', component: FlightCompanyListComponent,canActivate: [AuthGaurdService]},
  {path: 'update-flight-company/:companyId', component: UpdateFlightCompanyComponent,canActivate: [AuthGaurdService]},
  {path: 'view-flight-company-details/:companyId', component: ViewFlightCompanyComponent, canActivate: [AuthGaurdService]},
  {path: 'update-airport/:airportId', component: UpdateAirportComponent,canActivate: [AuthGaurdService]},
  {path: 'view-airport-details/:airportId', component: ViewAirportComponent, canActivate: [AuthGaurdService]},
  {path: 'airport-list', component: AirportListComponent,canActivate: [AuthGaurdService]},
  {path: 'create-flight-company', component: CreateFlightCompanyComponent,canActivate: [AuthGaurdService]},
  {path: 'create-airport', component: CreateAirportComponent,canActivate: [AuthGaurdService]},
  



  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

