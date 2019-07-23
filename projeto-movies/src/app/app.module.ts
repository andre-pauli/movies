import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { PreloadAllModules, RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ROUTES } from './app.routes';
import { FilmeComponent } from './filmes/filme/filme.component';
import { FilmesComponent } from './filmes/filmes.component';
import { FilmesService } from './filmes/filmes.service';
import { HeaderComponent } from './header/header.component';
import { UserDetailComponent } from './header/user-detail/user-detail.component';
import { LoginComponent } from './login/login.component';
import { LoginService } from './login/loginService';
import { NotFoundComponent } from './not-found/not-found.component';
import { InputComponent } from './shared/input/input.component';




@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FilmesComponent,
    NotFoundComponent,
    FilmeComponent,
    LoginComponent,
    UserDetailComponent,
    InputComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(ROUTES, { preloadingStrategy: PreloadAllModules })
  ],
  providers: [FilmesService, 
              FormsModule, 
              LoginService, 
              NgModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
