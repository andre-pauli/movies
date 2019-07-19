package br.com.simples.api_movies.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.simples.api_movies.models.Filme;

public interface FilmeRepository extends JpaRepository<Filme, String> {

	Filme findByimdbID(String imdbID);

	List<Filme> findByTitleContainingIgnoreCase(String title);
}
