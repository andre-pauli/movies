import { Routes } from '@angular/router';
import { FilmesComponent } from './filmes/filmes.component';
import { LoginComponent } from './login/login.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { LoggedInGuard } from './login/loggedin.guard';
import { HomeComponent } from './home/home.component';
import { AmigosComponent } from './amigos/amigos.component';

export const ROUTES: Routes = [
    { path: '', component: HomeComponent },
    {
        path: 'filmes', component: FilmesComponent,
        canLoad: [LoggedInGuard]
    },
    { path: 'amigos', component: AmigosComponent },
    { path: 'login', component: LoginComponent },
    { path: '**', component: NotFoundComponent }

]