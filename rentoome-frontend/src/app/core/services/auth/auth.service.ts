import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }

  public getAuthorizationToken():string {
    // Logique pour générer un jeton d'autorisation
    var token:string= '';

    // Dans un scénario réel, vous générez probablement un token JWT en utilisant une librairie comme jjwt

    return token;
  }
}
