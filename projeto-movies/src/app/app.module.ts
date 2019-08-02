import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
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
import { LoggedInGuard } from './login/loggedin.guard';
import { HomeComponent } from './home/home.component';
import { AuthInterceptor } from './login/auth.interceptor';
import { AmigosComponent } from './amigos/amigos.component';
import { AmigoComponent } from './amigos/amigo/amigo.component';




@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FilmesComponent,
    NotFoundComponent,
    FilmeComponent,
    LoginComponent,
    UserDetailComponent,
    InputComponent,
    HomeComponent,
    AmigosComponent,
    AmigoComponent
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
    NgModule,
    LoggedInGuard,
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
