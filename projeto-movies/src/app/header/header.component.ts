import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'mv-header',
  templateUrl: './header.component.html'
})
export class HeaderComponent implements OnInit {

  nome: string = "André"

  constructor() { }

  ngOnInit() {
  }

}