import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FlightCompany } from './flight-company';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FlightCompanyService {

  private baseURL = "http://localhost:8080/FlightReservation.com";

  constructor(private httpClient: HttpClient) { }
  
 
  getCompanyById(companyId : number) : Observable<FlightCompany> {
    return this.httpClient.get<FlightCompany>(`${this.baseURL}/readByCompanyId/${companyId}`);
  }

  deleteAll(): Observable<any> {
    return this.httpClient.delete(`${this.baseURL}/deleteCompanyDetails`);
  }

  getFlightCompanyList(): Observable<FlightCompany[]>{
    return this.httpClient.get<FlightCompany[]>(`${this.baseURL}/toReadCompanyDetails`);
  }

  deleteCompany(companyId : number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/deleteByCompanyId/${companyId}`);

  }
  createCompany(obj : FlightCompany): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/toCreateCompanyDetails`, obj);
  }
  updateCompany( companyId: number, companyObj : FlightCompany) : Observable<FlightCompany> {
    return this.httpClient.put<FlightCompany>(`${this.baseURL}/updateByCompanyId/${companyId}`, companyObj);
}
  searchByCompanyName(companyName : any) : Observable<FlightCompany[]> {
  return this.httpClient.get<FlightCompany[]>(`${this.baseURL}/getDetailsByCompanyName/${companyName}`);
}
}