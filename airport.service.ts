import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Airport } from './airport';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AirportService {
  private baseURL = "http://localhost:8080/FlightReservation.com";
  constructor(private httpClient: HttpClient) { }
  
 
  getAirportById(airportId : number) : Observable<Airport> {
    return this.httpClient.get<Airport>(`${this.baseURL}/readByAirportId/${airportId}`);
  }

  deleteAll(): Observable<any> {
    return this.httpClient.delete(`${this.baseURL}/deleteFd`);
  }

  getAirportList(): Observable<Airport[]>{
    return this.httpClient.get<Airport[]>(`${this.baseURL}/toReadAirportDetails`);
  }

  deleteAirport(airportId : number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/deleteByAirportId/${airportId}`);

  }

  

  createAirport(obj : Airport): Observable<Object>{
    console.log(obj);
    return this.httpClient.post(`${this.baseURL}/toCreateAirportDetails`, obj);
  }
  updateAirport(airportId : number, airportObj : Airport) : Observable<Airport> {
    return this.httpClient.put<Airport>(`${this.baseURL}/updateByAirportId/${airportId}`, airportObj);
}
   searchByName(airportName : any) : Observable<Airport[]> {
  return this.httpClient.get<Airport[]>(`${this.baseURL}/getDetailsByAirportName/${airportName}`);
}


}
