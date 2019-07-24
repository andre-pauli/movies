import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { MOVIE_API } from '../app.api';
import { Filme } from './filme/filme.model';
import { User } from '../login/user.model';
import { LoginService } from '../login/loginService';

const apiUrl = MOVIE_API;

@Injectable()
export class FilmesService {

    constructor(private http: HttpClient, private loginService: LoginService) { }

    getFilmes(search?: string): Observable<Filme[]> {

        return this.http.get<Filme[]>(`${apiUrl}/api/filmes`)
    }

    getFilmesByTitle(title: string): Observable<Filme[]> {
        let headers = new HttpHeaders()
        if (this.loginService.isLoggedIn) {
            headers.set('Authorization', `Bearer ${this.loginService.user.token}`);
        }
        return this.http.get<Filme[]>(`${apiUrl}/api/filme/${title}`, { headers: headers })
    }
    getFilmesInApi(title: string): Observable<Filme[]> {
        return this.http.get<Filme[]>(`${apiUrl}/api/filme/api/${title}`)

    }
}