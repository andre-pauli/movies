import { Routes } from '@angular/router';
import { FilmesComponent } from './filmes/filmes.component';
import { NotFoundComponent } from './not-found/not-found.component';

export const ROUTES: Routes = [
    { path: '', component: FilmesComponent },
    { path: 'filmes', component: FilmesComponent },
    { path: '**', component: NotFoundComponent }
]