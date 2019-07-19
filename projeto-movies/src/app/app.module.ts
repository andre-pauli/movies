import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { ROUTES } from './app.routes'


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RouterModule, PreloadAllModules } from '@angular/router';
import { from } from 'rxjs';
import { HeaderComponent } from './header/header.component';
import { FilmesComponent } from './filmes/filmes.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { FilmeComponent } from './filmes/filme/filme.component';
import { HttpClientModule } from '@angular/common/http';
import { FilmesService } from './filmes/filmes.service';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FilmesComponent,
    NotFoundComponent,
    FilmeComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    RouterModule.forRoot(ROUTES, { preloadingStrategy: PreloadAllModules })
  ],
  providers: [FilmesService, FormsModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
