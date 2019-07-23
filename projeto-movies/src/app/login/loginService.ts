import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MOVIE_API } from '../app.api';
import { Observable } from 'rxjs';
import { User } from './user.model';

const apiUrl = MOVIE_API;

@Injectable()
export class LoginService {



    constructor(private http: HttpClient) {

    }

    login(email: string, password: string): Observable<User> {
        console.log(email);
        console.log(password);

        const body = {
            email: email,
            password: password
        };

        console.log(`${apiUrl}/login`, body);

        return this.http.post<User>(`${apiUrl}/login`, body)
    }

}
