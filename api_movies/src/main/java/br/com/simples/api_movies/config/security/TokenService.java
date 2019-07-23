package br.com.simples.api_movies.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
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
		
		System.out.println("Novo token!");
		return Jwts.builder().setIssuer("API do MOVIES").setSubject(username.getUsername().toString()).setIssuedAt(hoje)
				.setExpiration(dataExpiracao).signWith(SignatureAlgorithm.HS256, secret).compact();
		
	}

	public boolean isTokenValid(String token) {

		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String getEmailUser(String token) {
		Claims body = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return body.getSubject();
	}

}
