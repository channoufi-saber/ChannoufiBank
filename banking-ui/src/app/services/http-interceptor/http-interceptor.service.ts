import { HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HttpInterceptorService implements HttpInterceptor {

  constructor() { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
     const token = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMUBnbWFpbC5jb20iLCJmdWxsTmFtZSI6InVzZXIxIHVzZXIxMSIsImV4cCI6MTcxMjM0NDk5MSwidXNlcklkIjoyLCJpYXQiOjE3MTE2MjQ5OTEsImF1dGhvcml0aWVzIjpbeyJhdXRob3JpdHkiOiJST0xFX1VTRVIifV19.Fhk4caxpnDNRNtOO3kraSlxO6Jd5fbFGGc8FnZAMaiw';
      if(token !==null || token !==undefined){
        const authReq = req.clone({
          headers: new HttpHeaders({
            Authorization: 'Bearer ' + token
          })
        });
        return next.handle(authReq);
      }
    
    return next.handle(req);
  }
}

