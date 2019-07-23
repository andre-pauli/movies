package br.com.simples.api_movies.config.security;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.simples.api_movies.models.User;
import br.com.simples.api_movies.repositorys.UserRepository;

//a classe que herdamos é uma classe própria do spring, que é chamada uma unica vez a cada requisição!
public class AutenticacaoTokenFilter extends OncePerRequestFilter {

	private TokenService tokenService;
	private UserRepository userRepository;

	public AutenticacaoTokenFilter(TokenService tokenService, UserRepository userRepository) {
		super();
		this.tokenService = tokenService;
		this.userRepository = userRepository;
	}

	// devemos implementar esse método validar o token que o usuário manda junto com
	// a requisição
	// e se estiver tudo correto, a ultima linha do método informa para o spring que
	// ele pode continuar com a requisição.
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// devemos novamente recuperar o token, pois estamos utilizando o modelo
		// stateless, então a nossa api não sabe qual é
		// o token do usuário, já que não salvamos nada no banco de dados, o user deve
		// mandar o token em todas as próximas
		// requisições.

		String token = recuperarToken(request);

		boolean valid = tokenService.isTokenValid(token);
		if (valid) {
			autenticarCliente(token);
		}

		// diz para o spring que ele pode seguir com a requisição!
		filterChain.doFilter(request, response);
	}

	private void autenticarCliente(String token) {

		String emailUsuario = tokenService.getEmailUser(token);

		Optional<User> usuario = userRepository.findByEmail(emailUsuario);

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null,
				usuario.get().getAuthorities());

		SecurityContextHolder.getContext().setAuthentication(authentication);		

	}

	private String recuperarToken(HttpServletRequest request) {
		// o request tem esse método, que consegue pegar o header da requisição
		String token = request.getHeader("Authorization");

		// aqui verificamos se o token não é nulo nem vazio e se começa com algo
		// diferente de Bearer
		if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}

		return token.substring(7, token.length());
	}

}
