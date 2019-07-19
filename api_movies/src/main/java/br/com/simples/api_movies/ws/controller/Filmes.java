package br.com.simples.api_movies.ws.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.simples.api_movies.models.Filme;

public class Filmes {

	@JsonProperty(value = "Search")
	private List<Filme> search;

	public List<Filme> getSearch() {
		return search;
	}

	public void setSearch(List<Filme> search) {
		this.search = search;
	}

}
