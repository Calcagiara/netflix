import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Serie } from './serie';

@Injectable({
  providedIn: 'root'
})
export class DatiService {
  url : string =  "http://localhost:8099/api/shows"
  constructor(private http:HttpClient) { }
 // crud
  getAll(): Observable<Serie[]>{
    return this.http.get<Serie[]>(this.url);
  }

  canc(id:number){
    return this.http.delete(this.url+"/"+id);
  }

  add(serie:Serie){
    return this.http.post(this.url,serie);
  }
  update(serie:Serie){
    return this.http.put(this.url,serie);
  }

}
