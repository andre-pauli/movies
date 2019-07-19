import { Component, OnInit, Input } from '@angular/core';
import { Filme } from './filme.model';

@Component({
  selector: 'mv-filme',
  templateUrl: './filme.component.html'
})
export class FilmeComponent implements OnInit {

  @Input() filme: Filme

  constructor() { }

  ngOnInit() {

  }

}
