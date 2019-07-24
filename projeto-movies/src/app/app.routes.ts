import { Routes } from '@angular/router';
import { FilmesComponent } from './filmes/filmes.component';
import { LoginComponent } from './login/login.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { LoggedInGuard } from './login/loggedin.guard';

export const ROUTES: Routes = [
    { path: '', component: FilmesComponent },
    {
        path: 'filmes', component: FilmesComponent,
        canLoad: [LoggedInGuard]
    },
    { path: 'login', component: LoginComponent },
    { path: '**', component: NotFoundComponent }

]