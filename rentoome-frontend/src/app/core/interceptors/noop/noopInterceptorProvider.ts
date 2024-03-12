import { HTTP_INTERCEPTORS } from "@angular/common/http";
import { Provider } from "@angular/core";
import { NoopInterceptor } from "./noop.interceptor";

export const noopInterceptorProvider: Provider =
  { provide: HTTP_INTERCEPTORS, useClass: NoopInterceptor, multi: true };