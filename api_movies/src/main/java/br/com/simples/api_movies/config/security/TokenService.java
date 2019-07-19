package br.com.simples.api_movies.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.com.simples.api_movies.models.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${movies.jwt.expiration}")
	private String expiration;

	@Value("${movies.jwt.secret}")
	private String secret;

	public String gerarToken(UserDetails username) {
		Date hoje = new Date();
		Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));

		// está retornando um método da classe Jwts que podemos inserir parâmetros de
		// execução para a geração do token.
		return Jwts.builder().setIssuer("API do MOVIES").setSubject(username.getUsername().toString()).setIssuedAt(hoje)
				.setExpiration(dataExpiracao).signWith(SignatureAlgorithm.HS256, secret).compact();
	}

}
