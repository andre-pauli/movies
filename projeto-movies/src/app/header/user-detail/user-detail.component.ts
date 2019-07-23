import { Component, OnInit, Input } from '@angular/core';
import { User } from 'src/app/login/user.model';
import { LoginService } from 'src/app/login/loginService';

@Component({
  selector: 'mv-user-detail',
  templateUrl: './user-detail.component.html'
})
export class UserDetailComponent implements OnInit {

  constructor(private loginService: LoginService) { }

  // user(): User {
  //   return this.loginService.user
  // }

  user: string = "André"

  ngOnInit() {
  }

}
