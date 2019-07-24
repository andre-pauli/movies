import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MOVIE_API } from '../app.api';
import { User } from './user.model';
import { map, catchError } from 'rxjs/operators'
import { error } from 'util';
import { Router } from '@angular/router';

const apiUrl = MOVIE_API;

@Injectable()
export class LoginService {    

    user: User


    constructor(private http: HttpClient, private router: Router) {

    }

    isLoggedIn(): boolean {
        return this.user !== undefined;
    }

    handleLogin() {
        this.router.navigate(['/login']);
    }


    login(email: string, password: string): Observable<User> {
        const body = {
            email: email,
            password: password
        };
        return this.http.post<User>(`${apiUrl}/login`, body)
            .pipe(
                map(user => this.user = user)
            )
    }

}
