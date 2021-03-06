package br.com.simples.api_movies.ws.forms;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class FormLogin {

	private String email;
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(this.email, this.password);
	}

}
