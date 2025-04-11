import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { LoginService } from '../services/login.service';

export const authGuard: CanActivateFn = (_route, _state) => {

  let isauthenticated = inject(LoginService).isAuthenticated()
  let router = inject(Router)

  if (isauthenticated) {
    return true;
  } else {
    router.navigate(['/login']);
    return false;
  }
};
