import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Properties } from '../../models/properties/properties';
import { Iproperty } from '../../interfaces/property/iproperty';
import { environment } from '../../../../environments/environment.development';
import { urls } from '../../../url';
import { HttpParams } from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class PropertiesService {

  constructor(private http: HttpClient) {
  }

  getData(): Observable<Iproperty> {
    return this.http.get<Iproperty>(environment.apiUrl + urls.GET_PROPERTIES);
  }

  addProperty(data: any): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });

    return this.http.post<any>(`${environment.apiUrl + urls.ADD_PROPERTIES}`, data, { headers });
  }

  editProperty(data: any): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });

    return this.http.put<any>(`${environment.apiUrl + urls.EDIT_PROPERTIES + "/" + data}`, data, { headers });
  }

  deleteProperty(data: any): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.delete<any>(`${environment.apiUrl + urls.DELETE_PROPERTIES + "/" + data}`, { headers });
  }

}
