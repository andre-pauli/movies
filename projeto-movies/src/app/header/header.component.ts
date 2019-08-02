import { Component, OnInit } from '@angular/core';
import { FilmesService } from '../filmes/filmes.service';
import { LoginService } from '../login/loginService';
import { Filme } from '../filmes/filme/filme.model';
import { FormsModule } from '@angular/forms';
import { Observable } from 'rxjs';
import { User } from '../login/user.model';
import { map } from 'rxjs/operators';

@Component({
  selector: 'mv-header',
  templateUrl: './header.component.html'
})
export class HeaderComponent implements OnInit {

  filmes: Filme[]

  constructor(private filmesService: FilmesService, private loginService: LoginService) { }

  ngOnInit() {
  }

  isLoggedIn() {
    return this.loginService.isLoggedIn()
  }
}
