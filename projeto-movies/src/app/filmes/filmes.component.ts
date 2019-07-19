import { Component, OnInit } from '@angular/core';
import { Filme } from './filme/filme.model';
import { FilmesService } from './filmes.service';
import { FormsModule } from '@angular/forms';
import { FormBuilder, FormGroup, FormControl, NgModel } from '@angular/forms';

@Component({
  selector: 'mv-filmes',
  templateUrl: './filmes.component.html'
})

export class FilmesComponent implements OnInit {

  filmes: Filme[]

  constructor(private filmesService: FilmesService, formModule: FormsModule) { }

  ngOnInit() {
    // this.filmesService.getFilmes()
    //   .subscribe(filme => this.filmes = filme)
    // this.findByTitle()
  }

  title: string
  findByTitle() {
    this.filmesService.getFilmesByTitle(this.title)
      .subscribe(filme => this.filmes = filme)
  }
  findInApi(){
    this.filmesService.getFilmesInApi(this.title)
      .subscribe(filme => this.filmes = filme)    
  } 
}

