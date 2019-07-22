package br.com.simples.api_movies.models;

public class TokenDto {

	private String name;
	private String email;
	private String accessToken;

	public TokenDto(String name, String email, String accessToken) {
		super();
		this.email = email;
		this.name = name;
		this.accessToken = accessToken;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getToken() {
		return accessToken;
	}

	public void setToken(String token) {
		this.accessToken = token;
	}

}
