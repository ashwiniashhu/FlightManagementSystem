import { Injectable } from '@angular/core';
import { HttpClient,HttpParams } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Flight } from './flight';

@Injectable({
  providedIn: 'root'
})
export class FlightService {
 
  

  private baseURL = "http://localhost:8080/FlightReservation.com";

  constructor(private httpClient: HttpClient) { }
  
 
  getFlightById(flightId : number) : Observable<Flight> {
    return this.httpClient.get<Flight>(`${this.baseURL}/readById/${flightId}`);
  }

  deleteAll(): Observable<any> {
    return this.httpClient.delete(`${this.baseURL}/deleteFd`);
  }

  getFlightList(): Observable<Flight[]>{
    return this.httpClient.get<Flight[]>(`${this.baseURL}/toReadFd`);
  }

  deleteFlight(flightId : number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/deleteById/${flightId}`);

  }

  findByDomesticFLights(): Observable<Flight[]> {
    return this.httpClient.get<Flight[]>(`${this.baseURL}/isDomesticFlight`);
  }

  findByNonDomesticFLights(): Observable<Flight[]> {
    return this.httpClient.get<Flight[]>(`${this.baseURL}/nonDomesticFlight`);
}

  createFlight(flight : Flight): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/toCreateFd`, flight);
  }
  updateFlight(flightId : number, flightObj : Flight) : Observable<Flight> {
    return this.httpClient.put<Flight>(`${this.baseURL}/updateById/${flightId}`, flightObj);
}
   searchByFlightName(flightName : any) : Observable<Flight[]> {
  return this.httpClient.get<Flight[]>(`${this.baseURL}/getDetailsByFlightName/${flightName}`);
}
signin(email:any, password:any):Observable<any>
  {
    const params=new HttpParams().set('email',email).set('password',password);
    console.log(params);
    return this.httpClient.get(`${this.baseURL}/login`,{params});
  }
  SortRating(direction:string,field:string):Observable<Flight[]>{ 
    console.log(direction)
  return this.httpClient.get<Flight[]>(`${this.baseURL}/sortByFlightRating/${direction}?fieldName=${field}`);

  }
  SortingTicketCost(direction:string,field:string):Observable<Flight[]>{ {
    console.log(direction)
  return this.httpClient.get<Flight[]>(`${this.baseURL}/sortByTicketCost/${direction}?fieldName=${field}`);

  }
}


}