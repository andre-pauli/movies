import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from './loginService';
import { User } from './user.model';
@Component({
  selector: 'mv-login',
  templateUrl: './login.component.html'
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup
  user: User

  constructor(private fb: FormBuilder,
    private loginService: LoginService,
    private route: Router) { }

  ngOnInit() {
    this.loginForm = this.fb.group({
      email: this.fb.control('', [Validators.required, Validators.email]),
      password: this.fb.control('', [Validators.required])
    })



    // user => window.localStorage.setItem('token_movies', user.token)
  }

  login() {
    this.loginService.login(this.loginForm.value.email,
      this.loginForm.value.password)
      .subscribe(user => {
        this.user = user,
          window.localStorage.setItem('token_movies', user.token),
          window.localStorage.setItem('nome_user', user.name),
          alert(`Bem Vindo,  ${user.name}`)
      },
        response => alert("Dados inválidos"),
        () => this.route.navigate(['/filmes']))
  }




}
