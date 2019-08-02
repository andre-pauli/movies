import { Component, OnInit, Input, Injectable } from '@angular/core';
import { User } from 'src/app/login/user.model';
import { LoginService } from 'src/app/login/loginService';
import { Router } from '@angular/router';

@Component({
  selector: 'mv-user-detail',
  templateUrl: './user-detail.component.html'
})

@Injectable()
export class UserDetailComponent implements OnInit {

  constructor(private loginService: LoginService,
    private router: Router) { }
  nomeUser: string = window.localStorage.getItem('nome_user')
  tokenUser: string = window.localStorage.getItem('token_movies')

  ngOnInit() {
  }

  user(): User {
    if (this.loginService.isLoggedIn) {
      return this.loginService.userAtual()
    }
    return undefined
  }

  isLoggedIn(): boolean {
    return this.loginService.isLoggedIn()
  }

  entrar() {
    this.router.navigate(['login'])
  }

  logout() {
    localStorage.clear();
    this.router.navigate(['']);
  }

}
