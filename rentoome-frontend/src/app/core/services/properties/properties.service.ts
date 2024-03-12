import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Properties } from '../../models/properties';
import { Iproperty } from '../../interfaces/property/iproperty';
import { environment } from '../../../../environments/environment.development';
import { urls } from '../../../url';

@Injectable({
  providedIn: 'root'
})
export class PropertiesService {

  constructor(private http: HttpClient) {
  }

  getData(): Observable<Iproperty> {
    return this.http.get<Iproperty>(environment.apiUrl + urls.GET_PROPERTIES);
  }

}
