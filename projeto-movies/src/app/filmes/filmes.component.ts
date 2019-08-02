import { Component, OnInit } from '@angular/core';
import { Filme } from './filme/filme.model';
import { FilmesService } from './filmes.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'mv-filmes',
  templateUrl: './filmes.component.html'
})

export class FilmesComponent implements OnInit {

  filmes: Filme[] 
  mensagem: string

  constructor(private filmesService: FilmesService, formModule: FormsModule) { }

  ngOnInit() {

  }

  title: string
  findByTitle() {
    this.filmesService.getFilmesByTitle(this.title)
      .subscribe(
        filme =>{ this.filmes = filme },
        () => { this.filmes = undefined })
  }
  findInApi() {
    this.filmesService.getFilmesInApi(this.title)
      .subscribe(filme => this.filmes = filme)
  }
}

