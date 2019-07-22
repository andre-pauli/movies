import { Component, OnInit, Input } from '@angular/core';
import { User } from './user.model';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { LoginService } from './loginService';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'mv-login',
  templateUrl: './login.component.html'
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup

  navigateTo: string

  constructor(private fb: FormBuilder,
    private loginService: LoginService,
    private activateRoute: ActivatedRoute,
    private router: Router) { }



  ngOnInit() {
    this.loginForm = this.fb.group({
      password: this.fb.control('', [Validators.required]),
      email: this.fb.control('', [Validators.required, Validators.email]),
    })
    this.navigateTo = this.activateRoute.snapshot.params['to'] || btoa('/')
  }

  login() {
    this.loginService.login(this.loginForm.value.email,
      this.loginForm.value.password)
      .subscribe(() => this.router.navigate([atob(this.navigateTo)]))
  }
}
