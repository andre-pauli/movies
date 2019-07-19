import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { MOVIE_API } from '../app.api';
import { Filme } from './filme/filme.model';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
const apiUrl = MOVIE_API;

@Injectable()
export class FilmesService {

    constructor(private http: HttpClient) { }

    getFilmes(search?: string): Observable<Filme[]> {

        return this.http.get<Filme[]>(`${apiUrl}/api/filmes`)
    }

    getFilmesByTitle(title: string): Observable<Filme[]> {
        return this.http.get<Filme[]>(`${apiUrl}/api/filme/${title}`)
    }
    getFilmesInApi(title: string): Observable<Filme[]> {
        return this.http.get<Filme[]>(`${apiUrl}/api/filme/api/${title}`)
    }
}