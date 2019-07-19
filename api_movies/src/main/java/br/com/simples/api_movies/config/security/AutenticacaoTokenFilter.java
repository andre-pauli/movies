//package br.com.simples.api_movies.config.security;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.web.filter.OncePerRequestFilter;
//
//public class AutenticacaoTokenFilter extends OncePerRequestFilter {
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//
//		String token = recuperarToken(request);
//		System.out.println(token);
//
//		// diz para o spring que ele pode seguir com a requisição!
//		filterChain.doFilter(request, response);
//	}
//
//	private String recuperarToken(HttpServletRequest request) {
//		// o request tem esse método, que consegue pegar o header da requisição
//		String token = request.getHeader("Authorization");
//		// aqui verificamos se o token não é nulo nem vazio e se começa com algo
//		// diferente de Bearer
//		if (token == null || token.isEmpty() || token.startsWith("Bearer ")) {
//			return null;
//		}
//
//		return token.substring(7, token.length());
//	}
//
//}
