import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginService } from './loginService';
import { Injectable } from '@angular/core';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

    constructor(private loginService: LoginService) { }

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

        if (this.loginService.isLoggedIn()) {
            var usuario = window.localStorage.getItem('token_movies')
            const authRequest = req.clone({ setHeaders: { 'Authorization': `Bearer ${usuario}` } })
            return next.handle(authRequest);
        } else {
            return next.handle(req);
        }
    }
}