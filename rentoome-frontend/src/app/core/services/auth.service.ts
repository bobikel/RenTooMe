import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { JwtRequest } from '../models/Jwt-request.model';
import { JwtResponse } from '../models/jwt-response.model';
import { environment } from '../../../environments/environment.development';
import { urls } from '../../urls';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  /* authenticate(jwtRequest: JwtRequest): Observable<JwtResponse> {
    return this.http.post<JwtResponse>(`${this.baseUrl}/authenticate`, jwtRequest);
  } */

  authenticate(jwtRequest: JwtRequest): Observable<JwtResponse> {
    return this.http
      .post<JwtResponse>(environment.apiUrl + urls.LOGIN + `/authenticate`, jwtRequest)
      .pipe(
        catchError((error) => {
          let errorMessage = 'Unknown error occurred';
          if (error.status === 401) {
            errorMessage = error.error?.message || 'Invalid credentials';
          }
          return throwError(() => new Error(errorMessage));
        })
      );
  }
}
