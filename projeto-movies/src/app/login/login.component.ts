import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms'
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
    private loginService: LoginService) { }

  ngOnInit() {
    this.loginForm = this.fb.group({
      email: this.fb.control('', [Validators.required, Validators.email]),
      password: this.fb.control('', [Validators.required])
    })
  }

  login() {
    this.loginService.login(this.loginForm.value.email,
      this.loginForm.value.password)
      .subscribe(user=> alert(`Bem vindo(a) ${user.name}, seu token é: ${user.token}`),
                 response=> alert('Dados inválidos'))
  }




}
