package br.com.simples.api_movies.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.simples.api_movies.models.Filme;
import br.com.simples.api_movies.repositorys.FilmeRepository;

@Controller
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class FilmesController {

	@Autowired
	FilmeRepository filmeRepository;

	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@GetMapping("/filme/{title}")
	public List<Filme> listaFilmeTitle(@PathVariable(value = "title") String title) {
		return filmeRepository.findByTitleContainingIgnoreCase(title);
	}

	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@GetMapping("/filme/api/{title}")
	public List<Filme> listaFilmeTitleApi(@PathVariable(value = "title") String title) {

		RestTemplate template = new RestTemplate();
		UriComponents uri = UriComponentsBuilder.newInstance().scheme("http").host("www.omdbapi.com")
				.queryParam("s", title).queryParam("apikey", "11685a21").build();

		Filmes filmesApi = template.getForObject(uri.toUriString(), Filmes.class);
		List<Filme> filmesBanco = filmeRepository.findByTitleContainingIgnoreCase(title);

		if (filmesBanco.isEmpty()) {
			for (Filme filme : filmesApi.getSearch()) {
				filmeRepository.save(filme);
			}
		} else {
			for (Filme filmeBanco : filmesBanco) {
				for (Filme filmeApi : filmesApi.getSearch()) {
					if (!filmeBanco.getImdbID().contains(filmeApi.getImdbID())) {
						filmeRepository.save(filmeApi);
					}
				}
			}
		}
		return filmeRepository.findByTitleContainingIgnoreCase(title);
	}
}
