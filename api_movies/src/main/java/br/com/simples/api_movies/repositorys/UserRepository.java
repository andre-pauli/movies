package br.com.simples.api_movies.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.simples.api_movies.models.User;

public interface UserRepository extends JpaRepository<User, String> {

	Optional<User> findByEmail(String email);
}
