import { HttpClient, HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, retry, throwError } from 'rxjs';
import { environment } from '../../../../environments/environment.development';
import { urls } from '../../../url';
import { IPropertyType } from '../../interfaces/propertyType/i-property-type';

@Injectable({
  providedIn: 'root'
})
export class PropertyTypesService {

  constructor(private http: HttpClient) {
  }

  // getData(): Observable<IPropertyType> {
  //   return this.http.get<IPropertyType>(environment.apiUrl + urls.GET_PROPERTY_TYPES);
  // }

  getData(): Observable<any> {
    return this.http.get<any>(environment.apiUrl + urls.GET_PROPERTY_TYPES);
  }

  getPropertyTypesResponse(): Observable<HttpResponse<IPropertyType>> {
    const options = {
      responseType: 'text' as const,
      observe: 'response'
    };

    return this.http.get<IPropertyType>(

      environment.apiUrl + urls.GET_PROPERTY_TYPES, { observe: 'response', responseType: 'json' })
      .pipe(
        retry(3),
        catchError(this.handleError)
      );;
  }

  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${error.status}, body was: `, error.error);
    }
    // Return an observable with a user-facing error message.
    return throwError(() => new Error('Something bad happened; please try again later.'));
  }

}
