package br.com.simples.api_movies.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.simples.api_movies.models.User;
import br.com.simples.api_movies.repositorys.UserRepository;

@Service
public class AutenticacaoService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	// esse método é carregado quando o usuário preenche o form de login, já que o
	// spring sabe que ele é um service de login
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// é utilizado o optional, pois pode ser q o usuário não exista, ai o find
		// retona um erro
		Optional<User> userBanco = userRepository.findByEmail(username);

		if (userBanco.isPresent()) {
			return userBanco.get();
		}
		throw new UsernameNotFoundException("Dados inválidos!!");
	}

}
