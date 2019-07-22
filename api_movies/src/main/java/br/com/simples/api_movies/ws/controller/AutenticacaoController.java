package br.com.simples.api_movies.ws.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.simples.api_movies.config.security.AutenticacaoService;
import br.com.simples.api_movies.config.security.TokenService;
import br.com.simples.api_movies.models.TokenDto;
import br.com.simples.api_movies.ws.forms.FormLogin;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

	// para fazer a autenticação manual, devemos utilizar a classe do spring abaixo
	// porém essa classe não vem configurada para injeção de dependências, por isso
	// configuramos ela na classe SecurityConfigurations

	@Autowired
	private AutenticacaoService autentica;

	@Autowired
	private TokenService tokenService;

	@PostMapping
	@ResponseBody
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid FormLogin formLogin) {
		UsernamePasswordAuthenticationToken dadosLogin = new UsernamePasswordAuthenticationToken(formLogin.getEmail(),
				formLogin.getPassword());
		try {
			UserDetails user = autentica.loadUserByUsername(dadosLogin.getPrincipal().toString());
			String accessToken = tokenService.gerarToken(user);

			return ResponseEntity.ok(new TokenDto(dadosLogin.getName(), user.getUsername(), accessToken));
		} catch (org.springframework.security.core.AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}

	}
}
